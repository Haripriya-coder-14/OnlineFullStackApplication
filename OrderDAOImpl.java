package com.tap.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.Model.Order;

public class OrderDAOImpl implements OrderDAO {

	public Connection con;
	public PreparedStatement pstmt;
	public Statement stmt;
	public ResultSet result;
	public int res;
	public String insert = "INSERT INTO `order`(`restaurantId`, `userId`, `orderDate`, `totalAmount`, `status`, `paymentMode`, `address`) VALUES (?,?,?,?,?,?,?)";
	public String select = "SELECT * FROM `order` WHERE `userId`=?";
	public String url = "jdbc:mysql://localhost:3306/restaurant";
	public String userName="root";
	public String password="Tiger";
	private int orderId;
	
	
	public List<Order> getOrderByUserId(int userId) {
		List<Order> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, userId);
			result = pstmt.executeQuery();
			while(result.next()) {
				int orderId = result.getInt("orderId");
				int restaurantId = result.getInt("restaurantId");
				Timestamp orderDate = result.getTimestamp("orderDate");
				double totalAmount = result.getDouble("totalAmount");
				String status = result.getString("status");
				String paymentMode = result.getString("paymentMode");
				String address = result.getString("address");
				
				Order order = new Order(orderId, restaurantId, orderDate, totalAmount, status, paymentMode, address);
				list.add(order);
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


	public int addOrder(Order order) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			pstmt = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, order.getRestaurantId());
			pstmt.setInt(2, order.getUserId());
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setDouble(4, order.getTotalAmount());
			pstmt.setString(5, order.getStatus());
			pstmt.setString(6, order.getPaymentMode());
			pstmt.setString(7, order.getAddress());
			res = pstmt.executeUpdate();
			result = pstmt.getGeneratedKeys();
			
			System.out.println("Your orders are added successfully "+res);
			
			while(result.next()) {
				orderId = result.getInt(1);
			}
				
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return orderId;
		
	}

}
