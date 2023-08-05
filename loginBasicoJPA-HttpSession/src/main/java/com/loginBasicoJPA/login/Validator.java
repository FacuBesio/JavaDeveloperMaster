package com.loginBasicoJPA.login;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.loginBasicoJPA.model.Role;
import com.loginBasicoJPA.model.Usuario;
import com.loginBasicoJPA.model.DTO.UsuarioDTO;
import com.loginBasicoJPA.services.IRolService;
import com.loginBasicoJPA.services.IUsuarioLoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

@Component
public class Validator {
	
	@Autowired
	HttpServletResponse response;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	
	
	public void ValidadorAdministrador(Model model) throws IOException {
		
			session = request.getSession();
		try {	
			boolean sessionActive = Boolean.parseBoolean(session.getAttribute("session").toString());
			String roleName = session.getAttribute("roleName").toString();
			
			if (!(roleName.equals("admin")) || sessionActive == false ) {
				response.sendRedirect("/login/invalidRole");
			}
			
		} catch (NullPointerException e) {
			response.sendRedirect("/error/invalidSession");
		} catch (Exception e) {
			System.out.println("***********************" + e);
		}
		
	}
	
	public void ValidadorUsuario(Model model) throws IOException {
		
		session = request.getSession();
		
		boolean sessionActive = Boolean.parseBoolean(session.getAttribute("session").toString());
		String roleName = session.getAttribute("roleName").toString();
		
		if (!(roleName.equals("user")) || sessionActive == false ) {
			response.sendRedirect("/login/invalidRole");
		}
	}

}
