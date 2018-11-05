package com.baptiste.bikedemo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.baptiste.bikedemo.model.Bike;
import com.baptiste.bikedemo.repository.BikeRepository;
import com.baptiste.bikedemo.repository.PagingRepository;
import com.baptiste.bikedemo.service.BikeService;

@Controller
@RequestMapping("/Display")
public class DisplayController {
 
	
	@Autowired 
	BikeService bikeService;
 
	// Controller -> Service -> Model -> View
/*		
	@GetMapping
	public String viewAll(Model model) {				
		//model.addAttribute("customerlist", this.bikeService.getAllCustomer());
		model.addAttribute("customerlist", this.bikeService.get600Customer());
		//model.addAttribute("bikelist", this.bikeService.getAllBikes());					
		System.out.println("Returning " + this.bikeService.getAllBikes().size() + " Bikes to bikes.jsp");					
		return "bikelist";
	}*/
	
	@GetMapping
	public ModelAndView viewAll(ModelAndView modelAndView) {		
		modelAndView.setViewName("bikelist");
		modelAndView.getModel().put("customerlist", this.bikeService.get600Customer());			
		System.out.println("Returning " + this.bikeService.getAllBikes().size() + " Bikes to bikes.jsp");						
		return modelAndView;
	}
	
	@GetMapping("/{id}")
	public String getEvent(@PathVariable("id") long id, @ModelAttribute("Bike") Bike bike) {
		System.out.println(bike);
		bikeService.saveBike(bike);
		return "bikelist";
	}
	
	//Pagination
	@GetMapping("/Page")
	public String pageViewOneByOne(Model model, @RequestParam(name="p", defaultValue ="1") int pageNumber) {				
						
	    Page<Bike> page = bikeService.getBike(pageNumber);
	    model.addAttribute("page", page);		
		return "bikelistpage";
	}
		
}
