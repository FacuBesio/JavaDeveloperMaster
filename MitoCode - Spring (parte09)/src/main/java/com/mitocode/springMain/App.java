package com.mitocode.springMain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.beans.Barcelona;
import com.mitocode.beans.Jugador;
import com.mitocode.beans.PSG;
import com.mitocode.interfaces.IEquipo;


public class App {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/mitocode/xml/applicationContext.xml");
		
		//• Jugador
		System.out.println(". Jugador:");
		Jugador jugador = (Jugador) appContext.getBean("messi");
		System.out.println(jugador.getNombre() + " - " + jugador.getEquipo().mostrar());
		
		
		
		
		((ConfigurableApplicationContext)appContext).close();
	}

}
