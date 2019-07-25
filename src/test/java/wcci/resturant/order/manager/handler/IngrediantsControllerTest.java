package wcci.resturant.order.manager.handler;

import org.mockito.InjectMocks;
import org.mockito.Mock;

public class IngrediantsControllerTest {

	@InjectMocks
	private ToppingController underTest;
	@Mock
	private ToppingRepository IngrediantsRepo;
	@Mock
	private Topping ingrediants;
}
