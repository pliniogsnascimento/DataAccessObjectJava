package com.teste.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/pessoa";
		String driver = "com.mysql.jdbc.Driver";
		String user = "plinio";
		String senha = "";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, senha);
		
		return con;
	}
}
