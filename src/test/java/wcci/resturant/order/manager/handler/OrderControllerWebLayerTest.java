package wcci.resturant.order.manager.handler;

import static org.mockito.Mockito.when;
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

@WebMvcTest(OrderController.class)
@RunWith(SpringRunner.class)
public class OrderControllerWebLayerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	OrderRepository orderRepo;
	
	private Order testOrder;
	private Order testOrder2;
	private Pizza testPizza;
	private ObjectMapper mapper = new ObjectMapper();
	
	@Before
	public void setup( ) {
		testOrder = new Order("John", false, "4:00");
		testPizza =  new Pizza("ItemName","Ingredeints", null, null, testOrder);
		testOrder2 = new Order("Ted", false, "5:00");
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
		when(orderRepo.save(testOrder2)).thenReturn(testOrder2);
//		mockMvc.perform(post("/api/place-order").content("Ted")).andExpect(status().isOk());
//		using .content vs .contentType
 		mockMvc.perform(post("/api/place-order").contentType(MediaType.APPLICATION_JSON).content(toJson(testOrder2))).andExpect(status().isOk());
	}

	private String toJson(Order order) {
		return testOrder2.getName();
	}
	
	
}
