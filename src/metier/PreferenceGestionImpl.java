package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connexion.SingletonConnection;
import dao.DAO;
import model.Preference;
import util.Conversion;

public class PreferenceGestionImpl extends DAO<Preference> {

	public Preference find(int idPref) {
		Preference p = new Preference();
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



	public Preference getPreference(Preference p) {
		Preference res = new Preference();
		
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Preference where aimeMusique=? and aimeAnimaux=? and fumeur=? and "
					+ "aimeDiscution=?;");
			ps.setInt(1, Conversion.toSqliteBool(p.isAimeMusique()));
			ps.setInt(2, Conversion.toSqliteBool(p.isAimeAnimaux()));
			ps.setInt(3, Conversion.toSqliteBool(p.isFumeur()));
			ps.setInt(4, Conversion.toSqliteBool(p.isAimeDiscution()));
			ResultSet rs = ps.executeQuery();
			
			int idp;
			while(rs.next())
			{
					idp = rs.getInt("idPreference");
					res.setId(idp);
					res.setAimeAnimaux(Conversion.sqliteToBool(rs.getInt("aimeAnimaux")));
					res.setAimeDiscution(Conversion.sqliteToBool(rs.getInt("aimeDiscution")));
					res.setAimeMusique(Conversion.sqliteToBool(rs.getInt("aimeMusique")));
					res.setFumeur(Conversion.sqliteToBool(rs.getInt("fumeur")));
				
			}
		} catch (SQLException e) {
			System.err.println("Erreur getPreference table Preference");
			e.printStackTrace();
		}
		return res;
	}







	@Override
	public Preference create(Preference p) {
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
				/* on met à jour l'id generé */
				p.setId(getPreference(p).getId());
			}
			else
			{
				p.setId(getPreference(p).getId());
			}
		} 
		catch (SQLException e) {
				System.err.println("Erreur add table Preference");
				e.printStackTrace();
			}
		
		return p;
	}



	@Override
	public Preference update(Preference p) {
		Preference res= new Preference();
		try {
			PreparedStatement ps = this.connection.prepareStatement("update Preference set "
					+ "aimeMusique=?,"
					+ "aimeAnimaux= ?,"
					+ "fumeur= ?,"
					+ "aimeDiscution= ?,"
					+ "where idPreference=?;");
	
			
			ps.setInt(1, Conversion.toSqliteBool(p.isAimeMusique()));
			ps.setInt(2, Conversion.toSqliteBool(p.isAimeAnimaux()));
			ps.setInt(3, Conversion.toSqliteBool(p.isFumeur()));
			ps.setInt(4, Conversion.toSqliteBool(p.isAimeDiscution()));
			ps.setInt(5, p.getId());
			
			ps.executeUpdate();
			
			res = this.find(p.getId());
			
		} catch (SQLException e) {
			System.err.println("Erreur insert into table Message");
			e.printStackTrace();
		}
		
		return res;
	}



	@Override
	public void delete(Preference p) {
		try {
			PreparedStatement ps = connection.prepareStatement("delete from Ville where idPreference=?");
			ps.setInt(1,p.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur delete table Preference");
			e.printStackTrace();
		}
		
	}

	


}
