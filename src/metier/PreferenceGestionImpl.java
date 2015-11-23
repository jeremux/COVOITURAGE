package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Preference;
import model.Ville;
import util.Conversion;

public class PreferenceGestionImpl implements IPreferenceGestion {

	@Override
	public void addPreference(Preference p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("select count(*) from Preference where aimeAnimaux=? and aimeMusique=? "
					+ "and aimeDiscution=? and fumeur=?");
			ps.setInt(1,Conversion.toSqliteBool(p.isAimeAnimaux()));
			ps.setInt(2, Conversion.toSqliteBool(p.isAimeMusique()));
			ps.setInt(3, Conversion.toSqliteBool(p.isAimeDiscution()));
			ps.setInt(4, Conversion.toSqliteBool(p.isFumeur()));
		
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			
			if(count==0)
			{
				ps = connection.prepareStatement("INSERT INTO Preference (aimeMusique,aimeAnimaux,fumeur,aimeDiscution) values (?,?,?,?);");
				
				ps.setInt(1, Conversion.toSqliteBool(p.isAimeMusique()));
				ps.setInt(2,Conversion.toSqliteBool(p.isAimeAnimaux()));
				ps.setInt(3, Conversion.toSqliteBool(p.isFumeur()));
				ps.setInt(4, Conversion.toSqliteBool(p.isAimeDiscution()));
				int nbModif = ps.executeUpdate();
				if (nbModif!=1)
				{
					System.err.println("Problème: modification de plus d'une ligne lors de l'ajout dans la table Preference");
				}
			}
		} 
		catch (SQLException e) {
				System.err.println("Erreur add table Preference");
				e.printStackTrace();
			}
	}

	

	@Override
	public void deletePreference(int id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("delete from Ville where idPreference=?");
			ps.setInt(1,id);
			
			int nbModif = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur delete table Preference");
			e.printStackTrace();
		}
		
	}

	public Preference getPreference(int idPref) {
		Preference p = new Preference();
		
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Preference where idPreference=?");
			ps.setInt(1, idPref);
			ResultSet rs = ps.executeQuery();
			
			int idp;
			while(rs.next())
			{
				idp = rs.getInt("idPreference");
				if(idp==idPref)
				{
					p.setId(idp);
					p.setAimeAnimaux(Conversion.sqliteToBool(rs.getInt("aimeAnimaux")));
					p.setAimeDiscution(Conversion.sqliteToBool(rs.getInt("aimeDiscution")));
					p.setAimeMusique(Conversion.sqliteToBool(rs.getInt("aimeMusique")));
					p.setFumeur(Conversion.sqliteToBool(rs.getInt("fumeur")));
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur getPreference table Preference");
			e.printStackTrace();
		}
		return p;
	}

	


}
