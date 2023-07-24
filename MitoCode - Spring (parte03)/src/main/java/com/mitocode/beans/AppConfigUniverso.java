package com.mitocode.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigUniverso {
	
	@Bean
	public Universo universo() {
		return new Universo();
	}
}

	/*Este AppConfig es el equivalente en Annotations al Bean hecho en 'xml'.
	
	<bean id="universo" class="com.mitocode.beans.Universo"> 
		<property name="saludo" value="Hola Universo"> </property>
	</bean>
	
	*/

