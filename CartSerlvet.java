
//Cart Servlet

package com.tap.Servlet;

import java.io.IOException;

import com.tap.DAO.MenuDAOImpl;
import com.tap.Model.Cart;
import com.tap.Model.CartItems;
import com.tap.Model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartSerlvet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		
		Cart cart = (Cart)session.getAttribute("cart");
		
		String restaurantIdParam = req.getParameter("restaurantId");
		
		Integer currentRestaurantId = (Integer) session.getAttribute("restaurantId");
		
		if(restaurantIdParam != null) {
			int newrestaurantId = Integer.parseInt(restaurantIdParam);
			System.out.println("new Restaurant"+newrestaurantId);
			if(currentRestaurantId == null || !currentRestaurantId.equals(newrestaurantId)) {
				cart = new Cart();
				session.setAttribute("cart", cart);
				session.setAttribute("restaurantId", newrestaurantId);	
				
				System.out.println("new Restaurant"+newrestaurantId);
				System.out.println("old restuarnt"+currentRestaurantId);
			}
		}
		
		String action = req.getParameter("action");
		
		int menuId = Integer.parseInt(req.getParameter("menuId"));
		
		String action1=req.getParameter("action");
		System.out.println(action1);
		
		
		
		if(action.equalsIgnoreCase("add")) {
			addItemToCart(req, cart);
		}
		
		else if(action.equalsIgnoreCase("update")) {
			updateItemToCart(req, cart);
			
			System.out.println("Its coming");		
		}
		
		else if(action.equalsIgnoreCase("remove")) {
			removeCartItem(req, cart);
			
			System.out.println("menuId to remove"+menuId);
			
			System.out.println("Its coming to remove");
		}
		
		resp.sendRedirect("cart.jsp");
		
	}
	
	public void addItemToCart(HttpServletRequest req, Cart cart){
		int menuId = Integer.parseInt(req.getParameter("menuId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		System.out.println("the new menu id added to the cart: "+menuId);	
		MenuDAOImpl impl = new MenuDAOImpl();
		Menu menu = impl.getMenu(menuId);
		
		if(menu != null) {
			CartItems cartItem = new CartItems(menuId, menu.getRestaurantId(), menu.getItemName(), quantity, menu.getDescription(), menu.getImagePath(), menu.getPrice());
			cart.addItem(cartItem);
			
			System.out.println("Added cart items details are "+cartItem);
			
			
			
			
			
			
			
		}
	}
	
	public void updateItemToCart(HttpServletRequest req, Cart cart) {
		int menuId = Integer.parseInt(req.getParameter("menuId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		cart.updateItem(menuId, quantity);
	}
	
	public void removeCartItem(HttpServletRequest req, Cart cart) {
		int menuId = Integer.parseInt(req.getParameter("menuId"));
		cart.deleteItem(menuId);
	}
}
