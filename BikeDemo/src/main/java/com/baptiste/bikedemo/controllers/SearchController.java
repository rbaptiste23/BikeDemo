package com.baptiste.bikedemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Search")
public class SearchController {

	@PostMapping() 
	public String search(Model model, @RequestParam("s") String text) {		
		System.out.println("Search text: " + text);		
		model.addAttribute(text);				
		return "bikelisthome";
	}
}
