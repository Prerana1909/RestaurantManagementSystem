package com.rms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rms.entity.Order;
import com.rms.model.OrderDTO;
import com.rms.service.OrderService;
import com.rms.util.OrderConverter;

public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderConverter converter;
	
	//build save method using REST API
	@PostMapping("/saveOrder")
	public OrderDTO saveOrder(@RequestBody @Valid OrderDTO orderDto)
	{
		Order order = converter.convertToOrderEntity(orderDto);
		return orderService.saveOrder(order);
	}
    
	//build to fetch order by id using REST API
	@GetMapping("/getOrderById/{orderId}")
	public OrderDTO getOrderById(@PathVariable("orderId")int id)
	{
		return orderService.getOrderById(id);
	}
	
	//build delete order using id REST API
	@DeleteMapping("/deleteOrder/{orderId}")
	public ResponseEntity<String> deleteOrderById(@PathVariable("orderId") int orderId)

	{
		orderService.deleteOrderById(orderId);
		return new ResponseEntity<String>("Order details with id "+orderId+" "+"deleted successfully",HttpStatus.OK);
		
	}
	
	//build to assign menu to order
	@PostMapping("/assignMenu/{menuId}/toOrder/{orderId}")
	public OrderDTO assignOrderToMenu(@PathVariable("menuId") int menuId,
			@PathVariable("orderId") int orderId)
	{
		return orderService.assignMenuToOrder(menuId, orderId);
	}
}
