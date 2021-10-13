package com.codigorupestre.spacetravels.dao;

import com.codigorupestre.spacetravels.clases.Usuario;

public interface UsuarioDAO {
	
	public boolean insertarUsuario(Usuario usuario);
	
	
	public  Usuario consultarUsuario(String user, String password);

}
