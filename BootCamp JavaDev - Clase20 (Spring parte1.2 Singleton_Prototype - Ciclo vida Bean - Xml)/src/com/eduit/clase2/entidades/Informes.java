package com.eduit.clase2.entidades;

import com.eduit.clase2.interfaces.CreacionInformes;

public class Informes implements CreacionInformes {

	@Override
	public String getInformes() {
		return "Esto es un informe detallado demo de Inyeccion de Dependencias";
	}
	
	

}
