package com.proyectDemo.login;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyectDemo.model.Role;
import com.proyectDemo.model.Usuario;
import com.proyectDemo.model.dto.UsuarioDTO;
import com.proyectDemo.services.IRolService;
import com.proyectDemo.services.IUsuarioLoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

@Component
public class Validator {
	
	@Autowired
	UsuarioDTO usuario;
	
	@Autowired
	HttpServletResponse response;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	
	
	public void ValidadorAdministrador() throws IOException  {
			
		session = request.getSession();
		
		try {
			boolean sessionActive = Boolean.parseBoolean(session.getAttribute("session").toString());
			Role role = (Role) session.getAttribute("role");

			if (!(role.getNombreRole().equals("admin") && sessionActive == true)) {
				response.sendRedirect("/error/invalidSession");
			} 
		} catch (NullPointerException e) {
			response.sendRedirect("/error/invalidSession");
		} catch (Exception e) {
			System.out.println("***********************" + e);
		}
	}
	
	public void ValidadorUsuario() throws IOException {
		
		try {
			session = request.getSession();
			
			boolean sessionActive = Boolean.parseBoolean(session.getAttribute("session").toString());
			Role role = (Role) session.getAttribute("role");
			
			if (!(role.getNombreRole().equals("user") && sessionActive == true)) {
				response.sendRedirect("/error/invalidSession");
			} 
		} catch (NullPointerException e) {
			response.sendRedirect("/error/invalidSession");
		} catch (Exception e) {
			System.out.println("***********************" + e);
		}
	}

}
