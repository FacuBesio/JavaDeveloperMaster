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

import com.loginBasicoJPA.model.Rol;
import com.loginBasicoJPA.model.Usuario;
import com.loginBasicoJPA.services.IRolService;
import com.loginBasicoJPA.services.IUsuarioLoginService;

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
	
	
	//# GET
	
	//. LOGIN - INGRESAR (Con un usuario ya existente, caso de que no existe se debe Registrar usuario primero) - 
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
		List<Rol> roles = rolService.findAll();
        model.addAttribute("usuariosLogin", usuariosLogin);
        model.addAttribute("roles", roles);
        return "sessions/singup";
	}
	
	
	//. CREAR ROLES/PERFILES (para crear poder crear un Usuario, primero se deberá crear al menos un tipo rol).
	@GetMapping("/createRole")
	public String crearRol(Model model) {
		List<Rol> roles = rolService.findAll();
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
	
	
	// # POST
	@PostMapping("/save")
    public String save(Usuario usuario, @RequestParam int idRol) {
    	LOGGER.info("usuarioLogin: {}" + usuario);
    	usuario.setRol(rolService.get(idRol).get());
    	usuarioLoginService.create(usuario);
    	return "redirect:/login/singup";
    }
	
	@PostMapping("/saveRole")
    public String saveRol(Rol rol) {
    	LOGGER.info("rol: {}" + rol);
    	rolService.create(rol);
    	return "redirect:/login/createRole";
    }
	
	//# Verificacion USUARIO, CONTRASEÑA y ROLES la BBDD: 
	@PostMapping("/userValidator")
	public String validarUsuario(@RequestParam String nombreUsuario, @RequestParam String password, Model model) {
		
		List<Usuario> list = usuarioLoginService.findAll();
		String mensaje="";
		boolean testigo = false;
		String url = "sessions/login";
		
		for(Usuario userLog : list) {
			//# Verificacion USUARIO
			if(userLog.getNombreUsuario().equals(nombreUsuario)) {
				
				//# Verificacion CONTRASEÑA
				if(userLog.getPassword().equals(password)) {
					testigo = true;
					mensaje= "Usuario Y Contraseña CORRECTOS - " + String.valueOf(testigo);
					model.addAttribute("userLogin", userLog);
					model.addAttribute("mensaje", mensaje);
					
					//. Verificacion ROL ---> En esta instancia el Usuario y la Contraseña son CORRECTOS.
					String rol= userLog.getRol().getNombreRol();	
					switch (rol){   
						case "admin":
							
						ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
							
							url = "administrador/welcomeAdmin";
			                break;
						case "user":
							url = "usuarios/welcomeUser";
			                break;
						default:
							url = "errors/welcomeUserSinRol";
			                break; 
					}
				}else{
					mensaje = "Contraseña incorrecta";
					testigo = false;
					model.addAttribute("usuarios", list);
					model.addAttribute("mensaje", mensaje);
					break;
				}
			}else if(!testigo){
				mensaje = "Usuario '" +nombreUsuario+ "' inexistente - " + String.valueOf(testigo);
				testigo = false;
			}
			model.addAttribute("usuarios", list);
			model.addAttribute("mensaje", mensaje);
		}
		return url;
	}
	

}
