package com.eduit.clase2.entidades;

import com.eduit.clase2.interfaces.I_Empleados;

public class JefeEmpleado implements I_Empleados {

	@Override
	public String getTareas() {
		return "Soy un Jefe";
	}

	@Override
	public String getInformes() {
		// TODO Auto-generated method stub
		return null;
	}
}
