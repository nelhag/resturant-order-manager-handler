package wcci.resturant.order.manager.handler;


import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;


import java.util.ArrayList;
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
	private ToppingRepository toppingsRepo;
	
	private PizzaOrder scottsOrder;
	private Pizza scottsPizza;
	private Topping scottsTopping1;
	private Topping scottsTopping2;
	private Topping scottsTopping3;
	
	
	@Before
	public void setup() {
		scottsTopping2 = new Topping("banana pepper","veggie");
		scottsTopping3 = new Topping("pepperoni", "protein");
		toppingsRepo.save(scottsTopping2);
		toppingsRepo.save(scottsTopping3);
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
		Topping topping = new Topping("mushroom","veggie");
		Topping savedTopping = toppingsRepo.save(topping);
		Long id = savedTopping.getId();
				
		entityManager.flush();
		entityManager.clear();
		
		Optional<Topping> result = toppingsRepo.findById(id);
		Topping resultTopping = result.get();
		assertThat(resultTopping.getToppingName(), is("mushroom"));
		
	}
	@Test
	public void shouldAddPizzaToPizzaOrder() {
		PizzaOrder pizzaOrderTest=new PizzaOrder();
		Pizza pizzaTest=new Pizza( "Bufflo",  "add ketchup", "mild",  "thin",  pizzaOrderTest) ;
		pizzaRepo.save(pizzaTest);
        PizzaOrder savedOrder=pizzaOrderRepo.save(pizzaOrderTest);
		Long id=savedOrder.getId();
		entityManager.flush();
		entityManager.clear();
		PizzaOrder order1 = pizzaOrderRepo.findById(id).get();
		assertThat(order1.getPizzas(),contains(pizzaTest));
		
	}
	
	
	@Test
	public void ShouldAddToppingsToPizza() {
		Pizza scottsPizza = new Pizza("scottPizza1", "cook for 1 extra minute","regular", "thin", scottsOrder);
		Topping topping = new Topping("mushroom","veggie");
		scottsPizza.addTopping(topping);
		toppingsRepo.save(topping);
		
		
		Pizza savedPizza = pizzaRepo.save(scottsPizza);
		Long id = savedPizza.getId();
		
		entityManager.flush();
		entityManager.clear();
		
		Optional<Pizza> changedPizza = pizzaRepo.findById(id);
		Collection<Topping> ingredients = changedPizza.get().toppings();
		assertThat(ingredients, containsInAnyOrder(topping));	
	}
	@Test
	public void returnItemTotalOrderShouldbe1() {
		Pizza scottsPizza2 = new Pizza("scottPizza2", "cook for 1 extra minute","regular", "thin", scottsOrder);
		Pizza scottsPizza1 = new Pizza("scottPizza1", "cook for 1 extra minute","regular", "thin", scottsOrder);
		Pizza savedPizza1 = pizzaRepo.save(scottsPizza1);
		Pizza savedPizza2 = pizzaRepo.save(scottsPizza2);
		Topping topping = new Topping("mushroom","veggie");
		System.out.println("lalalalala" + scottsOrder.toppingCounter());
		scottsPizza1.addTopping(topping);
		toppingsRepo.save(topping);
		
		entityManager.flush();
		entityManager.clear();
		
		
		assertThat(scottsOrder.toppingCounter(), is(1));
	}
	}
	
	

