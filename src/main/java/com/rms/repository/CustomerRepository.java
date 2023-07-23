package com.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rms.entity.Customer;

//inheriting CRUD operations 

public interface CustomerRepository extends JpaRepository<Customer,Long>{

	Customer findByContactDetails(String contactDetails);
}


