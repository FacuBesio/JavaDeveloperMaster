package com.eduit.clase2.entidades;

import com.eduit.clase2.interfaces.CreacionInformes;
import com.eduit.clase2.interfaces.I_Empleados;

public class SecretarioEmpleado implements I_Empleados {

	private CreacionInformes informeNuevo;	
	
	@Override
	public String getTareas() {
		return "Soy un Secretario";
	}

	@Override
	public String getInformes() {
		// TODO Auto-generated method stub
		return null;
	}

	
	// INYECCION DE DEPENDENCIAS MEDIANTES SETTERS
	// GENERAMOS UN SETTER PARA PODER USAR LA INYECCION DE DEPENDENCIAS MEDIANTE EL TAG "property"
	
	public void setInformeNuevo(CreacionInformes informeNuevo) {
		this.informeNuevo = informeNuevo;
	}
	
		
}
