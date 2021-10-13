package com.codigorupestre.spacetravels.clases;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.codigorupestre.spacetravels.basededatos.DBConnectionMariaDB;
import com.codigorupestre.spacetravels.basededatos.DBConnectionOracleDB;
import com.codigorupestre.spacetravels.mail.MailSpaceTravels;

public class Usuario {

	// Bloques Static se ejecuta una sola vez

	static {
		System.out.println("Ejecutando un bloque Static");
	}

	// Bloques Anonymos

	{
		System.out.println("Ejecutando Bloque Anonymo");
	}

	// Constructor

	public Usuario() {
		System.out.println("Creando un Nuevo Usuario");
	}

	// contructor sobrecargado
	public Usuario(int id, String nombre, String apellidos, String usuario, String contrasena, String email,
			String telefono, boolean activo) {
		super();
		System.out.println("creando nuevo objeto en constructor sobrecragado");
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.email = email;
		this.telefono = telefono;
		this.activo = activo;
	}

	// Atributos

	public int id;
	public String nombre;
	public String apellidos;
	public String usuario;
	public String contrasena;
	public String email;
	public String telefono;
	public boolean activo;

	// Metodos

	public void crearUsuarioMariaDB() {

		int valorRespuesta = 0;

		DBConnectionMariaDB mariaDBConnection = new DBConnectionMariaDB();
		Connection connection2 = mariaDBConnection.getConnection();

		Statement stmt;
		try {
			stmt = connection2.createStatement();

			String sqlInsert = "INSERT INTO cursojava.Usuario\n"
					+ "(nombre, apellidos, usuario, password, email, telefono)\n" + "VALUES('" + nombre + "', '"
					+ apellidos + "', '" + usuario + "', '" + contrasena + "', '" + email + "', '"
					+ telefono + "')";

			valorRespuesta = stmt.executeUpdate(sqlInsert);

			System.out.println("Valor Respuesta = " + valorRespuesta);

			if (valorRespuesta == 0) {
				System.out.println("error al registrar");
			} else {
				System.out.println("Exito al registrar");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void crearUsuarioOracleDB() {

		DBConnectionOracleDB oracleDBConnection = new DBConnectionOracleDB();
		Connection connection = oracleDBConnection.getConnection();

		Statement stmt;
		try {
			stmt = connection.createStatement();

			String sqlInsert = "INSERT INTO GINION.USUARIO\n"
					+ "(NOMBRE, APELLIDOS, USUARIO, PASSWORD, EMAIL, TELEFONO)\n" + "VALUES( '" + this.nombre + "', '"
					+ this.apellidos + "', '" + this.usuario + "', '" + this.contrasena + "', '" + this.email + "', '"
					+ this.telefono + "')";

			int valorRespuesta = stmt.executeUpdate(sqlInsert);
		
			System.out.println("Valor Respuesta = " + valorRespuesta);
			
			MailSpaceTravels mail = new MailSpaceTravels();
			mail.sendMail(email);

			if (valorRespuesta == 0) {
				System.out.println("error al registrar");
			} else {
				System.out.println("Exito al registrar");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Usuario buscarUsuario(String usuario) {
		return null;
	}

	public Usuario actualizarUsuario(String usuario, Usuario usuarioActualizar) {
		return null;
	}

	public boolean eliminarUsuario(String usuario) {
		return false;
	}

	public boolean loginUsuario(String usuario, String contrasena) {
		return false;
	}

	public boolean recuperarContrasena(String correo) {
		return false;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", usuario=" + usuario
				+ ", contrasena=" + contrasena + ", email=" + email + ", telefono=" + telefono + ", activo=" + activo
				+ "]";
	}

}
