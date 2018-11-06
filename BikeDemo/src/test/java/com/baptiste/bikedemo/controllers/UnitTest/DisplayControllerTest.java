package com.baptiste.bikedemo.controllers.UnitTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.baptiste.bikedemo.controllers.DisplayController;
import com.baptiste.bikedemo.model.Bike;
import com.baptiste.bikedemo.service.BikeService;

@RunWith(SpringRunner.class)
@WebMvcTest(DisplayControllerTest.class)
public class DisplayControllerTest  {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	BikeService bikeService;

	@InjectMocks
	DisplayController displayController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(displayController)
				.build();
	}

	@Test
	@WithMockUser(username = "riley", password = "test", roles = { "USER" })
	public void testViewAll() throws Exception {
		mockMvc.perform(get("/Display")).andExpect(status().isOk()).andReturn();
	}

	@Test
	@WithMockUser(username = "riley", password = "test", roles = { "USER" })
	public void testGetEvent() throws Exception {
		// Mocking the Service saving the bike..
		Bike mockBike = new Bike();

		mockBike.setEmail("bjackson@yahoo.com");
		mockBike.setName("Bobby Jackson");
		mockBike.setPurchasePrice(new BigDecimal(508.23));
		mockBike.setSerialNumber("SN9876543210");
		mockBike.setPhone("405-448-8747");
		mockBike.setModel("XM300");
		mockBike.setPurchaseDate(new Date());

		
		
		when(bikeService.saveBike(mockBike)).thenReturn(true);
		mockMvc.perform(get("/Display/3")).andExpect(status().isOk()).andReturn();
	}

	@Test
	public void testPageViewOneByOne() throws Exception {
		
		Page<Bike> pp = null; 		
		when(bikeService.getBike(5)).thenReturn(pp);
		mockMvc.perform(get("/Display/Page?p=3")).andExpect(status().isOk()).andReturn();
		
	}

}
