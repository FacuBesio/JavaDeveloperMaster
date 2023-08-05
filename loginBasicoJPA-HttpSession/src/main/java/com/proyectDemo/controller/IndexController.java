package com.proyectDemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class IndexController {
	
	private Logger LOGGER= LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	HttpServletResponse response;
	
	@GetMapping("")
	public String home(Model model) {
		
		return "index";
	}
	
	

}
	
	
	
	
	
	
	
	