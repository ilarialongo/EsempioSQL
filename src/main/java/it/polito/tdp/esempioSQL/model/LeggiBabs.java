package it.polito.tdp.esempioSQL.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeggiBabs {
	
	public void run() {
		//1. Stringa di connessione
		
		String jdbcURL="jdbc:mysql://localhost/babs?user=root&password=Cuscinoila";
		
		//FACTORY: creazione di una classe, senza 
		//sapere il tipo della classe(NON posso usare new)
		//Uso quindi un metodo fornito da un'altra classe
		//che internamente farà new e coniscerà il tipo di classe effettivo
		try {
			Connection conn=DriverManager.getConnection(jdbcURL);
			String sql= "SELECT name FROM station WHERE landmark= ? ";
			PreparedStatement st= conn.prepareStatement(sql);
			st.setString(1, "Palo Alto");
			ResultSet res= st.executeQuery();
			
			while(res.next()) {
				String nomeStazione= res.getString("name");
				System.out.println(nomeStazione);
			}
			st.close();			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main (String args[]) {
		LeggiBabs babs= new LeggiBabs();
		babs.run();
	}

}
