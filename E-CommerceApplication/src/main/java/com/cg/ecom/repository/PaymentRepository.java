package com.cg.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ecom.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>

{

}
