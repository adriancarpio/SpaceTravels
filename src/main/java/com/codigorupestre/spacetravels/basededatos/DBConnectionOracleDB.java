package com.codigorupestre.spacetravels.basededatos;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionOracleDB {

	static String dataBaseServiceName = "ORCLCDB.localdomain";

	static String user = "ginion";

	static String password = "ginion";

	static String port = "1521";

	static String url = "jdbc:oracle:thin:" + user + "/" + password + "@//localhost:" + port + "/"
			+ dataBaseServiceName;

	Connection connection = null;

	public DBConnectionOracleDB() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url);

			if (connection == null) {
				System.out.println("Conexion a Oracle Fallo");
			} else {
				System.out.println("Conexion a Oracle exitosa");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Connection getConnection() {
		return connection;
	}

	public void desconectar() {
		connection = null;
	}

}
