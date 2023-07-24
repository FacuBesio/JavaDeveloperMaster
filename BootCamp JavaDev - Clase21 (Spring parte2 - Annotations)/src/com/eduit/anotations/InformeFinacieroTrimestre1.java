package com.eduit.anotations;

import org.springframework.stereotype.Component;

import com.eduit.interfaces.CreacionInformesFinancieros;

// Esta Clase es la dependencia de la Clase ComercialExperimentado

@Component	// registramos la Clase en el Conteiner de Spring 
public class InformeFinacieroTrimestre1 implements CreacionInformesFinancieros {

	@Override
	public String getInformeFinanciero() {
		return "Informe financiero del primer trimestre del año a través de la inyección de dependencias "
				+ "con @Autowired";
	}
}
