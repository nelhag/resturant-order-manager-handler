package wcci.resturant.order.manager.handler;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;



@Entity
public class Pizza {
	

	@Id
	@GeneratedValue
	private Long id;

	private String itemName;
	@ManyToMany
	private Collection<Topping> toppings;
	
	@ManyToOne
	private PizzaOrder pizzaorder;
	
	private String comments;
	private String  crust;
	private String  sauce;
	
	public Pizza(String itemName, String comments,String sauce, String crust, PizzaOrder pizzaorder) {
		this.itemName = itemName;
		this.comments = comments;
		this.crust=crust;
		this.sauce=sauce;
		this.pizzaorder=pizzaorder;
		this.toppings  = new ArrayList<>();
		
	}
	public Pizza () {}

	public PizzaOrder getPizzaorder() {
		return pizzaorder;
	}

	public String getItemName() {
		return itemName;
	}

	public Collection<Topping> getToppings() {
		return toppings;
	}
//	public String findByIngrediantName(String name) {
//		this.ingrediants.
//	}

	public String getComments() {
		return comments;
	}


	public Long getId() {
		return id;
	}

	public void addTopping(Topping topping) {
	this.toppings.add(topping);
}
	public void addOrder(PizzaOrder pizzaorder) {
		this.pizzaorder=pizzaorder;
	}
	public String getCrust() {
		return crust;
	}

	public String getSauce() {
		return sauce;
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
	Pizza other = (Pizza) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}
}