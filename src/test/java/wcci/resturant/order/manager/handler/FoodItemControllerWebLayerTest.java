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

@WebMvcTest(FoodItemController.class)
@RunWith(SpringRunner.class)
public class FoodItemControllerWebLayerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	FoodItemRepository foodItemRepo;
	
	private FoodItem testFoodItem;
	private ObjectMapper mapper = new ObjectMapper();
	
	@Before
	public void setup() {
		testFoodItem =  new FoodItem("FoodType","Ingredeints","adsditional comment");
	}
	
	@Test
	public void fetchCollectionOfFoodItems() throws Exception{
	when(foodItemRepo.findAll()).thenReturn(Collections.singletonList(testFoodItem));
	mockMvc.perform(get("/api/fooditems"))
	.andDo(print())
	.andExpect(status().isOk())
	.andExpect(content().contentType("application/json;charset=UTF-8"))
	.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testFoodItem)),true));	
	}
	@Test
	public void fetchSingleFoodItems() throws Exception{
	when(foodItemRepo.findById(1L)).thenReturn(Optional.of(testFoodItem));
	mockMvc.perform(get("/api/fooditems/1"))
	.andDo(print())
	.andExpect(status().isOk())
	.andExpect(content().contentType("application/json;charset=UTF-8"))
	.andExpect(content().json(mapper.writeValueAsString(testFoodItem),true));	
	}
	
	
	
	
	
	
}