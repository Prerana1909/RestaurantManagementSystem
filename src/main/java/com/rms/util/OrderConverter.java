package com.rms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.rms.entity.Order;
import com.rms.model.OrderDTO;

@Component
public class OrderConverter {

	//convert order entity into orderDTO
	public OrderDTO convertToOrderDTO(Order order)
	{
		OrderDTO orderDto = new OrderDTO();
		if(order!=null)
		{
			BeanUtils.copyProperties(order, orderDto);
		}
		return orderDto;
	}
	
	//convert orderDTO to order entity
	public Order convertToOrderEntity(OrderDTO orderDto)
	{
		Order order = new Order();
		if(orderDto!=null)
		{
			BeanUtils.copyProperties(orderDto, order);
		}
		return order;
	}
}
