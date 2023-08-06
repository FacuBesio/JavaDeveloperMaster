package com.proyectDemo.loginUtils;

import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.proyectDemo.model.Role;
import com.proyectDemo.model.Usuario;
import com.proyectDemo.model.dto.UsuarioDTO;
import com.proyectDemo.services.IUsuarioLoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;


@Component
public class Validator {
	
	private final Logger LOGGER= LoggerFactory.getLogger(Validator.class);
	
	@Autowired
	UsuarioDTO usuario;
	
	@Autowired
	IUsuarioLoginService usuarioLoginService;
	
	@Autowired
	HttpServletResponse response;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	

	//# VALIDADOR DE USUARIO Y CONTRASEÑA 
	public String validadorUserAndPassword(String nombreUsuario, String password, Model model){
		List<Usuario> list = usuarioLoginService.findAll();
		String mensaje="";
		boolean testigo = false;
		String url = "sessions/login";
		
		for(Usuario userLog : list) {
			
			// Verificacion USUARIO
			if(userLog.getNombreUsuario().equals(nombreUsuario)) {
				
				// Verificacion CONTRASEÑA
				if(userLog.getPassword().equals(password)) {
					testigo = true;
									
					session = request.getSession();
					session.setAttribute("userName", userLog.getNombreUsuario());
		    		session.setAttribute("role", userLog.getRole());
		    		session.setAttribute("session", true);
		    							
					//. Verificacion ROL ---> En esta instancia el Usuario y la Contraseña son CORRECTOS.
					String role= userLog.getRole().getNombreRole();	
					switch (role){   
						case "admin":
							url = "redirect:/administrador";
			                break;
						case "user":
							url = "redirect:/usuario";
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
	
	
	//# VALIDADOR DE PERFIL ADMINISTRADOR 
	public void validadorAdministrador(Model model) throws IOException  {
		
		try {
			
			session = request.getSession();
			
			boolean sessionActive = Boolean.parseBoolean(session.getAttribute("session").toString());
			Role role = (Role) session.getAttribute("role");
			String roleName = role.getNombreRole();
			String userName = session.getAttribute("userName").toString();
			
			if (role.getNombreRole().equals("admin") && sessionActive == true) {
				session.setAttribute("roleName", roleName);
				model.addAttribute("roleName", roleName);
				model.addAttribute("userName", userName);
			} else {
				response.sendRedirect("/error/invalidRole");
			}
		} catch (NullPointerException e) {
			response.sendRedirect("/error/invalidSession");
		} catch (Exception e) {
			response.sendRedirect("/error");
			LOGGER.info("---->>>> Error: "+ e);
		}
	}
	
	
	//# VALIDADOR DE PERFIL USUARIO 
	public void validadorUsuario(Model model) throws IOException {
		
		try {
			session = request.getSession();
			
			boolean sessionActive = Boolean.parseBoolean(session.getAttribute("session").toString());
			Role role = (Role) session.getAttribute("role");
			String roleName = role.getNombreRole();
			String userName = session.getAttribute("userName").toString();
			
			if (role.getNombreRole().equals("user") && sessionActive == true) {
				session.setAttribute("roleName", roleName);
				model.addAttribute("roleName", roleName);
				model.addAttribute("userName", userName);
			} else {
				response.sendRedirect("/error/invalidRole");
			}
		} catch (NullPointerException e) {
			response.sendRedirect("/error/invalidSession");
		} catch (Exception e) {
			response.sendRedirect("/error");
			LOGGER.info("---->>>> Error: "+ e);
		}
	}

}
