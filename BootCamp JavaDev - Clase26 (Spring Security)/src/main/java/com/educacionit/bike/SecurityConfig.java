package com.educacionit.bike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.educacionit.bike.services.UserService;

@Configuration // Indicamos a Spring que es una Clase de configuración.
@EnableWebSecurity // Habilitamos la seguridad Web de Spring (esta anotacion se puede omitir).
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private BCryptPasswordEncoder bCryp;
	
	@Autowired
	private UserService userDetailService;
	
	
	// Método que utilizaremos para codificar nuestras passwords.
	/* Mediante @Bean Defino una instancia en el core container de Spring, para que luego se pueda 
	llamar desde otra capa la instancia a través de un @Autowired. En nuestro caso la capa sera la 'test'. */
	@Bean 
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	
	/* Sobreescribimos el método de WebSecurityConfigurerAdapter, es aqui donde estoy diciendo a Spring lo mismo 
	que pusimos en el 'application.properties' mediante los comandos 'spring.security.user.name=alex' y 
	'spring.security.user.password=1234'	*/
	@Override 
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
	//. En el caso de querer montar mis users en Memoria (sin persisitencia) por una cuestión practica o de Testing:
		//. Ejemplo de dos user con distintos Roles en Memoria:
//		 auth
//		.inMemoryAuthentication()
//		.withUser("alex")
//		.password("1234")
//		.roles("USER")
//		.and()
//		.withUser("UsuarioAdmin1")
//		.password("claveAdmin")
//		.roles("USER", "ADMIN"); //estos son los roles del user "UsuarioAdmin1"
		
		//. Ejemplo de dos user con distintos desde base de datos:
		// Al objeto auth mediante el metodo "userDetailsService()" le pasamos la 
		//implementacion que creamos de "userDetailsService" (clase UserService)
		auth.userDetailsService(userDetailService).passwordEncoder(bCryp);
	}
	
	/*Sobresscribimos el método de "WebSecurityConfigurerAdapter" para decirle a Spring 
	que todo Request (peticion) que ingresa debe estar autenticada de lo contratio no podra 
	obtener el response que espera. */
	@Override 
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}

}	
