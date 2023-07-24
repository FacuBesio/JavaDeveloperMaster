package com.eduit.clase1.entidades;

import com.eduit.clase1.interfaces.CreacionInformes;
import com.eduit.clase1.interfaces.I_Empleados;

public class JefeEmpleado implements I_Empleados {
	
	private CreacionInformes informeNuevo;
		
	public JefeEmpleado() {
	}

	public JefeEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}

	@Override
	public String getTareas() {
		return "Soy un Jefe";
	}

	@Override
	public String getInformes() {
		return "Informe creado por el Jefe: " + informeNuevo.getInformes();
	}
	
	public CreacionInformes getInformeNuevo() {
		return informeNuevo;
	}

	public void setInformeNuevo(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}

	
}
