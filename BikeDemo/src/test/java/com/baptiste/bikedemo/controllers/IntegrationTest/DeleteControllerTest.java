package com.baptiste.bikedemo.controllers.IntegrationTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.baptiste.bikedemo.controllers.DeleteController;
import com.baptiste.bikedemo.model.Bike;
import com.baptiste.bikedemo.service.BikeService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DeleteControllerTest {
	
	@Autowired 
	DeleteController deleteController;
	
	
	@Autowired 
	BikeService bikeService;
	

	@Test
	public void testDeleteGetEvent() {
		
		String outcome = deleteController.deleteGetEvent();
		assertThat(outcome, is(equalTo("bikelistdeleteform")));
	}

	@Test
	public void testDeleteNoEvent() {
		Bike bike = new Bike();
		bike.setId(14L);
		
		
		String outcome = deleteController.deleteNoEvent(bike);
		String outcome2 = deleteController.deleteNoEvent(null);
		
		assertThat(outcome, is(equalTo("bikelistdeleteform")));
	}

}
