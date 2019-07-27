package wcci.resturant.order.manager.handler;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PizzaController.class)
@RunWith(SpringRunner.class)
public class PizzaControllerWebLayerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	PizzaRepository pizzaRepo;
	
	private Pizza testPizza;
	private PizzaOrder testOrder;
	private ObjectMapper mapper = new ObjectMapper();
	
	@Before
	public void setup() {
		testOrder = new PizzaOrder("John", false, "4:00");
		testPizza =  new Pizza("ItemName","Ingredeints", null, null, null);
	}
	
	@Test
	public void fetchCollectionOfFoodItems() throws Exception{
	when(pizzaRepo.findAll()).thenReturn(Collections.singletonList(testPizza));
	mockMvc.perform(get("/api/pizzas"))
	.andDo(print())
	.andExpect(status().isOk())
	.andExpect(content().contentType("application/json;charset=UTF-8"))
	.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testPizza)),true));	
	}
	@Test
	public void fetchSingleFoodItems() throws Exception{
	when(pizzaRepo.findById(1L)).thenReturn(Optional.of(testPizza));
	mockMvc.perform(get("/api/pizzas/1"))
	.andDo(print())
	.andExpect(status().isOk())
	.andExpect(content().contentType("application/json;charset=UTF-8"))
	.andExpect(content().json(mapper.writeValueAsString(testPizza),true));	
	}
	@Test
	public void addNewPizzToOrder() throws Exception {
		when(pizzaRepo.save(any(Pizza.class))).thenReturn(testPizza);

 		mockMvc.perform(post("/api/place-order/add-pizzas")
 				.contentType(MediaType.APPLICATION_JSON)
 				.characterEncoding("utf-8")
 				.content(mapper.writeValueAsString(testPizza)))
 				.andExpect(status().isOk());

	}
	
	
	
	
	
}