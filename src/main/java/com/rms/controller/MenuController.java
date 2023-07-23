package com.rms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rms.entity.Menu;
import com.rms.model.MenuDTO;
import com.rms.service.MenuService;
import com.rms.util.MenuConverter;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	MenuConverter converter;
	
	//build save method using Rest API
	@PostMapping("/saveMenu")
	public MenuDTO saveMenu(@Valid @RequestBody MenuDTO menuDto)
	{
		final Menu menu=converter.convertToMenuEntity(menuDto);
		return menuService.saveMenu(menu);
	}
	
	//build get all menu details using REST API
	@GetMapping("/getAllMenu")
	public List<MenuDTO> getAllMenu()
	{
		return menuService.getAllMenu();
	}
	
	//build assign menu to order using REST API
	@PostMapping("/assignMenu/{menuId}/toOrder/{orderId}")
	public MenuDTO assignMenuToOrder(@PathVariable("menuId") int menuId, @PathVariable("orderId") int orderId )
	{
         return menuService.assignMenuToOrder(menuId, orderId);		
	}

}
