package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Ville;

public class VilleGestionImpl implements IVilleGestion {

	@Override
	public Ville getVilleParID(int id) {
		
		Ville v = new Ville();
		
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Ville where idVille=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			int idv;
			while(rs.next())
			{
				idv = rs.getInt("idVille");
				if(idv==id)
				{
					v.setId(idv);
					v.setNom(rs.getString("nom"));
					v.setCodePostal(rs.getString("codePostal"));
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur getVille table Ville");
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public void addVille(Ville v) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Ville (nom,codePostal) values (?,?);");
			ps.setString(1,v.getNom());
			ps.setString(2, v.getCodePostal());
			
			int nbModif = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur prepareStatement table Ville");
			e.printStackTrace();
		}

	}
	
	public void deleteVille(String cp){
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("delete from Ville where codePostal=?");
			ps.setString(1,cp);
			
			int nbModif = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur prepareStatement table Ville");
			e.printStackTrace();
		}
	}

}
