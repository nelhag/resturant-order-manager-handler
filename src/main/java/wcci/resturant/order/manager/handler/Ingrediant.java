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
	public Ingrediant() {}
	
	public Collection<Pizza> getPizzas() { 
		return pizzas;
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
	Ingrediant other = (Ingrediant) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}
}