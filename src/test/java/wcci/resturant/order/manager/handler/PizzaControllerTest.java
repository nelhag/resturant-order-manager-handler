package wcci.resturant.order.manager.handler;

import org.mockito.InjectMocks;
import org.mockito.Mock;

public class PizzaControllerTest {

	@InjectMocks
	private PizzaController underTest;
	@Mock
	private PizzaRepository PizzaRepo;
	@Mock
	private Pizza pizza;
}
