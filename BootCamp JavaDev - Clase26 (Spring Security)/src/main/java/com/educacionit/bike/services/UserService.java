package com.educacionit.bike.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.educacionit.bike.models.Usuario;
import com.educacionit.bike.repositories.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/* En este servico vamos a indicar a Spring de donde debe obtener los datos de los usuarios, sus roles, etc.. */
@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario us = repo.findByNombre(username);
		
		// Spring posee la Interface 'GrantedAuthority' para definir los roles de nuestra app
		// Aca lo vamos a hardcodear pero podria venir de la base de datos.
		List<GrantedAuthority> roles = new ArrayList<>();
		
		// Agrego un rol hardcodeado a la lista de roles 
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		UserDetails userDetails = new User(us.getNombre(),us.getClave(), roles);
		return userDetails;
	}

}
