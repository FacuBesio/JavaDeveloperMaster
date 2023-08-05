package com.proyectDemo.controller;

import java.io.IOException;
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

import com.proyectDemo.loginUtils.Validator;
import com.proyectDemo.model.Role;
import com.proyectDemo.model.Usuario;
import com.proyectDemo.model.dto.UsuarioDTO;
import com.proyectDemo.services.IRolService;
import com.proyectDemo.services.IUsuarioLoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/administrador")
public class AdminController {
	private final Logger LOGGER= LoggerFactory.getLogger(AdminController.class);
	
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
	public String login(Model model) {
		
	
		
		try {
			session = request.getSession();
			
			boolean sessionActive = Boolean.parseBoolean(session.getAttribute("session").toString());
			Role role = (Role) session.getAttribute("role");
			
			if (role.getNombreRole().equals("admin") && sessionActive == true) {
				usuario.setNombreUsuario(session.getAttribute("userName").toString());
				usuario.setRole((Role) session.getAttribute("role"));
				
				session.setAttribute("roleName", usuario.getRole().getNombreRole());
			
				model.addAttribute("userName", usuario.getNombreUsuario());
				model.addAttribute("roleName", usuario.getRole().getNombreRole());
				model.addAttribute("sessionActive", sessionActive);
				return "administrador/welcomeAdmin";
			}else{
				List<Usuario> usuarios = usuarioLoginService.findAll();
				String mensaje = " - ADVERTENCIA: Estas intentando ingresar a una funcionalidad de 'ADMINISTRADOR' con un perfil de 'USUARIO'. -";
		        model.addAttribute("usuarios", usuarios);
		        model.addAttribute("mensaje", mensaje);
				return "sessions/login";
			}
		} catch (NullPointerException e) {
			List<Usuario> usuarios = usuarioLoginService.findAll();
			String mensaje = "- ADVERTENCIA: Estas intentando ingresar sin iniciar sesi�n. Por favor inicia una sesi�n. -";
	        model.addAttribute("usuarios", usuarios);
	        model.addAttribute("mensaje", mensaje);
			return "sessions/login";
		} catch (Exception e) {
			List<Usuario> usuarios = usuarioLoginService.findAll();
			String mensaje = "- ADVERTENCIA: Ha ocurrido un error. Por favor inicia una sesi�n nuevamente. -";
	        model.addAttribute("usuarios", usuarios);
	        model.addAttribute("mensaje", mensaje);
			return "sessions/login";
		}
	}
	
	//. PAGINA ALTERNATIVA- ADMINISTRADOR:
	@GetMapping("/test")
	public String getAdminTest(Model model) throws IOException{

			validator.ValidadorAdministrador(model);

			return "administrador/TestAdmin";
	}
	

	//. PAGINA2 ALTERNATIVA - ADMINISTRADOR:
	@GetMapping("/test2")
	public String getAdminTest2(Model model) throws IOException {
		
			validator.ValidadorAdministrador(model);

			return "administrador/TestAdmin2";
	}

}
