package com.proyectDemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import com.proyectDemo.model.Role;
import com.proyectDemo.model.Usuario;
import com.proyectDemo.services.IRolService;
import com.proyectDemo.services.IUsuarioLoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/error")
public class ErrorsController {
	private final Logger LOGGER= LoggerFactory.getLogger(ErrorsController.class);
	 
	@Autowired
	IUsuarioLoginService usuarioLoginService;
	
	@Autowired
	IRolService rolService;
	
	@Autowired
	HttpServletResponse response;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	
	
	
	
	//# GET
	
	@GetMapping("/invalidSession")
	public String invalidSession(Model model) {
		List<Usuario> usuarios = usuarioLoginService.findAll();
		String mensaje="- ADVERTENCIA: Estas intentando ingresar sin iniciar sesión. Por favor inicia una sesión. - ";
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("mensaje", mensaje);
		return "sessions/login";
	}
	
	@GetMapping("/invalidRole")
	public String invalidRole(Model model) {
		List<Usuario> usuarios = usuarioLoginService.findAll();
		String mensaje="- ADVERTENCIA: Estas intentando ingresar a una funcionalidad que no corresponde con tu perfil. "
						+ "Por favor inicia una sesión con otro perfil o verifica el tipo de permisos que posee tu usuario . - ";
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("mensaje", mensaje);
		return "sessions/login";
	}
	

}
