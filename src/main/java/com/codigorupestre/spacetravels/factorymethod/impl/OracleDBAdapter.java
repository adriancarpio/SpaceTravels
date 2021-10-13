package com.codigorupestre.spacetravels.factorymethod.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.codigorupestre.spacetravels.factorymethod.IDBAdapter;
import com.codigorupestre.spacetravels.factorymethod.util.PropertiesUtil;

import oracle.jdbc.driver.OracleDriver;

public class OracleDBAdapter implements IDBAdapter {

	static {
		new OracleDriver();
	}

	@Override
	public Connection getConnection() {

		try {
			String connectionString = createConnectString();
			Connection connection = DriverManager.getConnection(connectionString);
			System.out.println("conexion exitosa a " + connection.getClass().getName());
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private String createConnectString() {
		Properties props = PropertiesUtil.loadProperties("OracleDB.properties");
		return props.getProperty("url");
	}

}
