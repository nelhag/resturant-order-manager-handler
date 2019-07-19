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
	private Collection<Ingrediant> ingrediants;
	@ManyToOne
	private Order order;
	private String comments;
	private String  crust;
	private String  sauce;
	
	public Pizza(String itemName, String comments,String sauce, String crust, Order order) {
		this.itemName = itemName;
		this.comments = comments;
		this.order=order;
		this.crust=crust;
		this.sauce=sauce;
		this.ingrediants  = new ArrayList<>();
		
	
	}

	public String getItemName() {
		return itemName;
	}

	public Collection<Ingrediant> getIngrediants() {
		return ingrediants;
	}

	public String getComments() {
		return comments;
	}
    public Order getOrder() {
		return order;
	}


	public Long getId() {
		return id;
	}

	public void addIngrediant(Ingrediant ingrediant) {
	this.ingrediants.add(ingrediant);
}
	public void addOrder(Order order) {
		this.order=order;
	}
	public String getCrust() {
		return crust;
	}

	public String getSauce() {
		return sauce;
	}
}
