package com.mitocode.springMain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.beans.Ciudad;
import com.mitocode.beans.Persona;




public class App {

	public static void main(String[] args) {
		
		//• Persona
		ApplicationContext contextPersona = new ClassPathXmlApplicationContext("com/mitocode/xml/applicationContext.xml");
		Persona per =  (Persona) contextPersona.getBean("persona");
		
		System.out.println(per.getApodo());
		
		
//		System.out.println(per.getId()+ ", " +per.getNombre()+ " ("+per.getApodo()+") - "
//						  + per.getCiudad().getNombre() + " - " + per.getPais().getNombre());
		
		((ConfigurableApplicationContext)contextPersona).close();
	}

}
