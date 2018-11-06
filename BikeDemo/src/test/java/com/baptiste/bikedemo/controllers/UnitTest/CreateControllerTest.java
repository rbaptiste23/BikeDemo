package com.baptiste.bikedemo.controllers.UnitTest;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.baptiste.bikedemo.controllers.CreateController;
import com.baptiste.bikedemo.model.Bike;
import com.baptiste.bikedemo.service.BikeService;

@RunWith(SpringRunner.class)
@WebMvcTest(CreateController.class)
public class CreateControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	BikeService bikeService;

	@InjectMocks
	CreateController createController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(createController)
				.build();
	}

	@Test
	public void testViewForm() {
		fail("Not yet implemented");
	}

	@Test
	@WithMockUser(username = "admin", password = "test2", roles = { "ADMIN" })
	public void testProcessEvent() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		Bike mockBike = new Bike();

		mockBike.setEmail("bjackson@yahoo.com");
		mockBike.setName("Bobby Jackson");
		mockBike.setPurchasePrice(new BigDecimal(508.23));
		mockBike.setSerialNumber("SN9876543210");
		mockBike.setPhone("405-448-8747");
		mockBike.setModel("XM300");
		mockBike.setPurchaseDate(new Date());

		// Mocking the Service saving the bike..
		when(bikeService.saveBike(mockBike)).thenReturn(true);

		// Simulate the form bean that would POST from the web page.
		Bike aBike = new Bike();

		aBike.setEmail("bjackson@yahoo.com");
		aBike.setName("Bobby Jackson");
		aBike.setPurchasePrice(new BigDecimal(508.23));
		aBike.setSerialNumber("SN9876543210");
		aBike.setPhone("405-448-8747");
		aBike.setModel("XM300");
		// aBike.setPurchaseDate(new Date());
		aBike.setContact(true);

		// simulate the form bean that would POST from the web page..
		mockMvc.perform(post("/Create", aBike))
				// .andExpect(status().isForbidden()).andReturn();
				.andExpect(status().isOk()).andReturn();

	}

	// Http Status Codes
	/*
	 * 100 - Informational 200 - Success 300 - Redirection 400 - Client Error 500 -
	 * Server Error
	 */

}
