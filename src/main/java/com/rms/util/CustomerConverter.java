package com.rms.util;

import org.springframework.beans.BeanUtils;

import com.rms.entity.Customer;
import com.rms.model.CustomerDTO;


public class CustomerConverter {

	//convert customer entity into customerDTO
		public CustomerDTO convertToCustomerDTO(Customer customer)
		{
			CustomerDTO customerDto = new CustomerDTO();
			if(customer!=null)
			{
				BeanUtils.copyProperties(customer, customerDto);
			}
			
			return customerDto;
		}
		
		//convert customerDTO to customer entity
		public Customer convertToCustomerEntity(CustomerDTO customerDto)

		{
			Customer customer = new Customer();
			if(customerDto!=null)
			{
				BeanUtils.copyProperties(customerDto, customer);
			}
			
			return customer;
		}
	}

