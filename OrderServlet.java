package com.tap.Servlet;

import java.io.IOException;
import java.util.List;

import com.tap.DAO.OrderDAOImpl;
import com.tap.Model.Order;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		
		if(userId == null || userId == 0) {
			resp.sendRedirect("login.jsp");
			return;
		}
		
		OrderDAOImpl orderDAO = new OrderDAOImpl();
		List<Order> order = orderDAO.getOrderByUserId(userId);
		
		System.out.println("orders in order servlet "+order);
		
		session.setAttribute("orders", order);
		RequestDispatcher rd = req.getRequestDispatcher("order.jsp");
		rd.forward(req, resp);
		
	}
}
