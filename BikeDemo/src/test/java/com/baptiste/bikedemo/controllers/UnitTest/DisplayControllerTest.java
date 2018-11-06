package com.baptiste.bikedemo.controllers.UnitTest;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.baptiste.bikedemo.controllers.DisplayController;
import com.baptiste.bikedemo.service.BikeService;

@RunWith(SpringRunner.class)
@WebMvcTest(DisplayControllerTest.class)
public class DisplayControllerTest {

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
	public void testGetEvent() {
		fail("Not yet implemented");
	}

	@Test
	public void testPageViewOneByOne() {
		fail("Not yet implemented");
	}

}
