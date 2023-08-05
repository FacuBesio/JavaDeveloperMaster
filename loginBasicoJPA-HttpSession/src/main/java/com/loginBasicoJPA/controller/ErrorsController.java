package com.loginBasicoJPA.controller;

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

import com.loginBasicoJPA.model.Role;
import com.loginBasicoJPA.model.Usuario;
import com.loginBasicoJPA.services.IRolService;
import com.loginBasicoJPA.services.IUsuarioLoginService;

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
	
	@GetMapping("/invalidRole")
	public String invalidRole(Model model) {
		List<Usuario> usuarios = usuarioLoginService.findAll();
		String mensaje="******* ESTAS INTENTANDO INGRESAR A UNA FUNCION QUE NO CORRESPONDE CON TU PERFIL ********";
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("mensaje", mensaje);
		return "sessions/login";
	}
	
	
	@GetMapping("/invalidSession")
	public String sessionInvalid(Model model) {
		List<Usuario> usuarios = usuarioLoginService.findAll();
		String mensaje="******* ESTAS INTENTANDO INGRESAR SIN INICIAR SESION. POR FAVOR INICIA SESION. ********";
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("mensaje", mensaje);
		return "sessions/login";
	}
	

}
