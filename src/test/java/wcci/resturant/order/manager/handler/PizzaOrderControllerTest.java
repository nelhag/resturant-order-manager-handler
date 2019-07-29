package wcci.resturant.order.manager.handler;

import org.mockito.InjectMocks;
import org.mockito.Mock;

public class PizzaOrderControllerTest {

	@InjectMocks
	private PizzaOrderController underTest;
	@Mock
	private PizzaOrderRepository PizzaOrderRepo;
	@Mock
	private PizzaOrder pizzaOrder;
	
}
