package com.rms.service;

import com.rms.entity.Customer;
import com.rms.model.CustomerDTO;

public interface CustomerService {

	//method to save customer details
	CustomerDTO saveCustomer(Customer customer);
	
	//method to fetch customer details using contact details
	CustomerDTO getCustomerByContactDetails(String contactDetails);
}
