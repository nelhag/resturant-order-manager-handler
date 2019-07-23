package wcci.resturant.order.manager.handler;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
	Order findByName(String name);
}
