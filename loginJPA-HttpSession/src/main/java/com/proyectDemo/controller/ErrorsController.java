package com.proyectDemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	
	//#### GET #### 
	
	// ERRORES GENERALES
	@GetMapping("")
	public String error(Model model) {
		List<Usuario> usuarios = usuarioLoginService.findAll();
		String mensaje = "- ADVERTENCIA: Ha ocurrido un error. Por favor inicia una sesión nuevamente. -";
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("mensaje", mensaje);
        LOGGER.info("ERROR: { " +mensaje+" }");
		return "sessions/login";
	}
	
	// ERROR: INGRESO A ENDPOINT SIN INCIAR SESION
	@GetMapping("/invalidSession")
	public String invalidSession(Model model) {
		List<Usuario> usuarios = usuarioLoginService.findAll();
		String mensaje="- ADVERTENCIA: Estas intentando ingresar sin iniciar sesión. Por favor inicia una sesión. - ";
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("mensaje", mensaje);
        LOGGER.info("ERROR: { " +mensaje+" }");
		return "sessions/login";
	}
	
	// ERROR: INGRESO A ENDPOINT CON UN PERFIL NO HABILITADO. 
	@GetMapping("/invalidRole")
	public String invalidRole(Model model) {
		List<Usuario> usuarios = usuarioLoginService.findAll();
		String mensaje="- ADVERTENCIA: Estas intentando ingresar a una funcionalidad que no corresponde con tu perfil. "
						+ "Por favor inicia una sesión con otro perfil o verifica el tipo de permisos que posee tu usuario . - ";
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("mensaje", mensaje);
        LOGGER.info("ERROR: { " +mensaje+" }");
		return "sessions/login";
	}
}
