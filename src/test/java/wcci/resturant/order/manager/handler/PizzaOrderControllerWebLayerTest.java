package wcci.resturant.order.manager.handler;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

@WebMvcTest(PizzaOrderController.class)
@RunWith(SpringRunner.class)
public class PizzaOrderControllerWebLayerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	PizzaOrderRepository orderRepo;
	
	private PizzaOrder testOrder;
	private PizzaOrder testOrder2;
	private Pizza testPizza;
	private ObjectMapper mapper = new ObjectMapper();
	
	@Before
	public void setup( ) {
		testOrder = new PizzaOrder("John", false, "4:00");
		testPizza =  new Pizza("ItemName","Ingredeints", null, null, testOrder);
		testOrder2 = new PizzaOrder("Ted", false, "5:00");
	}
	
	@Test
	public void fetchCollectionOfOrders() throws Exception{
		when(orderRepo.findAll()).thenReturn(Collections.singletonList(testOrder));
		mockMvc.perform(get("/api/orders"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testOrder)),true));
	}
	
	@Test
	public void fetchSingleOrder() throws Exception{
		when(orderRepo.findById(1L)).thenReturn(Optional.of(testOrder));
		mockMvc.perform(get("/api/orders/1"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().json(mapper.writeValueAsString(testOrder),true));	
	}
	
	@Test
	public void placeNewOrder() throws Exception {
		when(orderRepo.save(any(PizzaOrder.class))).thenReturn(testOrder2);

 		mockMvc.perform(post("/api/place-order")
 				.contentType(MediaType.APPLICATION_JSON)
 				.characterEncoding("utf-8")
 				.content(mapper.writeValueAsString(testOrder2)))
 				.andExpect(status().isOk());

	}

	private String toJson(PizzaOrder order) {
		return testOrder2.getName();
	}
	
	
}
