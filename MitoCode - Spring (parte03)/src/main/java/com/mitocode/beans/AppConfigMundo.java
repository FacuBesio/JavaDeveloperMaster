package com.mitocode.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigMundo {
	
	@Bean
	public Mundo tierra() {
		return new Mundo();
	}
	
	@Bean
	public Mundo marte() {
		return new Mundo();
	}
	
	

}
