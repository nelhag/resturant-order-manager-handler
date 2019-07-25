package wcci.resturant.order.manager.handler;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.Optional;

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
		scottsTopping2 = new Ingrediant("banana pepper","veggie");
		scottsTopping3 = new Ingrediant("pepperoni", "protein");
		ingrediantsRepo.save(scottsTopping2);
		ingrediantsRepo.save(scottsTopping3);
	}
	
	@Test
	public void shouldStartJPATestFramework() {}

	@Test
	public void ShouldSaveAndLoadPizzaOrders() {
		PizzaOrder scottsOrder = new PizzaOrder("Scott", false, "3:00");
		PizzaOrder savedOrder = pizzaOrderRepo.save(scottsOrder);
		Long id = savedOrder.getId();

		entityManager.flush();
		entityManager.clear();
		
		Optional<PizzaOrder> result = pizzaOrderRepo.findById(id);
		PizzaOrder resultingOrder = result.get();
		assertThat(resultingOrder.getName(), is("Scott"));
		
		
	}
		
	@Test
	public void ShouldSaveAndLoadPizza() {
		
		Pizza scottsPizza = new Pizza("scottPizza1", "cook for 1 extra minute","regular", "thin", scottsOrder);
		Pizza savedPizza = pizzaRepo.save(scottsPizza);
		Long id = savedPizza.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional <Pizza> result = pizzaRepo.findById(id);
		Pizza resultPizza = result.get();
		assertThat(resultPizza.getItemName(), is("scottPizza1"));
	}
	
	@Test
	public void ShouldSaveAndLoadIngrediant() {
		Ingrediant topping = new Ingrediant("mushroom","veggie");
		Ingrediant savedTopping = ingrediantsRepo.save(topping);
		Long id = savedTopping.getId();
				
		entityManager.flush();
		entityManager.clear();
		
		Optional<Ingrediant> result = ingrediantsRepo.findById(id);
		Ingrediant resultTopping = result.get();
		assertThat(resultTopping.getIngrediantName(), is("mushroom"));
		
	}
	
	@Test
	public void ShouldAddToppingsToPizza() {
		Pizza scottsPizza = new Pizza("scottPizza1", "cook for 1 extra minute","regular", "thin", scottsOrder);
		Ingrediant topping = new Ingrediant("mushroom","veggie");
		scottsPizza.addIngrediant(topping);
		ingrediantsRepo.save(topping);
		
		
		Pizza savedPizza = pizzaRepo.save(scottsPizza);
		Long id = savedPizza.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Pizza> changedPizza = pizzaRepo.findById(id);
		Collection<Ingrediant> ingredients = changedPizza.get().getIngrediants();
		assertThat(ingredients, containsInAnyOrder(topping));	
	}
	}
	
	

