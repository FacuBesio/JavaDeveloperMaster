package com.mitocode.mvc;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.mitocode.mvc.service.IUsuarioService;
import com.mitocode.mvc.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
class MvcApplicationTests {
	
	@Autowired
	private IUsuarioService usuarioService;
	

	@Test
	public void crearUsuarioTest() {
		Usuario user = new Usuario();
		user.setId(1);
		user.setNombre("User1");
		user.setClave("321");
		Usuario retorno = usuarioService.guardarUsuario(user);
		assertTrue(retorno.getClave().equalsIgnoreCase(user.getClave()));
	}
	
	@Test
	public void crearUsuarioTest2() {
		Usuario user = new Usuario();
		user.setId(2);
		user.setNombre("User2");
		user.setClave("321");
		Usuario retorno = usuarioService.guardarUsuario(user);
		assertTrue(retorno.getId() != 0);
	}

}
