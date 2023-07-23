package com.rms.serviceimpl;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.entity.Menu;
import com.rms.entity.Order;
import com.rms.exception.ResourceNotFoundException;
import com.rms.model.MenuDTO;
import com.rms.repository.MenuRepository;
import com.rms.repository.OrderRepository;
import com.rms.service.MenuService;
import com.rms.util.MenuConverter;


@Service
public class MenuServiceImpl implements MenuService{

	//logger statically created
	private static final Logger log = (Logger) LoggerFactory.getLogger(Menu.class);
	
	@Autowired//injecting
	MenuRepository menuRepository;
	
	@Autowired//injecting
	OrderRepository orderRepository;
	@Autowired
	MenuConverter menuConverter;
	//method used to save order
	public MenuDTO saveMenu(Menu menu) 
	{
		menuRepository.save(menu);
		return menuConverter.convertToMenuDTO(menu);
		
	}
	
	//method used to get all menu details
	public List<MenuDTO> getAllMenu()
	{
		List<Menu> menu=menuRepository.findAll();
		List<MenuDTO> menuDto=new ArrayList<>();
		for(Menu m : menu)
		{
			menuDto.add(menuConverter.convertToMenuDTO(m));
		}
		log.info("All menu details were fetched at"+new Date());
	}
	
	//method to assign menu to order
	public MenuDTO assignMenuToOrder(Long menuId, Long orderId) throws ResourceNotFoundException
	{	
		Menu menu = menuRepository.findById(menuId).orElseThrow(()->
		new ResourceNotFoundException("Menu", "Id", menuId));
		
		Order order = orderRepository.findById(orderId).orElseThrow(()->
		new ResourceNotFoundException("Order", "Id", orderId));
		
		menu.setOrder(order);
		
		
		menuRepository.save(menu);
		orderRepository.save(order);
		
		return menuConverter.convertToMenuDTO(menu);
	}
	
}
