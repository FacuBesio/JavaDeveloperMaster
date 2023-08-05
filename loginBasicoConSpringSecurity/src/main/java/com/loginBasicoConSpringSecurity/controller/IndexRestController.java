package com.loginBasicoConSpringSecurity.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("v1")
public class IndexRestController {
	
	@Autowired
	private SessionRegistry sessionRegistry;
	
	
	@GetMapping("/index2")
	public String index2(Model model) {

		return "hola mundo desde index 2";
	}
	
	@GetMapping("/index3")
	public String index3(Model model) {
		
		return "hola mundo NO SECURED desde index 3";
	}
	
	
	@GetMapping("/sesionDetalles")
	public ResponseEntity<?> getDetailSession() {
		
		String sessionId = "";
		User userObject = null;
		
		List<Object> sessions = sessionRegistry.getAllPrincipals();   // Recupero todas la informacion de las sessiones conectadas a mi aplicacion. 
		
		for (Object session : sessions) {
			if(session instanceof User) {
				userObject = (User)session;
			}
			
			List<SessionInformation> sessionInformations = sessionRegistry.getAllSessions(session, false);
			
			for (SessionInformation sessionInf : sessionInformations) {
				sessionId = sessionInf.getSessionId();
			}
		}
		
		Map<String, Object> response = new HashMap<String, Object>();
		
		response.put("response", "Hello World");
		response.put("sessionId", sessionId);
		response.put("sessionUser", userObject);
		
		
		return ResponseEntity.ok(response);
	}
	

}
	
	
	
	
	
	
	
	