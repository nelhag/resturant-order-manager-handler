package wcci.resturant.order.manager.handler;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Order {
	@Id
	@GeneratedValue
    private Long id;
	
	@OneToMany(mappedBy = "order")
	private Collection<Pizza> pizzas;
	
	private String name;
	private boolean paymentMethod;
	private String orderTime;
	


	public Order(String name, boolean paymentMethod, String orderTime) {
		this.name = name;
		this.paymentMethod = true;
		this.orderTime = orderTime;
		this.pizzas=new ArrayList<>();
//		we were thinking of adding address in a child class 
//		false on payment method means they pay in hard currency
		
	}
	public Order () {}
	
		public Collection<Pizza> getPizzas() {
			return pizzas;
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
		public void addPizza(Pizza pizza) {
			this.pizzas.add(pizza);
		}
	

}
