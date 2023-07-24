package com.eduit.clase1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eduit.clase1.entidades.DirectorEmpleado;
import com.eduit.clase1.entidades.JefeEmpleado;
import com.eduit.clase1.entidades.SecretarioEmpleado;
import com.eduit.clase1.interfaces.I_Empleados;

public class DemoUsoEmpleado {
	
	public static void main(String[] args) {
	
		// creamos Objetos del tipo Empleado
		I_Empleados e1 = new JefeEmpleado ();
		
		
		// me creo una referencia a la abstraccion
		I_Empleados e2 = new SecretarioEmpleado();
		I_Empleados e3 = new DirectorEmpleado();
		
	/*	El problema que se plantea aqui es que si quiero crear un objeto de un 
		tipo diferente me veo obligado a modificar el codigo y definir una nueva
		Clase. Por ejemplo si quiero dejar de utilzar una clase deberia eliminarla.
	*/
		
		// uso de los objetos creados
		System.out.println("empleado1: " + e1.getTareas());
		System.out.println("empleado2: " + e2.getTareas());
		System.out.println("empleado3: " + e3.getTareas());
		
		
		
		//AHORA VAMOS A HACER LO MISMO PERO CON EL CONTENEDOR DE SPRING
		System.out.println();
		System.out.println("************** SPRING ************** ");

		// • PASO 1: CARGAR EL XML 
		// Primero creamos un contexto y le ponemos el nombre del archivo con la extension '.xml'
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// • PASO 2: PEDIR EL BEANS AL ARCHIVO XML
		// Se solicita el beans al archivo xml mediante un alias o id y el nombre de la Interface.
		
		I_Empleados objetoBeanSpring = contexto.getBean("miEmpleado",I_Empleados.class);
		
		// • PASO 3: UTLIZAMOS EL OBJETO
		System.out.println("Se utilizo el bean: " + objetoBeanSpring.getClass() + " - " + objetoBeanSpring.getTareas());
		
		
		// • PASO 4: CERRAMOS EL CONTEXTO
		// Se cierra el contexto y se le liberan recursos. 
		contexto.close();
		
		/*De esta forma modificando únicamente el XML puedo cambiar desde donde se instancia el Objeto en toda la aplicacion, 
		 sin tocar el cógido.*/
		
		// • INYECCION DE DEPENDENCIAS
		System.out.println("Inyeccion de Dependencias: " + objetoBeanSpring.getInformes());
		
		
	}
}
