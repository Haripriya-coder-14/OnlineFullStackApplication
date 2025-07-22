package com.tap.DAO;

import java.util.List;

import com.tap.Model.Restaurant;

interface RestaurantDAO {
	List<Restaurant> getAllRestaurant();
	Restaurant getRestaurant(int restaurantId);
	int addRestaurant(Restaurant res);
	int updateRestaurant(Restaurant res);
	int deleteRestaurant(int restaurantId);
	
}
