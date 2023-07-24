package com.eduit.clase1.entidades;

import com.eduit.clase1.interfaces.CreacionInformes;

public class InformesTipo2 implements CreacionInformes {
	
	@Override
	public String getInformes() {
		return "Esto es un informe de tipo 2 por Inyeccion de Dependencias";
	}
	

}
