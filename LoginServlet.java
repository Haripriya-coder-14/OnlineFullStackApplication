package com.tap.Servlet;

import java.io.IOException;
import java.util.List;

import com.tap.DAO.UserDAOImpl;
import com.tap.Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		
		UserDAOImpl user = new UserDAOImpl();
		List<User> allUsers = user.getAllUsers();
		
		System.out.println("login servlet is working fine");
		
		int userId =0;
		
		HttpSession session = req.getSession();
		
		for(User u : allUsers) {
			if(userName.equals(u.getUserName()) && password.equals(u.getPassword())) {
				userId = u.getUserId();	
				session.setAttribute("userId", userId);
				System.out.println("Your user Id is" + userId);
				resp.sendRedirect("home");
				System.out.println("loginServlet going to restaurant jsp");
			}	
		}
		
		if(userId == 0) {
			resp.sendRedirect("signup.jsp");
			System.out.println("loginServlet going to signUp jsp");
		}
	}
}
