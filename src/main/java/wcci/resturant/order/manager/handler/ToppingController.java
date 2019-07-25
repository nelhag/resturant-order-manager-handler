package wcci.resturant.order.manager.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ToppingController {

	@Autowired
	private ToppingRepository toppingRepo;
	
	@GetMapping("/toppings")
	public Iterable<Topping> sendToppings(){
		return toppingRepo.findAll();
	}
	@GetMapping("/toppings/{id}")
	public Topping sendTopping(@PathVariable Long id) {
		return toppingRepo.findById(id).get();
	}
	
}
