package wcci.resturant.order.manager.handler;

import org.junit.Before;
import org.junit.Test;

public class PizzaTest {
	@Before
	public void setup() { 
	Order order = new Order("Sam", true,"4:20");
	Pizza fooditem = new Pizza("taco", "comments", "sauce", "crust", order);
	}
		@Test
		public void foodItemShouldHaveAttributes() {
	
			
		}
}
