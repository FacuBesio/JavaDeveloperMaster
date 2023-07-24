package com.eduit.clase2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduit.clase2.entidades.DirectorEmpleado;
import com.eduit.clase2.entidades.SecretarioEmpleado;
import com.eduit.clase2.interfaces.I_Empleados;

public class DemoUsoSingleton_Prototype {
	
	public static void main(String[] args) {
		
		// Cargamos el xml de config
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		//.• SINGLETON:
		System.out.println(". SINGLETON:");
		
		// Petecion de Beans al Conteiner de Spring. Pedimos dos Beans del tipo Secretario Empleado.
		// Como por defecto Spring trabaja con Singleton, los dos Beans deberian apuntar a la misma 
		// direccion de Memoria
		
		SecretarioEmpleado maria = contexto.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
		SecretarioEmpleado pedro = contexto.getBean("miSecretarioEmpleado", SecretarioEmpleado.class);
		
		// comprobamos que ambos objetos apuntan a la misma posicion de Memoria (patrón Singleton)
		System.out.println(maria);
		System.out.println(pedro);
		
		if (maria.hashCode() == pedro.hashCode()) {
			System.out.println("apuntan al mismo objeto");
		}else {
			System.out.println("no son el mismo objeto");
		}
		
		// • PROTOTYPE
		System.out.println();
		System.out.println(". PROTOTYPE:");
		
		DirectorEmpleado maria_prototype = contexto.getBean("miDirectorEmpleado", DirectorEmpleado.class);
		DirectorEmpleado pedro_prototype = contexto.getBean("miDirectorEmpleado", DirectorEmpleado.class);
		
		// comprobamos que ambos objetos apuntan a la misma posicion de Memoria (patron Singleton)
		System.out.println(maria_prototype);
		System.out.println(pedro_prototype);
		
		if (maria_prototype == pedro_prototype) {
			System.out.println("apuntan al mismo objeto");
		}else {
			System.out.println("no son el mismo objeto");
		}
	
		/*	CICLO DE VIDA BEANS	*/
		// • METODO INIT:
		System.out.println();
		System.out.println(". CICLO DE VIDA:");
		
		// cargamos el xml de config
		ClassPathXmlApplicationContext contextoB = new ClassPathXmlApplicationContext("applicationContext3.xml");
		
		// solicito el beans a Spring
		I_Empleados director = contextoB.getBean("miDirectorEmpleado", DirectorEmpleado.class);
		
		// utilizo el beans a Spring
		System.out.println(director.getInformes());
		
		// cerramos el contexto y liberamos recursos
		contextoB.close();
		
	
	}

}
