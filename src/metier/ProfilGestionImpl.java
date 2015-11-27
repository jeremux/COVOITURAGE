package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connexion.SingletonConnection;
import dao.DAO;
import model.Profil;


public class ProfilGestionImpl extends DAO<Profil> {

	public Profil findByPseudo(String pseudo) {
		Profil p = new Profil();
		VilleGestionImpl vg = new VilleGestionImpl();
		PreferenceGestionImpl pg =  new PreferenceGestionImpl();
		
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
					
					p.setVille(vg.find(idVille));
					p.setPreference(pg.find(idPref));
				
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur getProfilFromPseudo table Profil");
			e.printStackTrace();
		}
		return p;
	}


	public Profil findByEmail(String email) {
		Profil p = new Profil();
		VilleGestionImpl vg = new VilleGestionImpl();
		PreferenceGestionImpl pg =  new PreferenceGestionImpl();
		
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
					
					p.setVille(vg.find(idVille));
					p.setPreference(pg.find(idPref));
				
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur getProfilFromEmail table Profil");
			e.printStackTrace();
		}
		return p;
		
	}



	public Profil find(int id) {
			Profil p = new Profil();
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
						
						p.setVille(vg.find(idVille));
						p.setPreference(pg.find(idPref));
					
					}
				}
			} catch (SQLException e) {
				System.err.println("Erreur getProfilFromPseudo table Profil");
				e.printStackTrace();
			}
			return p;
	}

	

	@Override
	public Profil create(Profil p) {
		Profil tmp = findByEmail(p.getEmail());
		if(tmp.getId()==-1)
		{try {
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
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur insert into table Profil");
			e.printStackTrace();
		}
		
		/* on met à jour l'id generé */
		p.setId(findByPseudo(p.getPseudo()).getId());
		}
		else
		{
			p.setId(tmp.getId());
		}
		
		return p;
	}

	@Override
	public Profil update(Profil p) {
		Profil res= new Profil();
		try {
			PreparedStatement ps = this.connection.prepareStatement("update Profil set "
					+ "pseudo=?,"
					+ "pass= ?,"
					+ "email= ?,"
					+ "dateInscription= ?,"
					+ "dateNaissance=?,"
					+ "nom=?,"
					+ "prenom=?,"
					+ "ville=?,"
					+ "preference=?"
					+ "where idProfil=?");
	
			ps.setString(1,p.getPseudo());
			ps.setString(2, p.getPass());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getDateInscription());
			ps.setString(5, p.getDateNaissance());
			ps.setString(6, p.getNom());
			ps.setString(7, p.getPrenom());
			ps.setInt(8, p.getVille().getId());
			ps.setInt(9, p.getPreference().getId());
			ps.setInt(10, p.getId());
		
			
			ps.executeUpdate();
			
			res = this.find(p.getId());
			
		} catch (SQLException e) {
			System.err.println("Erreur insert into table Message");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public void delete(Profil p) {
		try {
			PreparedStatement ps = connection.prepareStatement("delete from Profil where idProfil=?");
			ps.setInt(1,p.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur delete from table Profil");
			e.printStackTrace();
		}
		
	}
	
	

}
