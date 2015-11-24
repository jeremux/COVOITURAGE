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
		Ville tmp = getVille(v.getCodePostal());
		/* si id = -1 => inexistant => on insert */ 
		if(tmp.getId()==-1)
			
		{try {
			
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Ville (nom,codePostal) values (?,?);");
			ps.setString(1,v.getNom());
			ps.setString(2, v.getCodePostal());
			
			int nbModif = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur prepareStatement table Ville");
			e.printStackTrace();
		}
		
		/* On met à jour l'id */
		v.setId(getVille(v).getId());
		}
		else
		{
			/* on met a jour l'id par rapport à l'existant */
			v.setId(tmp.getId());
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

	@Override
	public Ville getVille(Ville v) {
		Ville res = new Ville();
		
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Ville where nom=? and codePostal=?;");
			ps.setString(1, v.getNom());
			ps.setString(2, v.getCodePostal());
			ResultSet rs = ps.executeQuery();
			
			String cpRecupere;
			String nomRecupere;
			while(rs.next())
			{
				cpRecupere=rs.getString("codePostal");
				nomRecupere=rs.getString("nom");
				if(cpRecupere.equals(v.getCodePostal())&&nomRecupere.equals(v.getNom()))
				{
					res.setId(rs.getInt("idVille"));
					res.setNom(rs.getString("nom"));
					res.setCodePostal(rs.getString("codePostal"));
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur getVille table Ville");
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public Ville getVille(String cp) {
		Ville v = new Ville();
		
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Ville where codePostal=?");
			ps.setString(1, cp);
			ResultSet rs = ps.executeQuery();
			
			String cpRecupere="";
			while(rs.next())
			{
				cpRecupere = rs.getString("codePostal");
				if(cp.equals(cpRecupere))
				{
					v.setId(rs.getInt("idVille"));
					v.setNom(rs.getString("nom"));
					v.setCodePostal(cp);
					System.out.println(rs.getInt("idVille")+" = "+rs.getString("nom"));
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur getVille table Ville");
			e.printStackTrace();
		}
		return v;
	}

	
}


