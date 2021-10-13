package com.codigorupestre.spacetravels.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.codigorupestre.spacetravels.clases.Usuario;
import com.codigorupestre.spacetravels.impl.UsuarioDAOImpl;


class UsuarioDAOTest {
	
	private UsuarioDAO usuarioDao;

	@Test
	void testSelect() {
		
		usuarioDao = new UsuarioDAOImpl();
		
		Usuario usuario = usuarioDao.consultarUsuario("test3", "test4");
		
		Assertions.assertEquals("test3", usuario.usuario);
		
	}

}
