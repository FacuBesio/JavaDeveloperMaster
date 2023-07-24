package com.mitocode.beans;

import org.springframework.stereotype.Component;

import com.mitocode.interfaces.IEquipo;

@Component
public class PSG implements IEquipo { 		 

	@Override
	public String mostrar() {
		return "París Saint-Germain Football Club";
	}
}
