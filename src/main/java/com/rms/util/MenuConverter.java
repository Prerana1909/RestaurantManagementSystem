package com.rms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.rms.entity.Menu;
import com.rms.model.MenuDTO;

@Component
public class MenuConverter {
	
	//convert menu entity into menuDTO
	public MenuDTO convertToMenuDTO(Menu menu)
	{
		MenuDTO menuDto = new MenuDTO();
		if(menu!=null)
		{
			BeanUtils.copyProperties(menu, menuDto);
		}
		
		return menuDto;
	}
	
	//convert menuDTO to menu entity
	public Menu convertToMenuEntity(MenuDTO menuDto)

	{
		Menu menu = new Menu();
		if(menuDto!=null)
		{
			BeanUtils.copyProperties(menuDto, menu);
		}
		
		return menu;
	}
}
