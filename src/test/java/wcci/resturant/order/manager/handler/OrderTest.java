package wcci.resturant.order.manager.handler;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	
	@Before
	public void setup() {
		Order order = new Order("John",true,"3:00");
	    Pizza pizza = new Pizza("taco", "Cut down the middle", "Spicy", "thin", order);
	}
	
	@Test
	public void ordersShouldHaveAttributes() {
//		we were thinking of adding address in a child class 
		
	}
	
}
