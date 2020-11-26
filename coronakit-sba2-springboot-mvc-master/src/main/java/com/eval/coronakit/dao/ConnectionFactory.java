package com.eval.coronakit.dao;


import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
	
	private static DataSource datasource;
	
	public static Connection getConnection() throws SQLException, NamingException {
		
		if(datasource==null) {
			InitialContext context =new InitialContext();
			datasource = (DataSource) context.lookup("java:/sayalidb");
		}
		
		return datasource.getConnection();
	}
	
}
