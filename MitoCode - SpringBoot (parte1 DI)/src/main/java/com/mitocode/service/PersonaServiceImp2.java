package com.mitocode.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.mitocode.appMain.appMainApplication;
import com.mitocode.repository.IPersonaRepo;

@Service
@Qualifier("personaServiceImp2")
public class PersonaServiceImp2 implements IPersonaService {
	private static Logger LOG = LoggerFactory.getLogger(appMainApplication.class);
	
	@Autowired
	IPersonaRepo personaRepository;
	
	@Override
	public void registrar_service(String nombre) {
		LOG.info("Registrar desde PersonaServiceImp2");
		
	}

}