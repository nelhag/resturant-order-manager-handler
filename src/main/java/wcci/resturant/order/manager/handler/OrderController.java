package wcci.resturant.order.manager.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderRepository orderRepo;
	
	@GetMapping("/orders")
	public Iterable<Order> sendOrders(){
		return orderRepo.findAll();
	}
	
	@GetMapping("/orders/{id}")
	public Order sendOrder(@PathVariable Long id) {
		return orderRepo.findById(id).get();	
	}
	@PostMapping("/place-order")
	public Order placeOrder(String name, Boolean paymentMethod, String orderTime) {
		Order orderToPlace = new Order(name, paymentMethod, orderTime);
		if(orderRepo.findByOrderByName(orderToPlace.getName())==null) {
		orderRepo.save(orderToPlace);
		}
		return orderRepo.findByOrderByName(orderToPlace.getName());
	}
	
}
