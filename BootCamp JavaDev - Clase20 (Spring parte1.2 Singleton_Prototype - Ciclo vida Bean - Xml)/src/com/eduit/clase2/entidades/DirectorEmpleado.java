package com.eduit.clase2.entidades;

import com.eduit.clase2.interfaces.CreacionInformes;
import com.eduit.clase2.interfaces.I_Empleados;

public class DirectorEmpleado implements I_Empleados {
	
	// Creacion del campo tipo CreacionInformes(interface), para la inyeccion de dependencia.
	private CreacionInformes informeNuevo;
	
	
	public DirectorEmpleado() {
		
	}
	
	// Creacion del Constructor que inyecta la Dependencia
	public DirectorEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}

	@Override
	public String getTareas() {
		return "Soy un Director";
	}
	
	@Override
	public String getInformes() {
		return "Informe creado por el Director: " + informeNuevo.getInformes();
	}
	
	
	// � M�todo Init 
	/* creamos el metodo init: ejecuta tareas antes de que el bean este disponible. Los m�todos no seran
	siempre void, pero en la mayor�a de los casos lo seran. */
	
	public void metodoInicial() {
// ACA VA EL CODIGO QUE QUEREMOS EJECUTAR ANTES DE QUE EL BEAN ESTE DISPONIBLE (por ejemplo una Conexion). 
		System.out.println("Ejecutando tareas antes de que el Bean este disponible.");
	}
	
	
	// � M�todo Destroy
	/* creamos el m�todo destroy para ejecutar tareas despues de que el Bean ya fue utilizado. */
	public void metodoFinal() {
		// aca va el codigo luedo de que el Bean sea 'destruido'. 
		System.out.println("Ejecutando tareas despu�s de utlizar el Bean, antes de destruir el Bean.");
	}
	
}