package com.codigorupestre.spacetravels.basededatos;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionMariaDB {

	static String db = "cursojava";

	static String user = "root";

	static String password = "root";

	static String host = "localhost";

	static String port = "33306";

	static String url = "jdbc:mysql://" + host + ":" + port + "/" + db;

	Connection connection = null;

	public DBConnectionMariaDB() {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);

			if (connection == null) {
				System.out.println("Fallo la conexion a la base de datos");
			} else {
				System.out.println("Exitosa la conexion a la base de datos");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
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
