package wcci.resturant.order.manager.handler;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.OneToMany;

public class Order {
	
	@OneToMany(mappedBy = "order")
	private Collection<Pizza> foodItems;
	
	private String name;
	private boolean paymentMethod;
	private String orderTime;
	


	public Order(String name, boolean paymentMethod, String orderTime) {
		this.name = name;
		this.paymentMethod = true;
		this.orderTime = orderTime;
		this.foodItems=new ArrayList<>();
//		we were thinking of adding address in a child class 
//		false on payment method means they pay in hard currency
		
	}
	
		public Collection<Pizza> getFoodItems() {
			return foodItems;
		}
		
		
		public String getName() {
			return name;
		}
		
		
		public boolean isPaymentMethod() {
			return paymentMethod;
		}
		
		
		public String getOrderTime() {
			return orderTime;
		}
		public void addFoodItem(Pizza foodItem) {
			this.foodItems.add(foodItem);
		}
	

}
