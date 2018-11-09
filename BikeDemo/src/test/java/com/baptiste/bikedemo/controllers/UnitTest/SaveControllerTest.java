package com.baptiste.bikedemo.controllers.UnitTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.baptiste.bikedemo.controllers.SaveController;
import com.baptiste.bikedemo.service.BikeService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class SaveControllerTest {

	@Autowired
	SaveController saveController;

	@Autowired
	private BikeService bikeService;

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	Model model;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(saveController)
				.build();
	}

	@Test
	void testViewFormNotNull() {
		String outcome = saveController.viewForm(model);
		assertThat(outcome, is(equalTo("bikelistsaveform")));

	}

	@Test
	void testViewFormNull() {
		String outcome = saveController.viewForm(null);
		assertThat(outcome, is(equalTo("bikelistsaveform")));

	}



}
