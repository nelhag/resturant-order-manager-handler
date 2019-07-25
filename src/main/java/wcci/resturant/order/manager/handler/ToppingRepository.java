package wcci.resturant.order.manager.handler;

import org.springframework.data.repository.CrudRepository;

public interface ToppingRepository extends CrudRepository<Topping, Long> {
	Topping findByIngrediantName(String ingrediantName);


}
