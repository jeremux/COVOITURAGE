package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connexion.SingletonConnection;
import dao.DAO;
import model.Trajet;
import model.Ville;

public class VilleGestionImpl extends DAO<Ville> {

	public Ville findVille(Ville v) {
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


	public Ville findByCP(String cp) {
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

	@Override
	public Ville find(int id) {
		Ville v = new Ville();
		
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
	public Ville create(Ville v) {
		Ville tmp = findByCP(v.getCodePostal());
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
		v.setId(findVille(v).getId());
		}
		else
		{
			/* on met a jour l'id par rapport à l'existant */
			v.setId(tmp.getId());
		}
		
		return v;
	}

	@Override
	public Ville update(Ville v) {
		Ville res= new Ville();
		try {
			PreparedStatement ps = this.connection.prepareStatement("update Ville set "
					+ "nom=?,"
					+ "codePostal= ?,"
					+ "where idVille=?");
	
			ps.setString(1, v.getNom());
			ps.setString(2, v.getCodePostal());
			ps.setInt(3, v.getId());
		
			
			int nbModif = ps.executeUpdate();
			
			res = this.find(v.getId());
			
		} catch (SQLException e) {
			System.err.println("Erreur insert into Trajet");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public void delete(Ville v) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("delete from Ville where codePostal=?");
			ps.setString(1,v.getCodePostal());
			
			int nbModif = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur prepareStatement table Ville");
			e.printStackTrace();
		}
		
	}

	
}


