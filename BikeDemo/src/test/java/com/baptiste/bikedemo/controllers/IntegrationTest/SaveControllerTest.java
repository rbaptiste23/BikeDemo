package com.baptiste.bikedemo.controllers.IntegrationTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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

import com.baptiste.bikedemo.controllers.SaveController;
import com.baptiste.bikedemo.model.Bike;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SaveControllerTest {

	@Autowired 
	SaveController saveController;

	@Mock
	Model model;
	
	
	@Test
	public void testViewFormNotNull() {
		
		String outcome = saveController.viewForm(model);
		assertThat(outcome, is(equalTo("bikelistsaveform")));
		

	}
	
	@Test
	public void testViewFormNull() {
		
		String outcome = saveController.viewForm(null);
		assertThat(outcome, is(equalTo("error")));
		
	}

	@Test
	public void testUpdateNoParmEvent() {
		
		Bike bike = new Bike();
		bike.setEmail("bjackson@yahoo.com");
		bike.setName("Bobby Jackson");
		bike.setPurchasePrice(new BigDecimal(508.23));
		bike.setSerialNumber("SN9876543210");
		bike.setPhone("405-448-8747");
		bike.setModel("XM300");
		bike.setPurchaseDate(new Date());
		
		// POST our Bike form bean to the controller; check the outcome.
		String outcome = saveController.updateNoParmEvent(bike);

		
		// Assert That the outcome is as expected
		assertThat(outcome, is(equalTo("bikelistsaveform")));
		
	}
	
	
	@Test
	public void testBikeNoPurchasePrice() {
		
		Bike bike = new Bike();
		bike.setEmail("bjackson@yahoo.com");
		bike.setName("Bobby Jackson");
		//bike.setPurchasePrice(new BigDecimal(508.23));
		bike.setSerialNumber("SN9876543210");
		bike.setPhone("405-448-8747");
		bike.setModel("XM300");
		bike.setPurchaseDate(new Date());
		
		// POST our Bike form bean to the controller; check the outcome.
		String outcome = saveController.updateNoParmEvent(bike);
		
		// Assert That the outcome is as expected
		assertThat(outcome, is(equalTo("failure")));
		
	}

}
