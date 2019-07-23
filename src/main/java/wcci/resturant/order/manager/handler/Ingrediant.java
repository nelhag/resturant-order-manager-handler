package wcci.resturant.order.manager.handler;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Ingrediant {
	@Id
	@GeneratedValue
    private Long id;
	
	@ManyToMany(mappedBy="ingrediants")
	private Collection <Pizza> pizzas;
	
    private String ingrediantName;
    	private String toppingType;
	public Ingrediant(String ingrediantName,String toppingType) {
		this.ingrediantName=ingrediantName;
		this.pizzas=new ArrayList<>();
		this.toppingType = toppingType;
		
	}
	public Long getId() {
		return id;
	}
	public Collection<Pizza> getFooditems() {
		return pizzas;
	}
	public String getIngrediantName() {
		return ingrediantName;
	}
	public String getToppingType() {
		return toppingType;
	}


}
