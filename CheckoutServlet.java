package com.tap.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import com.tap.DAO.OrderDAO;
import com.tap.DAO.OrderDAOImpl;
import com.tap.DAO.OrderItemDAO;
import com.tap.DAO.OrderItemDAOImpl;
import com.tap.Model.Cart;
import com.tap.Model.CartItems;
import com.tap.Model.Order;
import com.tap.Model.OrderItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	
	private OrderDAO orderDAO;
	private OrderItemDAO orderItemDAO;
	private OrderItem orderItem;
	
	@Override
	public void init() throws ServletException {
		orderDAO = new OrderDAOImpl();
		orderItemDAO = new OrderItemDAOImpl();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Enumeration<String> attrs = session.getAttributeNames();
		while (attrs.hasMoreElements()) {
		    System.out.println(attrs.nextElement());
		}
		Cart cart = (Cart) session.getAttribute("cart");
		int userId = (int) session.getAttribute("userId");
		System.out.println("Your user id is"+ userId);
		int restaurantId = (int) session.getAttribute("restaurantId");
		
		if(cart != null && userId != 0 && !cart.getItems().isEmpty() ) {
			String paymentMode = req.getParameter("paymentMode");
			String address = req.getParameter("address");
			session.setAttribute("address", address);
			String status = "Pending";
			double totalAmount = cart.getTotalPrice();
			
			Order order = new Order(restaurantId, userId, totalAmount, status, paymentMode, address);
			
			orderDAO = new OrderDAOImpl();
			int orderId = orderDAO.addOrder(order);
			
			System.out.println("Your order is successfully placed, order Id "+ orderId);
			
			System.out.println("The grant total of the order is "+totalAmount);
			
			List<OrderItem> list = new ArrayList<>();
			
			for(CartItems item : cart.getItems().values()) {
				int menuId = item.getMenuId();
				double price = item.getPrice();
				int quantity = item.getQuantity();
				double totalPrice = price * quantity;
				
				orderItem = new OrderItem(orderId, menuId, quantity, price, totalPrice);
				
				System.out.println(orderItem);
				
				orderItemDAO = new OrderItemDAOImpl();
				orderItemDAO.addOrderItem(orderItem);
				
				list.add(orderItem); 
				
			}
			
			session.setAttribute("orderItem", list);
			session.setAttribute("orderId", orderId);
			
			session.removeAttribute("cart");
			resp.sendRedirect("orderConfirmation.jsp");	
		}
		
		else {
			resp.sendRedirect("cart.jsp");
		}
	}
}
