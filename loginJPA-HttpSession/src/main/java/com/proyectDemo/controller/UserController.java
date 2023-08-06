package com.proyectDemo.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proyectDemo.loginUtils.Validator;
import com.proyectDemo.model.dto.UsuarioDTO;
import com.proyectDemo.services.IRolService;
import com.proyectDemo.services.IUsuarioLoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/usuario")
public class UserController {
		
	@Autowired
	UsuarioDTO usuario;
	
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
	//. INICIO DE SESION - USUARIO - BIENVENIDA:
	@GetMapping("")
	public String login(Model model) throws IOException {
		validator.validadorUsuario(model);
		return "usuarios/welcomeUser";
	}
	
	
	//. PAGINA ALTERNATIVA- USUARIO:
	@GetMapping("/test")
	public String getUserTest(Model model)  throws IOException{

		validator.validadorUsuario(model);
		
		return "usuarios/TestUser";
	}
	
	
	//. PAGINA2 ALTERNATIVA- USUARIO:
	@GetMapping("/test2")
	public String getUserTest2 (Model model)  throws IOException{

		validator.validadorUsuario(model);

		return "usuarios/TestUser2";
	}
}
