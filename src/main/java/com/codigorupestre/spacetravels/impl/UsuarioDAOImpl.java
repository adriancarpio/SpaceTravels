package com.codigorupestre.spacetravels.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codigorupestre.spacetravels.clases.Usuario;
import com.codigorupestre.spacetravels.dao.UsuarioDAO;
import com.codigorupestre.spacetravels.factorymethod.DBFactory;
import com.codigorupestre.spacetravels.factorymethod.IDBAdapter;

public class UsuarioDAOImpl implements UsuarioDAO {

	private IDBAdapter dbAdapter;

	public UsuarioDAOImpl() {

		dbAdapter = DBFactory.getDefaulDBAdapter();
	}

	@Override
	public boolean insertarUsuario(Usuario usuario) {

		String sql = "INSERT INTO cursojava.Usuario\n" + "(NOMBRE, APELLIDOS, USUARIO, PASSWORD, EMAIL, TELEFONO)\n"
				+ "VALUES( ?, ?, ?, ?, ?, ?)";

		Connection connection = dbAdapter.getConnection();

		try {

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, usuario.nombre);
			statement.setString(2, usuario.apellidos);
			statement.setString(3, usuario.usuario);
			statement.setString(4, usuario.contrasena);
			statement.setString(5, usuario.email);
			statement.setString(6, usuario.telefono);

			statement.executeUpdate();

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Usuario consultarUsuario(String user, String password) {
		
		Usuario usuario = new Usuario();
		String sqlLogin = "select * from Usuario WHERE  usuario = '"+ user +"' AND password = '"+ password +"' ";

		Connection connection = dbAdapter.getConnection();

		try {

			PreparedStatement stSelect = connection.prepareStatement(sqlLogin);

			ResultSet rs = stSelect.executeQuery(sqlLogin);
			
			//mientras sea true se seguira ejecutando 
			while (rs.next()) {
				usuario.nombre = rs.getString("nombre");
				usuario.apellidos = rs.getString("apellidos");
				usuario.usuario = rs.getString("usuario");
				usuario.contrasena = rs.getString("password");
				usuario.email = rs.getString("email");
				usuario.telefono = rs.getString("telefono");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return usuario;
	}

}
