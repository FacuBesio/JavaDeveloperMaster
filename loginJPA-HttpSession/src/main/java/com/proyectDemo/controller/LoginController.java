package com.proyectDemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.proyectDemo.loginUtils.Validator;
import com.proyectDemo.model.Role;
import com.proyectDemo.model.Usuario;
import com.proyectDemo.services.IRolService;
import com.proyectDemo.services.IUsuarioLoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/login")
public class LoginController {
	private final Logger LOGGER= LoggerFactory.getLogger(LoginController.class);
	 
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
	
	@Autowired
	Validator validator;
	
	
	//#### GET ####
	
	//. LOGIN - INGRESAR (Con usuario ya existente) - 
	@GetMapping("")
	public String login(Model model) {
		List<Usuario> usuarios = usuarioLoginService.findAll();
		String mensaje = "******** Por favor ingresa un Usuario y Contraseña ********";
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("mensaje", mensaje);
    	return "sessions/login";
	}
	
	//. SING UP - REGISTRAR USUARIO (crear usuario, cuando se ingresa por primera vez) - 
	@GetMapping("/singup")
	public String singup(Model model) {
		List<Usuario> usuariosLogin = usuarioLoginService.findAll();
		List<Role> roles = rolService.findAll();
        model.addAttribute("usuariosLogin", usuariosLogin);
        model.addAttribute("roles", roles);
        return "sessions/singup";
	}
	
	
	//. CREAR ROLES/PERFILES (para crear poder crear un Usuario, primero se deberá crear al menos un tipo rol).
	@GetMapping("/createRole")
	public String crearRole(Model model) {
		List<Role> roles = rolService.findAll();
        model.addAttribute("roles", roles);
		return "sessions/createRole";
	}
	
	//. ADMINISTRADOR DE USUARIO (Perfil Admin)
	@GetMapping("/userManager")
	public String adminUsers(Model model) {
		List<Usuario> usuariosLogin = usuarioLoginService.findAll();
        model.addAttribute("usuariosLogin", usuariosLogin);
        
		return "sessions/userManager";
	}
	
	
	// #### POST ####
	@PostMapping("/save")
    public String save(Usuario usuario, @RequestParam int idRol) {
    	LOGGER.info("usuarioLogin: {}" + usuario);
    	usuario.setRole(rolService.get(idRol).get());
    	usuarioLoginService.create(usuario);
    	return "redirect:/login/singup";
    }
	
	@PostMapping("/saveRole")
    public String saveRol(Role rol) {
    	LOGGER.info("rol: {}" + rol);
    	rolService.create(rol);
    	return "redirect:/login/createRole";
    }
	
	//# Verificacion USUARIO, CONTRASEÑA y ROLES la BBDD: 
	@PostMapping("/userValidator")
	public String validarUsuario(@RequestParam String nombreUsuario, @RequestParam String password, Model model) {
		
		return	validator.validadorUserAndPassword(nombreUsuario, password, model);
	}
}
