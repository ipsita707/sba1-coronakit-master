package com.eval.coronakit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Component;


@Component
public class ProductMasterDao {

	/*
	 * private static String jdbcURL; private static String jdbcUsername; private
	 * static String jdbcPassword;
	 */
	private static String jdbcURL = "jdbc:mysql://localhost/sayalidb";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "root";
	private static Connection jdbcConnection;

	
	public ProductMasterDao() {
		// TODO Auto-generated constructor stub
	}
	public ProductMasterDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

	protected static Connection connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			System.out.println("DB Connection Success");
		}
		return jdbcConnection;
	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	public static Connection getConnection() {
		try {
			return connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jdbcConnection;
	}
	// add DAO methods as per requirements
}