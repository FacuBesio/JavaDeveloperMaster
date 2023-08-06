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
@RequestMapping("/administrador")
public class AdminController {
		
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
	
	//. INICIO DE SESION - ADMINISTRADOR - BIENVENIDA:
	@GetMapping("")
	public String getAdminHome(Model model) throws IOException {
		
		validator.validadorAdministrador(model);
		
		return "administrador/welcomeAdmin";
		
	}
	
	//. PAGINA ALTERNATIVA- ADMINISTRADOR:
	@GetMapping("/test")
	public String getAdminTest(Model model) throws IOException{

			validator.validadorAdministrador(model);

			return "administrador/TestAdmin";
	}
	

	//. PAGINA2 ALTERNATIVA - ADMINISTRADOR:
	@GetMapping("/test2")
	public String getAdminTest2(Model model) throws IOException {
		
			validator.validadorAdministrador(model);

			return "administrador/TestAdmin2";
	}

}
