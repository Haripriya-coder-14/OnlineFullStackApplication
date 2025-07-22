package com.tap.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Model.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO {
	
	public Connection con;
	public PreparedStatement pstmt;
	public Statement stmt;
	public ResultSet result;
	public int res;
	public String insert = "INSERT INTO `orderItem` (`orderId`, `menuId`, `quantity`, `price`, `totalAmount`) VALUES (?, ?, ?, ?, ?)";
	public String selectAll = "SELECT * FROM `orderItem`";
	public String select = "SELECT * FROM `orderItem` WHERE `orderId`=?";
	public String url = "jdbc:mysql://localhost:3306/restaurant";
	public String userName="root";
	public String password="Tiger";

	
	public OrderItem getOrderItem() {
		OrderItem orderItem = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			pstmt = con.prepareStatement(selectAll);
			result = pstmt.executeQuery();
			int orderId = result.getInt("orderId");
			int menuId = result.getInt("menuId");
			int quantity = result.getInt("quantity");
			double price = result.getDouble("price");
			double totalAmount = result.getDouble("totalAmount");
			
			orderItem = new OrderItem(orderId, menuId, quantity,price, totalAmount);
			
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return orderItem;
	}

	public List<OrderItem> getOrderItemByOrderId(int orderId) {
		List<OrderItem> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, orderId);
			result = pstmt.executeQuery();
			while(result.next()) {
				int menuId = result.getInt("menuId");
				int quantity = result.getInt("quantity");
				double price = result.getDouble("price");
				double totalAmount = result.getDouble("totalAmount");
				
				OrderItem orderItem = new OrderItem(menuId, quantity,price, totalAmount);
				
				list.add(orderItem);
			}
			
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int addOrderItem(OrderItem orderItem) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, orderItem.getOrderId());
			pstmt.setInt(2,  orderItem.getMenuId());
			pstmt.setInt(3, orderItem.getQuantity());
			pstmt.setDouble(4, orderItem.getPrice());
			pstmt.setDouble(5, orderItem.getTotalAmount());
			
			res = pstmt.executeUpdate();
			System.out.println("Your order item is added successfully "+res);
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
