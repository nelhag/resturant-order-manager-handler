package wcci.resturant.order.manager.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class initializer implements CommandLineRunner{
@Autowired
private PizzaOrderRepository pizzaOrderRepo;
@Autowired 
private PizzaRepository pizzaRepo;
@Autowired
private IngrediantRepository ingrediantRepo;
@Override
public void run(String... args) throws Exception{
	PizzaOrder order1=new PizzaOrder("Sam",true, "7/25/19 11:00pm");
	pizzaOrderRepo.save(order1);
	PizzaOrder order2=new PizzaOrder("John",false,"7/25/19 11:30pm");
	pizzaOrderRepo.save(order2);
//	PizzaOrder order3=new PizzaOrder("Sarah",true,"7/25/19 12:30pm");
//	pizzaOrderRepo.save(order3);
//	PizzaOrder order4=new PizzaOrder("Adam",true,"7/25/19 12:35pm");
//	pizzaOrderRepo.save(order4);
//	PizzaOrder order5=new PizzaOrder("Jessica",false,"7/25/19 12:45pm");
//	pizzaOrderRepo.save(order5);
//	PizzaOrder order6=new PizzaOrder("Sarah",true,"7/25/19 1:30pm");
//	pizzaOrderRepo.save(order6);
	
	Pizza pizza1= new Pizza("pizza1","add bufflo sauce","white","thin",order1);
	pizzaRepo.save(pizza1);
	Pizza pizza2= new Pizza("pizza2","add Ketchup","Mild","thick",order2);
	pizzaRepo.save(pizza2);
	Pizza pizza3= new Pizza("pizza3","add napkins and ketchup","spicy","thin",order2);
	pizzaRepo.save(pizza3);
	Pizza pizza4= new Pizza("pizza4","add napkins","spicy","thick",order1);
	pizzaRepo.save(pizza4);
	
	Ingrediant cheddar=new Ingrediant ("cheddar","Cheese");
	ingrediantRepo.save(cheddar);
	Ingrediant swiss=new Ingrediant ("swiss","Cheese");
	ingrediantRepo.save(swiss);
	Ingrediant ItalianSausage=new Ingrediant ("Italian Sausage","Meat");
	ingrediantRepo.save(ItalianSausage);
	Ingrediant beef=new Ingrediant ("Beef","Meat");
	ingrediantRepo.save(beef);
	Ingrediant GrilledChicken=new Ingrediant ("Grilled Chicken","Meat");
	ingrediantRepo.save(GrilledChicken);
	Ingrediant peproni=new Ingrediant ("Peproni","Meat");
	ingrediantRepo.save(peproni);
	Ingrediant  meatBall=new Ingrediant (" Meat Ball","Meat");
	ingrediantRepo.save(meatBall);
	Ingrediant  mushrooms=new Ingrediant (" Mushrooms","Veggie");
	ingrediantRepo.save(mushrooms);
	Ingrediant  roastedSpinach = new Ingrediant (" Roasted Spinach","Veggie");
	ingrediantRepo.save(roastedSpinach);
	Ingrediant  redOnions =new Ingrediant ("Red Onions","Veggie");
	ingrediantRepo.save( redOnions);
	Ingrediant  mediterraneanBlackOlives =new Ingrediant ("Mediterranean Black Olives","Veggie");
	ingrediantRepo.save( mediterraneanBlackOlives);
	Ingrediant  mediterraneanBlackOlives1 =new Ingrediant ("Mediterranean Black Olives","Veggie");
	ingrediantRepo.save( mediterraneanBlackOlives1);
	Ingrediant greenBellPeppers =new Ingrediant ("Green Bell Peppers","Veggie");
	ingrediantRepo.save( greenBellPeppers);
	Ingrediant  pineapple =new Ingrediant (" Pineapple","Veggie");
	ingrediantRepo.save(pineapple);	 
	
	order1.addPizza(pizza1);
	order1.addPizza(pizza4);
	pizza1.addToppingToPizza(pineapple);
	pizza1.addToppingToPizza(GrilledChicken);
	pizza1.addToppingToPizza(swiss);
	pizza1.addToppingToPizza(cheddar);
	pizza4.addToppingToPizza(greenBellPeppers);
	pizza4.addToppingToPizza(mediterraneanBlackOlives);
	pizza4.addToppingToPizza(ItalianSausage);
	pizza4.addToppingToPizza(cheddar);
	pizzaRepo.save(pizza1);
	pizzaRepo.save(pizza4);
	pizzaOrderRepo.save(order1);
	
	order2.addPizza(pizza2);
	order2.addPizza(pizza3);
	pizza2.addToppingToPizza(beef);
	pizza2.addToppingToPizza(redOnions);
	pizza2.addToppingToPizza(cheddar);
	pizza2.addToppingToPizza(swiss);
	pizza3.addToppingToPizza(peproni);
	pizza3.addToppingToPizza(roastedSpinach);
	pizza3.addToppingToPizza(mushrooms);
	pizza3.addToppingToPizza(swiss);
	pizzaRepo.save(pizza2);
	pizzaRepo.save(pizza3);
	pizzaOrderRepo.save(order2);
	 }
}
