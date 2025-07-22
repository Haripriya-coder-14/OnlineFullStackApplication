
//Menu Servlet

package com.tap.Servlet;

import java.io.IOException;
import java.util.List;

import com.tap.DAO.MenuDAOImpl;
import com.tap.DAO.RestaurantDAOImpl;
import com.tap.Model.Menu;
import com.tap.Model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int rId = Integer.parseInt(req.getParameter("restaurantId"));		
				RestaurantDAOImpl rdao = new RestaurantDAOImpl();
		Restaurant restaurant = rdao.getRestaurant(rId);
		
		System.out.println(restaurant);
		
		MenuDAOImpl mdao = new MenuDAOImpl();
		List<Menu> allMenusOfRestaurant = mdao.getAllMenusOfRestaurant(rId);
		
		for(Menu menu : allMenusOfRestaurant) {
			System.out.println(menu);
		}
		
		req.setAttribute("restaurant", restaurant);
		req.setAttribute("allMenusOfRestaurant", allMenusOfRestaurant);
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.forward(req, resp);
	}
}
