package com.tap.DAO;

import java.util.List;

import com.tap.Model.Order;

public interface OrderDAO {

	List<Order> getOrderByUserId(int userId);
	int addOrder(Order order);
}
