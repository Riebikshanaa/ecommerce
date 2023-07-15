package com.cg.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ecom.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>

{
	List<Order> findByCustomerCustomerId(long customerId);
}