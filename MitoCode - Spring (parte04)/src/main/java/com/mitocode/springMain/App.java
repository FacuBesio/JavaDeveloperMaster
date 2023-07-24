package com.mitocode.springMain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mitocode.beans.Persona;
import com.mitocode.beans2.Persona2;



public class App {

	public static void main(String[] args) {
		
		//• Persona: 
		ApplicationContext contextPersona = new ClassPathXmlApplicationContext("com/mitocode/xml/applicationContext.xml");
		Persona per =  (Persona) contextPersona.getBean("persona");
		
		System.out.println(per.getId()+ ", " +per.getNombre()+ " ("+per.getApodo()+")");
		
		((ConfigurableApplicationContext)contextPersona).close();
		
		//• Persona2 (con Objetos de otras Clases anidados)
		ApplicationContext contextPersona2 = new ClassPathXmlApplicationContext("com/mitocode/xml/applicationContext2.xml");
		Persona2 per2 =  (Persona2) contextPersona2.getBean("persona2");
		
		System.out.println(per2.getId()+ ", " +per2.getNombre()+ " ("+per2.getApodo()+") - "
						  +per2.getPais().getCiudad().getNombre() + ",  " + per2.getPais().getNombre());
		
		((ConfigurableApplicationContext)contextPersona2).close();
	}

}
