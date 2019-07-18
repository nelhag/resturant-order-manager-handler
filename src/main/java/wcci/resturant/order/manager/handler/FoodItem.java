package wcci.resturant.order.manager.handler;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FoodItem {
	
	@Id
	@GeneratedValue
	private Long id;

	private String itemName;
	private String ingrediants;
	private String comments;

	public FoodItem(String itemName, String ingrediants, String comments) {
		this.itemName = itemName;
		this.ingrediants = ingrediants;
		this.comments = comments;
	
	}

	public String getFoodType() {
		return itemName;
	}

	public String getIngrediants() {
		return ingrediants;
	}

	public String getComments() {
		return comments;
	}

}
