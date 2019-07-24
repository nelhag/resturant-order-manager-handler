package wcci.resturant.order.manager.handler;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PizzaOrder {
	
	@Id
	@GeneratedValue
    private Long id;
	
	public Long getId() {
		return id;
	}
	@OneToMany(mappedBy = "pizzaorder")
	private Collection<Pizza> pizzas;
	
	private String name;
	private boolean paymentMethod;
	private String orderTime;
	


	public PizzaOrder(String name, boolean paymentMethod, String orderTime) {
		this.name = name;
		this.paymentMethod = true;
		this.orderTime = orderTime;
		this.pizzas=new ArrayList<>();
//		we were thinking of adding address in a child class 
//		false on payment method means they pay in hard currency
		
	}
	public PizzaOrder () {}
	
		public Collection<Pizza> getPizzas() {
			return pizzas;
		}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PizzaOrder other = (PizzaOrder) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
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