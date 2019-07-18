package wcci.resturant.order.manager.handler;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	
	@Before
	public void setup() {
		FoodItem foodItem = new FoodItem("taco", "taco stuff", "add extra shell");
	}
	
	@Test
	public void ordersShouldHaveAttributes() {
		Order order = new Order("John",true,"3:00");
//		we were thinking of adding address in a child class 
		
	}
	
}
