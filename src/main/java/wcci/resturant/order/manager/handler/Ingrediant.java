package wcci.resturant.order.manager.handler;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Ingrediant {
	@Id
	@GeneratedValue
    private Long id;
	@ManyToMany(mappedBy="ingrediants")
	private Collection <Pizza> fooditems;
    private String ingrediantName;
    	private String toppingType;
	public Ingrediant(String ingrediantName,String toppingType,Pizza foodItem) {
		this.ingrediantName=ingrediantName;
		this.fooditems=new ArrayList<>();
		this.toppingType = toppingType;
		
	}
	public Long getId() {
		return id;
	}
	public Collection<Pizza> getFooditems() {
		return fooditems;
	}
	public String getIngrediantName() {
		return ingrediantName;
	}
	public String getToppingType() {
		return toppingType;
	}


}
