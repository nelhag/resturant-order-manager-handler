package wcci.resturant.order.manager.handler;

import org.mockito.InjectMocks;
import org.mockito.Mock;

public class IngrediantsControllerTest {

	@InjectMocks
	private IngrediantsController underTest;
	@Mock
	private IngrediantRepository IngrediantsRepo;
	@Mock
	private Ingrediant ingrediants;
}
