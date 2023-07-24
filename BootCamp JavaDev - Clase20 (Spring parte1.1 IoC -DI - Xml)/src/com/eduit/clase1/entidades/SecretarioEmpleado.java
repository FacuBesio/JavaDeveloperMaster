package com.eduit.clase1.entidades;

import com.eduit.clase1.interfaces.CreacionInformes;
import com.eduit.clase1.interfaces.I_Empleados;

public class SecretarioEmpleado implements I_Empleados {
	
	private CreacionInformes informeNuevo;
	
	
	public SecretarioEmpleado() {
	}

	public SecretarioEmpleado(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}
	
	@Override
	public String getTareas() {
		return "Soy un Secretario";
	}

	@Override
	public String getInformes() {
		return "Informe creado por el Secretario: " + informeNuevo.getInformes();
	}
	

	public CreacionInformes getInformeNuevo() {
		return informeNuevo;
	}

	public void setInformeNuevo(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}
	
	

	
		
}
