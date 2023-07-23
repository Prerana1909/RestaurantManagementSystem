package com.rms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rms.entity.Customer;
import com.rms.model.CustomerDTO;
import com.rms.service.CustomerService;
import com.rms.util.CustomerConverter;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerConverter converter; 

	//build save method using Rest API
	@PostMapping("/saveCustomer")
	public CustomerDTO saveCustomer(@Valid @RequestBody CustomerDTO customerDto )
	{
		final Customer customer=converter.convertToCustomerEntity(customerDto);
		return customerService.saveCustomer(customer);
	}
	
	//build get customer details using contact REST API
	@GetMapping
	public CustomerDTO getCustomerByContactDetails(@PathVariable("contactDetails")String contactDetails)
	{
		return customerService.getCustomerByContactDetails(contactDetails);
	}
}
