package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import metier.SingletonConnection;

public class Clean {
	
	private static List<String> lesTables=
			Arrays.asList("Preference","Ville","Trajet","Message","Profil","Voyageurs","Paiement");

	public static void deleteAll()
	{
		Connection connection = SingletonConnection.getConnection();
		for(String table: lesTables)
		{
			try {
				PreparedStatement ps = connection.prepareStatement("delete from "+table);
				int nbModif = ps.executeUpdate();
				
			} catch (SQLException e) {
				System.err.println("Erreur insert into table "+table);
				e.printStackTrace();
			}
			
		}
	}
}