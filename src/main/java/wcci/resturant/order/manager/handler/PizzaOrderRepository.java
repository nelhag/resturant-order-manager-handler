package wcci.resturant.order.manager.handler;

import org.springframework.data.repository.CrudRepository;

public interface PizzaOrderRepository extends CrudRepository<PizzaOrder, Long> {
	PizzaOrder findByName(String name);
}
