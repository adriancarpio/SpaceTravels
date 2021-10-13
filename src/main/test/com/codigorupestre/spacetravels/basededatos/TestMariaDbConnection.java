package com.codigorupestre.spacetravels.basededatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMariaDbConnection {
	
	@Test
	public void testConnection() {
		DBConnectionMariaDB conn = new DBConnectionMariaDB();
		Connection connMariaDB = conn.getConnection();
		
		Assertions.assertNotNull(connMariaDB);
	}
	
	@Test
	public void testInsert() throws SQLException {

		DBConnectionMariaDB mariaDBConnection = new DBConnectionMariaDB();
		Connection connection2 = mariaDBConnection.getConnection();

		Statement stmt = connection2.createStatement();

		String sqlInsert = "INSERT INTO cursojava.Usuario\n"
				+ "(nombre, apellidos, usuario, password, email, telefono)\n"
				+ "VALUES('adrian', 'carpio', 'manu', 'test4', 'adrian@gmail.com', '0987654321')";

		int valorRespuesta = stmt.executeUpdate(sqlInsert);
		Assertions.assertEquals(1, valorRespuesta);

	}

}
