package com.codigorupestre.spacetravels.basededatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestOracleDBConnection {

	@Test
	public void testConnection() {
		DBConnectionOracleDB conn = new DBConnectionOracleDB();
		Connection connOracleDB = conn.getConnection();

		Assertions.assertNotNull(connOracleDB);
	}

	@Test
	public void testInsert() throws SQLException {

		DBConnectionOracleDB mariaDBConnection = new DBConnectionOracleDB();
		Connection connection = mariaDBConnection.getConnection();

		Statement stmt = connection.createStatement();

		String sqlInsert = "INSERT INTO GINION.USUARIO\n"
				+ "(NOMBRE, APELLIDOS, USUARIO, PASSWORD, EMAIL, TELEFONO)\n"
				+ "VALUES( 'test', 'test', 'test', 'test', 'test', 'test')";

		int valorRespuesta = stmt.executeUpdate(sqlInsert);
		Assertions.assertEquals(1, valorRespuesta);

	}

}
