package com.baptiste.bikedemo.controllers.IntegrationTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.baptiste.bikedemo.controllers.CreateController;
import com.baptiste.bikedemo.model.Bike;
import com.baptiste.bikedemo.service.BikeService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CreateControllerTest {

	@Autowired
	CreateController createController;

	@Autowired
	BikeService bikeService;

	@Mock
	Model model;
	
	@Mock
	BindingResult result;
	
 
	
 
	
	@Test
	public void testViewForm() {
		Bike bike = new Bike();
		bike.setEmail("bjackson@yahoo.com");
		bike.setName("Bobby Jackson");
		bike.setPurchasePrice(new BigDecimal(508.23));
		bike.setSerialNumber("SN9876543210");
		bike.setPhone("405-448-8747");
		bike.setModel("XM300");
		bike.setPurchaseDate(new Date());

		model.addAttribute("bike", bike);

		String outcome = createController.viewForm(model);
		assertThat(outcome, is(equalTo("bikelistcreateform")));
	}

	@Test
	public void testProcessEvent() {
		Bike bike = new Bike();
		bike.setEmail("bjackson@yahoo.com");
		bike.setName("Bobby Jackson");
		bike.setPurchasePrice(new BigDecimal(508.23));
		bike.setSerialNumber("SN9876543210");
		bike.setPhone("405-448-8747");
		bike.setModel("XM300");
		bike.setPurchaseDate(new Date());
		
		Bike bike2 = new Bike();
		bike2.setEmail("bjackson@yahoo.com");
		bike2.setName("Bobby Jackson");
		bike2.setPurchasePrice(new BigDecimal(508.23));
		bike2.setSerialNumber("SN9876543210");
		bike2.setPhone("405-448-8747");
		bike2.setModel("XM300");
		bike2.setPurchaseDate(new Date());
		
 
		
		String outcome = createController.processEvent(bike, result, model);
						
		when(result.hasErrors()).thenReturn(true);
		String outcome2 = createController.processEvent(bike2, result, model);		
		assertThat(outcome, is(equalTo("bikelistcreateform")));
	}
	
	
 
}
