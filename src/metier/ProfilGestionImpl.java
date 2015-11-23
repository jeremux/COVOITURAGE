package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Conducteur;
import model.Profil;

public class ProfilGestionImpl implements IProfilGestion {

	@Override
	public void addProfil(Profil p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Profil (pseudo,pass,email,dateInscription,dateNaissance,"
					+ "nom,prenom,ville,preference) values (?,?,?,?,?,?,?,?,?);");
			ps.setString(1,p.getPseudo());
			ps.setString(2, p.getPass());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getDateInscription());
			ps.setString(5, p.getDateNaissance());
			ps.setString(6, p.getNom());
			ps.setString(7, p.getPrenom());
			ps.setInt(8, p.getVille().getId());
			ps.setInt(9, p.getPreference().getId());
			
			int nbModif = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur insert into table Profil");
			e.printStackTrace();
		}

	}

	@Override
	public void deleteProfil(Profil p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("delete from Profil where idProfil=?");
			ps.setInt(1,p.getId());
			
			int nbModif = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur delete from table Profil");
			e.printStackTrace();
		}

	}

	@Override
	public Profil getProfilFromPseudo(String pseudo) {
		Profil p = new Profil();
		VilleGestionImpl vg = new VilleGestionImpl();
		PreferenceGestionImpl pg =  new PreferenceGestionImpl();
		
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Profil where pseudo=?");
			ps.setString(1,pseudo);
			ResultSet rs = ps.executeQuery();
			
			String pseudoRecupere;
			while(rs.next())
			{
				pseudoRecupere = rs.getString("pseudo");
				if(pseudoRecupere.equals(pseudo))
				{
					p.setId(rs.getInt("idProfil"));
					p.setPseudo(pseudo);
					p.setPass(rs.getString("pass"));
					p.setDateInscription(rs.getString("dateInscription"));
					p.setDateNaissance(rs.getString("dateNaissance"));
					p.setNom(rs.getString("nom"));
					p.setPrenom(rs.getString("prenom"));
					
					int idVille = rs.getInt("ville");
					int idPref = rs.getInt("preference");
					
					p.setVille(vg.getVilleParID(idVille));
					p.setPreference(pg.getPreference(idPref));
				
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur getProfilFromPseudo table Profil");
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Profil getProfilFromEmail(String email) {
		Profil p = new Profil();
		VilleGestionImpl vg = new VilleGestionImpl();
		PreferenceGestionImpl pg =  new PreferenceGestionImpl();
		
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Profil where email=?");
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();
			
			String emailRecupere;
			while(rs.next())
			{
				emailRecupere = rs.getString("email");
				if(emailRecupere.equals(email))
				{
					p.setId(rs.getInt("idProfil"));
					p.setPseudo(email);
					p.setPass(rs.getString("pass"));
					p.setDateInscription(rs.getString("dateInscription"));
					p.setDateNaissance(rs.getString("dateNaissance"));
					p.setNom(rs.getString("nom"));
					p.setPrenom(rs.getString("prenom"));
					
					int idVille = rs.getInt("ville");
					int idPref = rs.getInt("preference");
					
					p.setVille(vg.getVilleParID(idVille));
					p.setPreference(pg.getPreference(idPref));
				
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur getProfilFromEmail table Profil");
			e.printStackTrace();
		}
		return p;
		
	}

	public void deleteProfilFromPseudo(String pseudo) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("delete from Profil where pseudo=?");
			ps.setString(1,pseudo);
			
			int nbModif = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur delete from table Profil");
			e.printStackTrace();
		}
		
	}

	public Conducteur getProfilFromID(int id) {
			Conducteur p = new Conducteur();
			VilleGestionImpl vg = new VilleGestionImpl();
			PreferenceGestionImpl pg =  new PreferenceGestionImpl();
			
			Connection connection = SingletonConnection.getConnection();
			try {
				PreparedStatement ps = connection.prepareStatement("select * from Profil where idProfil=?");
				ps.setInt(1,id);
				ResultSet rs = ps.executeQuery();
				
				int idRecupere;
				while(rs.next())
				{
					idRecupere = rs.getInt("idProfil");
					if(idRecupere==id)
					{
						p.setId(rs.getInt("idProfil"));
						p.setPseudo(rs.getString("pseudo"));
						p.setPass(rs.getString("pass"));
						p.setDateInscription(rs.getString("dateInscription"));
						p.setDateNaissance(rs.getString("dateNaissance"));
						p.setNom(rs.getString("nom"));
						p.setPrenom(rs.getString("prenom"));
						
						int idVille = rs.getInt("ville");
						int idPref = rs.getInt("preference");
						
						p.setVille(vg.getVilleParID(idVille));
						p.setPreference(pg.getPreference(idPref));
					
					}
				}
			} catch (SQLException e) {
				System.err.println("Erreur getProfilFromPseudo table Profil");
				e.printStackTrace();
			}
			return p;
	}
	
	

}
