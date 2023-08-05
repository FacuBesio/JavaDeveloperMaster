package com.proyectDemo.loginUtils;

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
	

	public void ValidadorAdministrador(Model model) throws IOException  {
		
		try {
			session = request.getSession();
			
			boolean sessionActive = Boolean.parseBoolean(session.getAttribute("session").toString());
			Role role = (Role) session.getAttribute("role");
			String roleName = role.getNombreRole();
			String userName = session.getAttribute("userName").toString();
			
			if (role.getNombreRole().equals("admin") && sessionActive == true) {
				session.setAttribute("roleName", roleName);
				model.addAttribute("roleName", roleName);
				model.addAttribute("userName", userName);
			} else {
				response.sendRedirect("/error/invalidRole");
			}
		} catch (NullPointerException e) {
			response.sendRedirect("/error/invalidSession");
		} catch (Exception e) {
			System.out.println("***********************" + e);
		}
	}
	
	
	public void ValidadorUsuario(Model model) throws IOException {
		
		try {
			session = request.getSession();
			
			boolean sessionActive = Boolean.parseBoolean(session.getAttribute("session").toString());
			Role role = (Role) session.getAttribute("role");
			String roleName = role.getNombreRole();
			String userName = session.getAttribute("userName").toString();
			
			if (role.getNombreRole().equals("user") && sessionActive == true) {
				session.setAttribute("roleName", roleName);
				model.addAttribute("roleName", roleName);
				model.addAttribute("userName", userName);
			} else {
				response.sendRedirect("/error/invalidRole");
			}
		} catch (NullPointerException e) {
			response.sendRedirect("/error/invalidSession");
		} catch (Exception e) {
			System.out.println("***********************" + e);
		}
	}

}
