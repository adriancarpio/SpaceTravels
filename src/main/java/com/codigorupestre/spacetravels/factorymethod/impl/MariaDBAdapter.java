package com.codigorupestre.spacetravels.factorymethod.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.codigorupestre.spacetravels.factorymethod.IDBAdapter;
import com.codigorupestre.spacetravels.factorymethod.util.PropertiesUtil;

public class MariaDBAdapter implements IDBAdapter {

	static {
		new org.mariadb.jdbc.Driver();
	}

	@Override
	public Connection getConnection() {

		try {
			String connectionsString = createConnectString();
			Connection connection = DriverManager.getConnection(connectionsString);
			System.out.println("conexion exitosa a " + connection.getClass().getName());
			return connection;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private String createConnectString() {
		Properties props = PropertiesUtil.loadProperties("MariaDB.properties");
		return props.getProperty("url");
	}

}
