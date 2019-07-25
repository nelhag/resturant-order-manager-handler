package wcci.resturant.order.manager.handler;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Topping {
	@Id
	@GeneratedValue
    private Long id;
	
	@ManyToMany(mappedBy="toppings")
	private Collection <Pizza> pizzas;
	
    private String toppingName;
    	private String toppingType;
	public Topping(String toppingName,String toppingType) {
		this.toppingName=toppingName;
		this.pizzas=new ArrayList<>();
		this.toppingType = toppingType;
		
	}
	public Topping() {}
	
	public Collection<Pizza> getPizzas() { 
		return pizzas;
	}   

	public Long getId() {
		return id;
	}
	public Collection<Pizza> getFooditems() {
		return pizzas;
	}
	public String getToppingName() {
		return toppingName;
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
	Topping other = (Topping) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}
}