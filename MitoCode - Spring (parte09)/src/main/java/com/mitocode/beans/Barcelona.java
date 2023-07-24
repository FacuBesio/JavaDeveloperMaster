package com.mitocode.beans;

import com.mitocode.interfaces.IEquipo;

public class Barcelona implements IEquipo { 		 
	
	@Override
	public String mostrar() {
		return "Barcelona FC";
	}
}
