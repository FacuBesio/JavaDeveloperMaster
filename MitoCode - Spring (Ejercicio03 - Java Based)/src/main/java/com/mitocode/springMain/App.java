package com.mitocode.springMain;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.beans.Barcelona;
import com.mitocode.beans.Jugador;
import com.mitocode.beans.PSG;
import com.mitocode.interfaces.IEquipo;
import com.mitocode.spring.AppConfig;


public class App {

	public static void main(String[] args) {
		
		
		
// Para los archivos xml se utiliza
//ApplicationContext appContext = new ClassPathXmlApplicationContext("com/mitocode/xml/applicationContext.xml");
		
// Para los archivos AppConfig (con Annotations) se utiliza
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Jugador jugador = (Jugador) appContext.getBean("jugador");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Elija un equipo: 1. Barcelona - 2. PSG ");
		int respuesta = sc.nextInt();
		
		switch(respuesta) {
			case 1:
				jugador.setEquipo(new Barcelona());
				break;
			case 2:
				jugador.setEquipo(new PSG());
				break;
			default: 
				System.out.println("Por favor seleccion 1 o 2. Vuelva a intentarlo.");
				break;
		}
		
		if (respuesta ==1 || respuesta==2){
			System.out.println(jugador.getNombre() + " - " + jugador.getEquipo().mostrar() + ", " 
			+ jugador.getCamiseta().getNumero() + " | " + jugador.getCamiseta().getMarca().getNombre() );
		}
		
		((ConfigurableApplicationContext)appContext).close();
	}

}
