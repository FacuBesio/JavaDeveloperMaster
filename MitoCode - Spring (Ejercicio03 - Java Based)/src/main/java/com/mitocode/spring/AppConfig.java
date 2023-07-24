package com.mitocode.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mitocode.beans.Barcelona;
import com.mitocode.beans.Camiseta;
import com.mitocode.beans.Jugador;
import com.mitocode.beans.Marca;
import com.mitocode.beans.PSG;
/*
Este un equivalente al archivo XML.
 */
@Configuration
public class AppConfig {
	
	@Bean
	Jugador jugador() {
		return new Jugador();
	}
	
	@Bean
	Barcelona barcelona() {
		return new Barcelona();
	}
	
	@Bean
	PSG psg() {
		return new PSG();
	}
	
	@Bean
	Camiseta camiseta() {
		return new Camiseta();
	}
	
	@Bean
	Marca marca() {
		return new Marca();
	}

}
