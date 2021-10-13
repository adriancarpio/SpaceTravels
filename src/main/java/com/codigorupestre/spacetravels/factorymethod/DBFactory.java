package com.codigorupestre.spacetravels.factorymethod;

import java.util.Properties;

import com.codigorupestre.spacetravels.factorymethod.impl.MariaDBAdapter;
import com.codigorupestre.spacetravels.factorymethod.impl.OracleDBAdapter;
import com.codigorupestre.spacetravels.factorymethod.util.PropertiesUtil;

public class DBFactory {

	public static IDBAdapter getDBAdapter(DBType dtype) {

		switch (dtype) {
		case MariaDB:

			return new MariaDBAdapter();

		case Oracle:

			return new OracleDBAdapter();

		default:
			throw new  IllegalArgumentException("Base de datos no sorpotada");
		}
	}

	public static IDBAdapter getDefaulDBAdapter() {

		try {

			Properties prop = PropertiesUtil.loadProperties("DBFactory.properties");
			String defaultDBClass = prop.getProperty("DB");
			System.out.println("Defaul Class: " + defaultDBClass);

			return (IDBAdapter) Class.forName(defaultDBClass).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
