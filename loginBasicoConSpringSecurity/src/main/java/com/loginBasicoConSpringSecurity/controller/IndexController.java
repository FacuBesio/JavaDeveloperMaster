package com.loginBasicoConSpringSecurity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/")
public class IndexController {
	
	private Logger LOGGER= LoggerFactory.getLogger(IndexController.class);
	
	@GetMapping("")
	public String home(Model model) {

		return "index";
	}
	
	@GetMapping("/bienvenido")
	public String bienvenido(Model model) {

		return "indexPostLogin";
	}
	

	

}
	
	
	
	
	
	
	
	