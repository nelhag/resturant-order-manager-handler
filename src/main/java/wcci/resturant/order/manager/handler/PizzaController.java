package wcci.resturant.order.manager.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PizzaController {
	
	@Autowired
	private PizzaRepository pizzaRepo;
	
	@GetMapping("/pizzas")
	@CrossOrigin
	public Iterable<Pizza> sendFoodItems(){
		return pizzaRepo.findAll();	
	}
	@GetMapping("/pizzas/{id}")
	@CrossOrigin
	public Pizza sendFoodItem(@PathVariable Long id) {
		return pizzaRepo.findById(id).get();
	}
	@PostMapping("/place-order/add-pizzas")
	public Pizza placePizzaOrder(@RequestBody Pizza pizza) {
//		might make a funtion to double check that the data is valid before saving
		
		return pizzaRepo.save(pizza);
	}
	

}
