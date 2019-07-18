package wcci.resturant.order.manager.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FoodItemController {
	
	@Autowired
	private FoodItemRepository foodItemRepo;
	
	@GetMapping("/fooditems")
	public Iterable<FoodItem> sendFoodItems(){
		return foodItemRepo.findAll();	
	}
	@GetMapping("/fooditems/{id}")
	public FoodItem sendFoodItem(@PathVariable Long id) {
		return foodItemRepo.findById(id).get();
	}
	

}
