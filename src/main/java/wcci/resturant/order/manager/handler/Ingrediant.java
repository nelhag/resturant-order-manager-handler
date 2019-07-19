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
	private Collection <FoodItem> fooditems;
    private String ingrediantName;
    private Type type;
	public static enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
		}
	public Ingrediant(String ingrediantName,Type type,FoodItem foodItem) {
		this.ingrediantName=ingrediantName;
		this.fooditems=new ArrayList<>();
		this.type = type;
		
	}

	public Type getType() {
		return type;
	}

}
