package com.eduit.clase1.entidades;

import com.eduit.clase1.interfaces.CreacionInformes;

public class Informes implements CreacionInformes {

	@Override
	public String getInformes() {
		return "Esto es un informe detallado demo de Inyeccion de Dependencias";
	}
	
	

}
