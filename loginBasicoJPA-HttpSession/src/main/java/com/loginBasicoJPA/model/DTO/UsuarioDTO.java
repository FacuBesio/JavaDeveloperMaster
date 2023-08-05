package com.loginBasicoJPA.model.DTO;

import org.springframework.stereotype.Component;

import com.loginBasicoJPA.model.Role;




@Component
public class UsuarioDTO {
	
	
	private int id;
	private String nombreUsuario;
	private String password;

	private Role role;
	
	
	
	public UsuarioDTO() {
	}

	public UsuarioDTO(int id, String nombreUsuario, String password, Role role) {
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.role = role;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
