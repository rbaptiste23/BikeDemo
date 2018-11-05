package com.baptiste.bikedemo.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.baptiste.bikedemo.model.Bike;
import com.baptiste.bikedemo.repository.BikeRepository;
import com.baptiste.bikedemo.service.BikeService;

@Controller
@RequestMapping("/Create")
public class CreateController {
	
	
	@Autowired 
	BikeService bikeService;
 
	// Controller -> Service -> Model 
		
	@GetMapping
	public String viewForm(Model model) {				
		System.out.println("Returning " + this.bikeService.getAllBikes().size() + " Bikes to bikes.jsp");	
		// Validation 
		model.addAttribute("bike", new Bike());
		return "bikelistcreateform";
	}
	
	//Create 
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public String processEvent(@Valid Bike bike, BindingResult result, Model model) {
		System.out.println(bike);
		
	    if (result.hasErrors()) {	    		
        	return "bikelistcreateform";        
        }
	    
	    bikeService.saveBike(bike);			
		model.addAttribute("bikelist", this.bikeService.getAllBikes());	
		 
		 
		return "bikelistcreateform";
	
	}
	

	

	 
		
}
