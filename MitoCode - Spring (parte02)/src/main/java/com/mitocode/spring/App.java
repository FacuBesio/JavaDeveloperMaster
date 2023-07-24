package com.mitocode.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mitocode.beans.Mundo;

public class App {

	public static void main(String[] args) {
		
		//• 'con XML':
		System.out.println("â¢ Xml:");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/mitocode/xml/applicationContext.xml");
		
		Mundo mundoA = (Mundo) context.getBean("mundo");
		
		Mundo mundoB = context.getBean(Mundo.class);
		
		System.out.println(mundoA.getSaludo());
		
		mundoB.setSaludo("Hola Mundo desde MundoB");
		System.out.println(mundoB.getSaludo());
		
		((ConfigurableApplicationContext)context).close();
	}

}
