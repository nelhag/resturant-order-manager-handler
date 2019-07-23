package wcci.resturant.order.manager.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PizzaController {
	
	@Autowired
	private PizzaRepository pizzaRepo;
	
	@GetMapping("/fooditems")
	public Iterable<Pizza> sendFoodItems(){
		return pizzaRepo.findAll();	
	}
	@GetMapping("/fooditems/{id}")
	public Pizza sendFoodItem(@PathVariable Long id) {
		return pizzaRepo.findById(id).get();
	}
	

}