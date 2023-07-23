package com.rms.serviceimpl;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.entity.Menu;
import com.rms.entity.Order;
import com.rms.exception.ResourceNotFoundException;
import com.rms.model.OrderDTO;
import com.rms.repository.MenuRepository;
import com.rms.repository.OrderRepository;
import com.rms.service.OrderService;
import com.rms.util.OrderConverter;

@Service
public class OrderServiceImpl implements OrderService {
	
	//logger statically created
	private static final Logger log = (Logger) LoggerFactory.getLogger(Order.class);

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderConverter orderConverter;
	
	@Autowired
	MenuRepository menuRepository;
	
	@Override
	public OrderDTO saveOrder(Order order) {
		orderRepository.save(order);
		return orderConverter.convertToOrderDTO(order);
	}
	
	//method used to fetch order details using order id
	public OrderDTO getOrderById(int orderId) throws ResourceNotFoundException
	{
		Order order=orderRepository.findById((long) orderId).orElseThrow(()->new ResourceNotFoundException("Order", "Id", order));
		log.info("Order details with id"+orderId+"was fetched at "+new Date());
	    return orderConverter.convertToOrderDTO(order);
	}
	
	//method used to assign menu to order
	@Override
	public OrderDTO assignMenuToOrder(int menuId, int orderId)  throws ResourceNotFoundException{
		
		{	
			Menu menu = menuRepository.findById((long) menuId).orElseThrow(()->
			new ResourceNotFoundException("Menu", "Id", menuId));
			
			Order order = orderRepository.findById((long) orderId).orElseThrow(()->
			new ResourceNotFoundException("Order", "Id", orderId));
			
			menu.setOrder(order);
			
			menuRepository.save(menu);
			orderRepository.save(order);
			
			return orderConverter.convertToOrderDTO(order);
		}
	}
}
