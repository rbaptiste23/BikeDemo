package com.baptiste.bikedemo.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(value = WelcomeController.class, secure = false)
public class WelcomeControllerTest {

	@Autowired
	private MockMvc mockMvc; 
	

	WelcomeController welcomeController;
	
	
	
	
	
	@Test
	public void testViewHome() {
		WelcomeController mockWelcomeController = mock(WelcomeController.class);
		
	    Mockito.when(mockWelcomeController.viewHome()).thenReturn("bikelisthome");
		
	    WelcomeController wc = new WelcomeController();
	    assertEquals("bikelisthome", wc.viewHome());
		
		
		
	}

}
