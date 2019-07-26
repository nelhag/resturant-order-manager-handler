
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
private ToppingRepository ToppingRepo;
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
	
	Topping cheddar=new Topping ("cheddar","Cheese");
	ToppingRepo.save(cheddar);
	Topping swiss=new Topping ("swiss","Cheese");
	ToppingRepo.save(swiss);
	Topping ItalianSausage=new Topping ("Italian Sausage","Meat");
	ToppingRepo.save(ItalianSausage);
	Topping beef=new Topping ("Beef","Meat");
	ToppingRepo.save(beef);
	Topping GrilledChicken=new Topping ("Grilled Chicken","Meat");
	ToppingRepo.save(GrilledChicken);
	Topping peproni=new Topping ("Peproni","Meat");
	ToppingRepo.save(peproni);
	Topping  meatBall=new Topping (" Meat Ball","Meat");
	ToppingRepo.save(meatBall);
	Topping  mushrooms=new Topping (" Mushrooms","Veggie");
	ToppingRepo.save(mushrooms);
	Topping  roastedSpinach = new Topping (" Roasted Spinach","Veggie");
	ToppingRepo.save(roastedSpinach);
	Topping  redOnions =new Topping ("Red Onions","Veggie");
	ToppingRepo.save( redOnions);
	Topping  mediterraneanBlackOlives =new Topping ("Mediterranean Black Olives","Veggie");
	ToppingRepo.save( mediterraneanBlackOlives);
	Topping  mediterraneanBlackOlives1 =new Topping ("Mediterranean Black Olives","Veggie");
	ToppingRepo.save( mediterraneanBlackOlives1);
	Topping greenBellPeppers =new Topping ("Green Bell Peppers","Veggie");
	ToppingRepo.save( greenBellPeppers);
	Topping  pineapple =new Topping (" Pineapple","Veggie");
	ToppingRepo.save(pineapple);	 
	
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
