package it.polito.tdp.ufo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import javax.management.RuntimeErrorException;   //NON HA FATTO COSI' IL PROF

public class SightingDAO {
	
	//Questa è la classe dove ci sono i metodi di accesso al DB 
	
	//un metodo è quello che restituisce l'elenco delle shape
	

	
	public List <String> readShapes(){
		
		try {
			Connection conn = DBConnect.getConnection();
			String sql = ""
					+ "SELECT DISTINCT shape "
					+ "FROM sighting "
					+ "WHERE shape <>'' "
					+ "ORDER BY shape ASC";
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet res = st.executeQuery();
			
			List <String> formeUFO = new ArrayList<String>(); 
			
			while(res.next()) {
				String forma = res.getString("shape"); //il nome della string è lo stesso che ho chesto nella query
				formeUFO.add(forma);
			}
			st.close();
			conn.close();
			return formeUFO;
		
		} catch (SQLException e) {
			throw new RuntimeException("DB Error in readShapes", e);
		}
		
	 }
	
	public int countByShape(String shape) {
		
		
		try {
			Connection conn = DBConnect.getConnection();
		
			String sql2 = "SELECT COUNT(*) AS cnt "
					+ "FROM sighting "
					+ "WHERE shape = ?";
			
			 PreparedStatement st2 = conn.prepareStatement(sql2);
			 
			 st2.setString(1, shape);
			 
			 ResultSet res2 = st2.executeQuery();
			 res2.first();
			 int count = res2.getInt("cnt");
			 st2.close();
			
			//System.out.println("UFO di forma "+ shapeScelta + " sono: "+count);
			conn.close();   //RICORDA PRIMA DI RETURN
			return count;
			
			
		} catch (SQLException e) {
			throw new RuntimeException("DB Error in CountByShape", e);
		}
 
	
	}

}
