package wcci.resturant.order.manager.handler;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ToppingController.class)
@RunWith(SpringRunner.class)
public class ToppingsControllerWebLayerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ToppingRepository toppingRepo;
	
	private Topping testTopping;
	private Pizza testPizza;
	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setup() {
		testPizza = new Pizza("ItemName","Ingredeints", null, null, null);
		testTopping = new Topping("olive", null);
	}
	
	@Test
	public void fetchCollectionOfIngrediants() throws Exception{
		when(toppingRepo.findAll()).thenReturn(Collections.singletonList(testTopping));
		mockMvc.perform(get("/api/ingrediants"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testTopping)),true));
	}
	@Test
	public void fetchSingleIngrediant() throws Exception{
		when(toppingRepo.findById(1L)).thenReturn(Optional.of(testTopping));
		mockMvc.perform(get("/api/ingrediants/1"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().json(mapper.writeValueAsString(testTopping),true));
	}
	
	
}
