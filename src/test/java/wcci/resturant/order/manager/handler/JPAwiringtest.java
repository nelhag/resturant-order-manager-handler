package wcci.resturant.order.manager.handler;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
		PizzaOrder scottsOrder = new PizzaOrder("Scott", false, "3:00");
		PizzaOrder savedOrder = pizzaOrderRepo.save(scottsOrder);
		Long id = savedOrder.getId();

		entityManager.flush();
		entityManager.clear();
		
		Optional<PizzaOrder> result = pizzaOrderRepo.findById(id);
		PizzaOrder resultingOrder = result.get();
		assertThat(resultingOrder.getName(), is("Scott"));
		
		
//		
//		LogEntry unsavedLogEntry = new LogEntry(null, 101001001, 101001002, LocalDate.of(2020, 1, 1));
//		LogEntry savedLogEntry = logEntryRepo.save(unsavedLogEntry);
//		Long logEntryId = savedLogEntry.getId();
//		
//		entityManager.flush();
//		entityManager.clear();
//
//		Optional<LogEntry> result = logEntryRepo.findById(logEntryId);
//		LogEntry resultLogEntry = result.get();
//		assertThat(resultLogEntry.getStartVerseId(), is(101001001));
	}
		
//		assertThat(pizzaRepo.findByitemName("scottPizza1").getItemName(), is("scottPizza1"));
//		assertThat(pizzaRepo.findByitemName("scottPizza1").getIngrediants().), is("Scott"));
		
		
	}
	
	

