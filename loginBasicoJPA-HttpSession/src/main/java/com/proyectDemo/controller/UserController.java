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

import com.proyectDemo.login.Validator;
import com.proyectDemo.model.Role;
import com.proyectDemo.model.Usuario;
import com.proyectDemo.model.dto.UsuarioDTO;
import com.proyectDemo.services.IRolService;
import com.proyectDemo.services.IUsuarioLoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/usuario")
public class UserController {
	private final Logger LOGGER= LoggerFactory.getLogger(UserController.class);
	
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
	
	
	
	
	//# GET
	//. INICIO DE SESION - USUARIO - BIENVENIDA:
	@GetMapping("")
	public String login(Model model) {

		try {
			session = request.getSession();
			
			boolean sessionActive = Boolean.parseBoolean(session.getAttribute("session").toString());
			Role role = (Role) session.getAttribute("role");
			
			if (role.getNombreRole().equals("user") && sessionActive == true) {
				usuario.setNombreUsuario(session.getAttribute("userName").toString());
				usuario.setRole((Role) session.getAttribute("role"));
				
				session.setAttribute("roleName", usuario.getRole().getNombreRole());
			
				model.addAttribute("userName", usuario.getNombreUsuario());
				model.addAttribute("roleName", usuario.getRole().getNombreRole());
				model.addAttribute("sessionActive", sessionActive);
//				model.addAttribute("mensaje", mensaje);
				return "usuarios/welcomeUser";
			}else {
				List<Usuario> usuarios = usuarioLoginService.findAll();
				String mensaje = "******** Estas intentando ingresar a una funcionalidad de Usuario con un perfil de Administrador ********";
		        model.addAttribute("usuarios", usuarios);
		        model.addAttribute("mensaje", mensaje);
				return "sessions/login";
			}
		} catch (NullPointerException e) {
			List<Usuario> usuarios = usuarioLoginService.findAll();
			String mensaje = "******** Estas intentando ingresar sin iniciar Sesion. Por favor inicia sesion. ********";
	        model.addAttribute("usuarios", usuarios);
	        model.addAttribute("mensaje", mensaje);
			return "sessions/login";
		} catch (Exception e) {
			List<Usuario> usuarios = usuarioLoginService.findAll();
			String mensaje = "******** Ha oucrrido un error. Por favor inicia sesion nuevamente ********";
	        model.addAttribute("usuarios", usuarios);
	        model.addAttribute("mensaje", mensaje);
			return "sessions/login";
			
		}
		
		
	}
	
	
	@GetMapping("/test")
	public String test(Model model)  throws IOException{
//		try {
			validator.ValidadorUsuario();
//			String userName = session.getAttribute("userName").toString();
//			String roleName = session.getAttribute("roleName").toString();
//			model.addAttribute("userName", userName);
//			model.addAttribute("roleName", roleName);
//			return "usuarios/TestUser";
//		} catch (Exception e) {
//			List<Usuario> usuarios = usuarioLoginService.findAll();
//			String mensaje = "******** Ha oucrrido un error. Por favor inicia sesion nuevamente ********";
//	        model.addAttribute("usuarios", usuarios);
//	        model.addAttribute("mensaje", mensaje);
//			return "sessions/login";
//		}
		return "usuarios/TestUser";
		
	}
	
	
	@GetMapping("/test2")
	public String test2(Model model)  throws IOException{
//		try {
			validator.ValidadorUsuario();
//			String userName = session.getAttribute("userName").toString();
//			String roleName = session.getAttribute("roleName").toString();
//			model.addAttribute("userName", userName);
//			model.addAttribute("roleName", roleName);
//			return "usuarios/TestUser2";
//		} catch (Exception e) {
//			List<Usuario> usuarios = usuarioLoginService.findAll();
//			String mensaje = "******** Ha oucrrido un error. Por favor inicia sesion nuevamente ********";
//	        model.addAttribute("usuarios", usuarios);
//	        model.addAttribute("mensaje", mensaje);
//			return "sessions/login";
//		}
		return "usuarios/TestUser2";
		
	}
	

	

}