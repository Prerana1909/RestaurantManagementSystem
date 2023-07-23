package com.rms.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.entity.Customer;
import com.rms.exception.AlreadyExistingException;
import com.rms.exception.ResourceNotFoundException;
import com.rms.model.CustomerDTO;
import com.rms.repository.CustomerRepository;
import com.rms.service.CustomerService;
import com.rms.util.CustomerConverter;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	//logger statically created
	 static final Logger log = (Logger) LoggerFactory.getLogger(Customer.class);  

	@Autowired //injecting
	CustomerRepository customerRepository;
	
	CustomerConverter converter;
	
	@Override
	public CustomerDTO saveCustomer(Customer customer) throws AlreadyExistingException
	{
		List<Customer> customers = customerRepository.findAll();
		for(Customer c: customers)
			{
			if(c.getContactDetails().equals(customer.getContactDetails()))
				{
				      throw new AlreadyExistingException("Customer already exist.");
				}
				}
		customerRepository.save(customer);
		return converter.convertToCustomerDTO(customer);
			}
	
	//method used to fetch customer details using customer id
	@Override
	public CustomerDTO getCustomerByContactDetails(String contactDetails) throws ResourceNotFoundException
	{
		Customer customer = customerRepository.findByContactDetails(contactDetails);
		if(customer!=null)
		{
			return converter.convertToCustomerDTO(customer);
		}
		else
		{
			throw new ResourceNotFoundException("Customer","Contact Details",contactDetails);
		}
		
	}

	
}
