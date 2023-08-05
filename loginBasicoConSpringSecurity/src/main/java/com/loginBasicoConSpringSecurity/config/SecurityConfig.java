package com.loginBasicoConSpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

// Con estas dos anotaciones le estamos indicando a Spring que vamos a configurar la seguridad en esta Clase.
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /*
     .csrf().disable()	=> Cross-Site Request Forgery. Seguidad especialmente para trabajar con Formularios WEB. 
    */
	
	//. OPCION 1:
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//		
//		return httpSecurity
//				.authorizeHttpRequests() 								//  A traves de esta propiedad se indica que URLS van a estar protegidas y cuales no lo estaran
//					.requestMatchers("/","/v1/index3").permitAll()		// URLs que NO van a necesitar autorizacion para ingresar.
//					.anyRequest().authenticated() 						// Cualquier otra URL va a requerir autenticacion.
//				.and()													// Literal '&', separa un metodo del otro.
//				.formLogin().permitAll()								// Habilita el formulario de Login.
//				.and()	
//				.build(); 												// Este metodo retorna un SecurityFilterChain.
//	}

	
	//. OPCION 2:
  @Bean
  SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
  
	  return httpSecurity
		  				.authorizeHttpRequests( auth -> {
		  					auth.requestMatchers("/","/v1/index3").permitAll();
		  					auth.anyRequest().authenticated();
				  			})
					  .formLogin()
					  	.successHandler(successHandler()) 	// En el caso de que se introduzca correctamente usuario y contraseña, indica el endpoint post Login a través de un AuthenticationSuccessHandler
			  			.permitAll()
					  .and()
					  .sessionManagement()					// Nos va a permitir admiinistrar las Sesiones.
					  	.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)  // Politica de creacion (ALWAYS - IF_REQUIRED - NEVER - STATELESS). Always => Si ya existe un sesion del va a utlizar esa, y si no existe creara una nueva.
					  	.invalidSessionUrl("/login")		// En en el caso de que el inicio de sesion se erroneo, indica el endpoint a donde dirigirse.
					  	.maximumSessions(1)                 // Maximo de sesiones en paralelo, generalmente destinado para aplicaciones multiplataforma. Para el resto de los casos generalmente el valor sera 1.
					  	.expiredUrl("/login")				// Indica la URL para cuando se cerro la sesion por haber cumplido un determinado tiempo de inactividad.
					  	.sessionRegistry(sessionRegistry())
					  .and()
					  .sessionFixation()					// Vulnerabilidad que evita que se utilicen los datos de id de tu sesion.
					  	.migrateSession()					// Indica la solucion para tratar la vulnerabilidad. En este caso, ante un posible ataque se migran los datos de id de la Sesion a otra (migrateSession () - newSession() - none()).
					  .and()
					  .build();
	}
  
  
  // Este metodo nos va a ayudar a obtener los datos de la Sesion y lo vamos a ingresar en el sessionRegistry del filterChain.
  @Bean
  public SessionRegistry sessionRegistry() {
	  return new SessionRegistryImpl();
  }
  
  
  public AuthenticationSuccessHandler successHandler() {
	  return ((request, response, authentication) -> {
		  response.sendRedirect("/bienvenido");
//		  response.sendRedirect("/v1/sesionDetalles");
	  });
  }
  
}
