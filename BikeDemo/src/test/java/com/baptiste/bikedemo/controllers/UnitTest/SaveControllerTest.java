package com.baptiste.bikedemo.controllers.UnitTest;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.baptiste.bikedemo.controllers.SaveController;
import com.baptiste.bikedemo.model.Bike;
import com.baptiste.bikedemo.service.BikeService;

@RunWith(SpringRunner.class)
@WebMvcTest(SaveController.class)
class SaveControllerTest {

   @Autowired 
   private MockMvc mockMvc;
   
   
   @MockBean
   private BikeService bikeService; 
   
   @MockBean 
   SaveController saveController; 
   
   
	
	@Before 
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testViewForm() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateNoParmEvent() throws Exception {
		Bike mockBike = new Bike();
		
		mockBike.setEmail("bjackson@yahoo.com");
		mockBike.setName("Bobby Jackson");
		mockBike.setPurchasePrice(new BigDecimal(508.23));
		mockBike.setSerialNumber("SN9876543210");
		mockBike.setPhone("405-448-8747");
		mockBike.setModel("XM300");
		mockBike.setPurchaseDate(new Date());
		
		when(bikeService.saveBike(mockBike)).thenReturn(true);
		
		// simulate the ofrm bean that would POST from the web page..
		
		mockMvc
		      .perform(post("/Save",null));
		
		
		
	}

}
