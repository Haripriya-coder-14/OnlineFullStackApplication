package com.tap.DAO;

import java.util.List;

import com.tap.Model.OrderItem;

public interface OrderItemDAO {

	OrderItem getOrderItem();
	List<OrderItem> getOrderItemByOrderId(int orderId);
	int addOrderItem(OrderItem orderItem);
}
