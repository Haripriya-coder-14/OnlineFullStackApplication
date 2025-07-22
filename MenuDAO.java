package com.tap.DAO;

import java.util.List;

import com.tap.Model.Menu;

public interface MenuDAO {
	List<Menu> getAllMenus();
	List<Menu> getAllMenusOfRestaurant(int restaurantId);
	int addMenu(Menu menu);
	int updateMenu(Menu menu);
	int deleteMenu(int menuId);
	Menu getMenu(int menuId);
	
}


