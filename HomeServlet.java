package com.tap.Servlet;

import java.io.IOException;
import java.util.List;

import com.tap.DAO.RestaurantDAOImpl;
import com.tap.Model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantDAOImpl dao = new RestaurantDAOImpl();
		List<Restaurant> allRestaurants = dao.getAllRestaurant();
		for(Restaurant allRestaurant : allRestaurants) {
			System.out.println(allRestaurant);
		}
		HttpSession session = req.getSession();
		
		req.setAttribute("allRestaurants", allRestaurants);
		RequestDispatcher rd = req.getRequestDispatcher("restaurant.jsp");
		rd.forward(req, resp);
		
	}
}
