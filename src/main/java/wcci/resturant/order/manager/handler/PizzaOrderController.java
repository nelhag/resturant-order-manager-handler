package wcci.resturant.order.manager.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PizzaOrderController {

	@Autowired
	private PizzaOrderRepository pizzaOrderRepo;
	
	@GetMapping("/orders")
	public Iterable<PizzaOrder> sendOrders(){
		return pizzaOrderRepo.findAll();
	}
	
	@GetMapping("/orders/{id}")
	public PizzaOrder sendOrder(@PathVariable Long id) {
		return pizzaOrderRepo.findById(id).get();	
	}
	@PostMapping("/place-order")
	public PizzaOrder placePizzaOrder(@RequestBody PizzaOrder order) {
//		might make a funtion to double check that the data is valid before saving
		
		return pizzaOrderRepo.save(order);
	}
	
}
