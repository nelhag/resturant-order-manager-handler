package wcci.resturant.order.manager.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IngrediantsController {

	@Autowired
	private IngrediantRepository ingrediantRepo;
	
	@GetMapping("/ingrediants")
	public Iterable<Ingrediant> sendIngrediants(){
		return ingrediantRepo.findAll();
	}
	@GetMapping("/ingrediants/{id}")
	public Ingrediant sendIngrediant(@PathVariable Long id) {
		return ingrediantRepo.findById(id).get();
	}
	
}
