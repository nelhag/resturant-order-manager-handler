package wcci.resturant.order.manager.handler;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JPAwiringtest {

	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	private PizzaRepository pizzaRepo;
	
	@Autowired
	private PizzaOrderRepository pizzaOrderRepo;
	
	@Autowired
	private IngrediantRepository ingrediantsRepo;
	
	private PizzaOrder scottsOrder;
	private Pizza scottsPizza;
	private Ingrediant scottsTopping1;
	private Ingrediant scottsTopping2;
	private Ingrediant scottsTopping3;
	
	
	@Before
	public void setup() {
		scottsOrder = new PizzaOrder("Scott", false, "3:00");
		pizzaOrderRepo.save(scottsOrder);
		scottsPizza = new Pizza("scottPizza1", "cook for 1 extra minute","regular", "thin", scottsOrder);
		pizzaRepo.save(scottsPizza);
		scottsTopping1 = new Ingrediant("mushroom","veggie");
		scottsTopping2 = new Ingrediant("banana pepper","veggie");
		scottsTopping3 = new Ingrediant("pepperoni", "protein");
		ingrediantsRepo.save(scottsTopping1);
		ingrediantsRepo.save(scottsTopping2);
		ingrediantsRepo.save(scottsTopping3);
	}
	
	@Test
	public void shouldStartJPATestFramework() {}

	@Test
	public void ShouldSaveAndLoadObjects() {
		assertThat(pizzaOrderRepo.findById(1L).get().getName(), is("Scott"));
//		assertThat(pizzaRepo.findByitemName("scottPizza1").getItemName(), is("scottPizza1"));
//		assertThat(pizzaRepo.findByitemName("scottPizza1").getIngrediants().), is("Scott"));
		
		
	}
	
	
}
