package com.cg.ecom.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.ecom.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>
{

	Optional<Customer> findByCustomerEmailIdAndCustomerPassword( String customerEmailId, String customerPassword);

	Optional<Customer> findByCustomerEmailId( String customerEmailId);

	
	
}