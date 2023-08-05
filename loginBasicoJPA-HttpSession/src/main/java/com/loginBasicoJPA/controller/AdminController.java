package com.loginBasicoJPA.controller;

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

import com.loginBasicoJPA.login.Validator;
import com.loginBasicoJPA.model.Role;
import com.loginBasicoJPA.model.Usuario;
import com.loginBasicoJPA.model.DTO.UsuarioDTO;
import com.loginBasicoJPA.services.IRolService;
import com.loginBasicoJPA.services.IUsuarioLoginService;

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
	
	
	//# GET
	
	//. INICIO DE SESION - ADMINISTRADOR - BIENVENIDA:
	@GetMapping("")
	public String login(Model model) throws IOException {

		session = request.getSession();
		
//		boolean sessionActive = Boolean.parseBoolean(session.getAttribute("session").toString());
//		String mensaje = session.getAttribute("mensaje").toString();
		Role role = (Role) session.getAttribute("role");
		
		try {
			if (role.getNombreRole().equals("admin")) {
				usuario.setNombreUsuario(session.getAttribute("userName").toString());
				usuario.setRole((Role) session.getAttribute("role"));
				
				session.setAttribute("roleName", usuario.getRole().getNombreRole());
				
				model.addAttribute("userName", usuario.getNombreUsuario());
				model.addAttribute("roleName", usuario.getRole().getNombreRole());
//				model.addAttribute("sessionActive", sessionActive);
				return "administrador/welcomeAdmin";
			}else {
				List<Usuario> usuarios = usuarioLoginService.findAll();
				String mensaje = "******** Estas intentando ingresar a una funcionalidad de Administrador con un perfil de Usuario ********";
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
	public String test(Model model) throws IOException {
		
			validator.ValidadorAdministrador(model);
		
		
		String userName = session.getAttribute("userName").toString();
		String roleName = session.getAttribute("roleName").toString();
		model.addAttribute("userName", userName);
		model.addAttribute("roleName", roleName);
		return "administrador/TestAdmin";
	}
	
	
	@GetMapping("/test2")
	public String test2(Model model) {
		try {
			validator.ValidadorAdministrador(model);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String userName = session.getAttribute("userName").toString();
		String roleName = session.getAttribute("roleName").toString();
		model.addAttribute("userName", userName);
		model.addAttribute("roleName", roleName);
		return "administrador/TestAdmin2";
	}

	
	
	// # POST
//	@PostMapping("/save")
//    public String save(Usuario usuario, @RequestParam int idRol) {
//    	LOGGER.info("usuarioLogin: {}" + usuario);
//    	usuario.setRol(rolService.get(idRol).get());
//    	usuarioLoginService.create(usuario);
//    	return "redirect:/login/singup";
//    }
	

}
