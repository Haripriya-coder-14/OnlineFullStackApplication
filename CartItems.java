package com.tap.Model;

public class CartItems {
	
	private int itemId;
	private int menuId;
	private int restaurantId;
	private String name;
	private int quantity;
	private String description;
	private String imagePath;
	private float price;
	
	public CartItems() {
		
	}
	
	public CartItems(int itemId, int menuId, int restaurantId, String name, int quantity,String description, String imagePath, float price) {
		super();
		this.itemId = itemId;
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.quantity = quantity;
		this.description = description;
		this.imagePath = imagePath;
		this.price = price;
		
	}

	public CartItems(int menuId, int restaurantId, String name, int quantity, String description, String imagePath, float price) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.quantity = quantity;
		this.description = description;
		this.imagePath = imagePath;
		this.price = price;
		
	}
	
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	public int getItemId() {
		return itemId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setdescription(String description) {
		this.description = description;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public String getImagePath() {
		return imagePath;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartItems [ Name=" + name + ", quantity= " + quantity + ", price= " + price + " ]";
	}
	
	
	
}
