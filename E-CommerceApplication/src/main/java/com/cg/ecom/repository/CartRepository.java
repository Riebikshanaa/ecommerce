package com.cg.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ecom.model.Cart;
import com.cg.ecom.model.Customer;

public interface CartRepository extends JpaRepository<Cart,Long>

{
	void deleteCartByCustomer(Customer c);
}
