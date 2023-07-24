package com.mitocode.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mitocode.appMain.appMainApplication;

@Repository
public class PersonaRepoImp implements  IPersonaRepo {
	
	private static Logger LOG = LoggerFactory.getLogger(appMainApplication.class);
	
	@Override
	public void registrar(String nombre) {
		LOG.info("SE REGISTRO A " + nombre);
		
	}

}
