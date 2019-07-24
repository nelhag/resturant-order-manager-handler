package wcci.resturant.order.manager.handler;

import org.springframework.data.repository.CrudRepository;

public interface IngrediantRepository extends CrudRepository<Ingrediant, Long> {
	Ingrediant findByIngrediantName(String ingrediantName);


}
