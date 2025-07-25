package com.tap.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Model.Restaurant;

public class RestaurantDAOImpl  implements RestaurantDAO{
	
	public String url="jdbc:mysql://localhost:3306/restaurant";
	public String userName="root";
	public String password="Tiger";
	public Connection con;
	public Statement stmt;
	public PreparedStatement pstmt;
	public ResultSet result;
	public String selectAll="SELECT * FROM `restaurant`";
	public String select="SELECT * FROM `restaurant` WHERE `restaurantId`=?";
	public String insert="INSERT INTO `restaurant`(`restaurantId`, `name`, `address`, `phoneNumber`, `cusineType`, `deliveryTime`, `adminUserId`, `rating`, `isActive`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public String update="UPDATE `restaurant` SET `name`=?, `address`=?, `phoneNumber`=?, `cusineType`=?, `deliveryTime`=?, `adminUserId`=?, `rating`=?, `isActive`=? WHERE `restaurantId`=?";
	public String delete="DELETE FROM `restaurant` WHERE `restaurantid`=?";
	@Override
	public List<Restaurant> getAllRestaurant() {
		List<Restaurant> list=new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			stmt = con.createStatement();
			result = stmt.executeQuery(selectAll);
			while(result.next()) {
				int restaurantId =result.getInt("restaurantId");
				String name=result.getString("name");
				String address=result.getString("address");
				String phoneNumber=result.getString("phoneNumber");
				String cusineType=result.getString("cusineType");
				String deliveryTime=result.getString("deliveryTime");
				int adminUserId=result.getInt("adminUserId");
				float rating=result.getFloat("rating");
				String isActive=result.getString("isActive");
				String imagePath=result.getString("imagePath");
				
				Restaurant res = new Restaurant(restaurantId, name, address, phoneNumber, cusineType, deliveryTime, adminUserId, rating, isActive, imagePath);
				
				list.add(res);	
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

	@Override
	public Restaurant getRestaurant(int rId) {
		Restaurant res=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			pstmt = con.prepareStatement(select);
			pstmt.setInt(1, rId);
			result =pstmt.executeQuery();
			while(result.next()) {
				int restaurantId =result.getInt("restaurantId");
				String name=result.getString("name");
				String address=result.getString("address");
				String phoneNumber=result.getString("phoneNumber");
				String cusineType=result.getString("cusineType");
				String deliveryTime=result.getString("deliveryTime");
				int adminUserId=result.getInt("adminUserId");
				float rating=result.getFloat("rating");
				String isActive=result.getString("isActive");
				String imagePath=result.getString("imagePath");
				
				res = new Restaurant(restaurantId, name, address, phoneNumber, cusineType, deliveryTime, adminUserId, rating, isActive, imagePath);	
			}
			
			
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int addRestaurant(Restaurant res) {
		int result=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, res.getRestaurantId());
			pstmt.setString(2, res.getName());
			pstmt.setString(3, res.getAddress());
			pstmt.setString(4, res.getPhoneNumber());
			pstmt.setString(5, res.getCusineType());
			pstmt.setString(6, res.getDeliveryTime());
			pstmt.setInt(7, res.getAdminUserId());
			pstmt.setFloat(8, res.getRating());
			pstmt.setString(9, res.getIsActive());
			result = pstmt.executeUpdate();
			
			
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateRestaurant(Restaurant res) {
		int result=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, res.getName());
			pstmt.setString(2, res.getAddress());
			pstmt.setString(3, res.getPhoneNumber());
			pstmt.setString(4, res.getCusineType());
			pstmt.setString(5, res.getDeliveryTime());
			pstmt.setInt(6, res.getAdminUserId());
			pstmt.setFloat(7, res.getRating());
			pstmt.setString(8, res.getIsActive());
			pstmt.setInt(9, res.getRestaurantId());
			result = pstmt.executeUpdate();
			
			
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteRestaurant(int restaurantId) {
		int result=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, restaurantId);
			result = pstmt.executeUpdate();
			
			
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	
}
