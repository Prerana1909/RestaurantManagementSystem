package com.rms.service;

import com.rms.entity.Order;
import com.rms.model.OrderDTO;

public interface OrderService {

	//method used to save order details
	OrderDTO saveOrder(Order order);
	
	//method to fetch order using id
	OrderDTO getOrderById(int orderId);
	
    //method used to delete using id
	void deleteOrderById(int orderId);
	

	//method to assign menu to order
	OrderDTO assignMenuToOrder(int menuId,int orderId);
	
}
