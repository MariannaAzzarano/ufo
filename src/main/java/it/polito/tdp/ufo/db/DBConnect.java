package it.polito.tdp.ufo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	//QUESTA CLASSE CREA LA CONNESSIONE
	

	public static Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost/ufo_sightings?user=root&password=root";

		return DriverManager.getConnection(jdbcURL);
	}

}
