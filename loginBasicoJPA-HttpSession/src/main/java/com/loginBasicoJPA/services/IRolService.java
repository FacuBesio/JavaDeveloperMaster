package com.loginBasicoJPA.services;

import java.util.List;
import java.util.Optional;

import com.loginBasicoJPA.model.Role;

public interface IRolService {

	Role create(Role rol);
	Optional <Role> get(Integer id);
	void update(Role rol);
	void delete(Integer id);
	List<Role> findAll();
}
