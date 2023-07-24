package com.eduit.clase1.entidades;

import com.eduit.clase1.interfaces.CreacionInformes;
import com.eduit.clase1.interfaces.I_Empleados;

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
}