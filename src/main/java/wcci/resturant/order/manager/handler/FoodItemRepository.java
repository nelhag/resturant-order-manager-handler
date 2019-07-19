package wcci.resturant.order.manager.handler;

import org.springframework.data.repository.CrudRepository;

public interface FoodItemRepository extends CrudRepository<Pizza, Long>{
	Pizza findByitemName(String itemName);

}
