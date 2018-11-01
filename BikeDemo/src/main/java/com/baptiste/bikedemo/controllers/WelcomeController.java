package com.baptiste.bikedemo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Welcome")
public class WelcomeController {
	
		
	@GetMapping
	public String viewHome() {									
		return "bikelisthome";
	}

		
}
