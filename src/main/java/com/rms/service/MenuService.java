package com.rms.service;

import java.util.List;

import com.rms.entity.Menu;
import com.rms.model.MenuDTO;

public interface MenuService {

	//method used to save menu
	MenuDTO saveMenu(Menu menu);
	
	//method used to fetch all menu
	List<MenuDTO> getAllMenu();
	
	//method to assign menu to order
	MenuDTO assignMenuToOrder(int menuId,int orderId);
}
