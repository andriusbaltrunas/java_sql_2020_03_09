package com.kcs.springboot.example.jdbc;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Andrius Baltrunas
 */
@Repository
public class JDBCConnector
{
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/kcs";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "";

	public Connection createConnection()
	{
		try
		{
			return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

}
