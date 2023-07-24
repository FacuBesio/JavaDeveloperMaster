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
		
		// • Polimorfismo:
		System.out.println();
		System.out.println(". Polimorfismo");
		/*
		De esta forma hay que cambiar todos los parametros para inicializar una misma variable desde diferentes 
		Clases.*/ 
		//Opcion 1
		Barcelona bar = (Barcelona) appContext.getBean("barcelona");
		//Opcion 2 
		//PSG bar = (PSG) appContext.getBean("psg");
		System.out.println(bar.mostrar());
		
		System.out.println(". Con Interfaces:");
		/* Trabajando con Interfaces se conserva la creacion de la Variable, y solo se cambia la inicializacion. */
		IEquipo equipo = (IEquipo) appContext.getBean("psg");
		System.out.println(equipo.mostrar());
		
		equipo = (IEquipo) appContext.getBean("barcelona");
		System.out.println(equipo.mostrar());
		
		
		((ConfigurableApplicationContext)appContext).close();
	}

}
