package com.tap.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.Model.User;

	public class UserDAOImpl implements UserDAO {
		private String insert="INSERT INTO `user` (`name`, `userName`, `password`, `email`, `phoneNumber`, `address`, `role`, `createdDate`, `lastLoginDate`) VALUES (?,?,?,?,?,?,?,?,?)";
		private String update="INSERT INTO `user` SET  `name` = ? , `userName`=?, `password`=?, `email`=?, `phoneNumber`=?, `address`=? WHERE `userId`=? ";
		private String select="SELECT * FROM `user` WHERE `userId`=?";
		private String selectAll = "SELECT * FROM `user`";
		private String delete="DELETE FROM `user` WHERE `userId`=?";
		public Connection con;
		public PreparedStatement pstmt;
		public Statement stmt;
		public ResultSet result;
		public int res;
		public String url = "jdbc:mysql://localhost:3306/restaurant";
		public String userName="root";
		public String password="Tiger";
		

		@Override
		public List<User> getAllUsers() {
			List<User> list = new ArrayList<>();
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url, userName, password);
				pstmt = con.prepareStatement(selectAll);
				result = pstmt.executeQuery();
				while(result.next()) {
					int userId = result.getInt("userId");
					String name = result.getString("name");
					String username = result.getString("userName");
					String pass = result.getString("password");
					String email = result.getString("email");
					String phone = result.getString("phoneNumber");
					String address = result.getString("address");
					String role = result.getString("role");
					Timestamp createdDate = result.getTimestamp("createdDate");
					Timestamp lastLoginDate = result.getTimestamp("lastLoginDate");
					
				User u = new User(userId, name, username, pass, email, phone, address, role, createdDate, lastLoginDate);
				list.add(u);
				
				}
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			} 
			
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
			return list;
		}

		@Override
		public User getUser(int id) {
			User u = null;
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url, userName, password);
				pstmt = con.prepareStatement(select);
				pstmt.setInt(1,id);
				result = pstmt.executeQuery();
				while(result.next()) {
					String name = result.getString("name");
					String username = result.getString("userName");
					String pass = result.getString("password");
					String email = result.getString("email");
					String phone = result.getString("phoneNumber");
					String address = result.getString("address");
					String role = result.getString("role");
					Timestamp createdDate = result.getTimestamp("createdDate");
					Timestamp lastLoginDate = result.getTimestamp("lastLoginDate");
					
				u = new User(name, username, pass, email, phone, address, role, createdDate, lastLoginDate);
				}
			}
			
			catch(SQLException e) {
				e.printStackTrace();
			} 
			
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			return u;
		}

		@Override
		public int addUser(User user) {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url, userName, password);
				PreparedStatement pstmt = con.prepareStatement(insert);
//				pstmt.setInt(1,user.getUserID());
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getUserName());
				pstmt.setString(3, user.getPassword());
				pstmt.setString(4, user.getEmail());
				pstmt.setString(5, user.getPhoneNumber());
				pstmt.setString(6, user.getAddress());
				pstmt.setString(7, user.getRole());
				pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
				pstmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));


				int res = pstmt.executeUpdate();
			

			} 
			
			catch (SQLException e) {
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}

			return res;

		}

		@Override
		public int updateUser(User user) {
			try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection(url, userName, password);
					PreparedStatement pstmt = con.prepareStatement(update);
					pstmt.setString(1, user.getName());
					pstmt.setString(2, user.getUserName());
					pstmt.setString(3, user.getPassword());
					pstmt.setString(4, user.getEmail());
					pstmt.setString(5, user.getPhoneNumber());
					pstmt.setString(6, user.getAddress());
					pstmt.setInt(7,user.getUserId());

					int res = pstmt.executeUpdate();
					
				}
			
				catch (SQLException e) {
					e.printStackTrace();
				}
			
			    catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			return res;

		}

		@Override
		public int deleteUser(int id) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url, userName, password);
				PreparedStatement pstmt = con.prepareStatement(delete);
//				System.out.println("execute");
				pstmt.setInt(1, id);
				
				int res = pstmt.executeUpdate();
			}
			
			catch (SQLException e) {
				e.printStackTrace();
			} 
			
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		return res;

		}
		

	}

