package com.cg.ecom.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ecom.exception.ResourceNotFound;
import com.cg.ecom.model.Customer;
import com.cg.ecom.model.Order;

import com.cg.ecom.model.Payment;
import com.cg.ecom.repository.OrderRepository;
import com.cg.ecom.repository.PaymentRepository;

@Service
public class PaymentService 
{
	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerService customerService;

//	@Autowired
//	private OrderService orderService;

	public Payment addPayment(Payment payment, long orderId, long customerId) 
	{
		Order order = orderRepository.findById(orderId) 
				.orElseThrow(() -> new ResourceNotFound("Order", "orderId", orderId));
		payment.setOrderId(orderId);
		payment.setTotalPrice(order.getTotalPrice());
		payment.setPaidDate(LocalDate.now());
		payment.setPaidAmount(order.getTotalPrice());
		if (payment.getTotalPrice() == payment.getPaidAmount()) {
			order.setPaymentStatus("PAID");
			order.setOrderStatus("Delivered");
		} else {

			order.setPaymentStatus("NOT-PAID");
			order.setOrderStatus("payment pending");
		}
		Customer customer = customerService.getCustomerById(customerId);

		payment.setCustomer(customer);

		return paymentRepository.save(payment);

	}

	public List<Payment> getAllPayments() 
	{
		return paymentRepository.findAll();

	}

	public Payment getPaymentById(long paymentId)
	{
		return paymentRepository.findById(paymentId)
				.orElseThrow(() -> new ResourceNotFound("Payement", "Id", paymentId));
	}

	public void deletePayment(long paymentId) 
	{
		paymentRepository.findById(paymentId).orElseThrow(() -> new ResourceNotFound("Payement", "Id", paymentId));
		paymentRepository.deleteById(paymentId);

	}

}
