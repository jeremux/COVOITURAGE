package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Trajet;

public class TrajetGestionImpl implements ItrajetGestion {

	
	public void addTrajet(Trajet t) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Trajet (villeDepart,villeArrivee,date,heure,places,"
					+ "prix,idConducteur) values (?,?,?,?,?,?,?);");
			ps.setInt(1,t.getDepart().getId());
			ps.setInt(2,t.getDestination().getId());
			ps.setString(3,t.getDate());
			ps.setString(4,t.getHeure());
			ps.setInt(5,t.getPlaces());
			ps.setDouble(6, t.getPrix());
			ps.setInt(7,t.getConducteur().getId());
			
			int nbModif = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur insert into table Trajet");
			e.printStackTrace();
		}

	}


	public void deleteTrajet(int id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("delete from Trajet where idTrajet=?");
			ps.setInt(1,id);
			
			int nbModif = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur delete from table Trajet");
			e.printStackTrace();
		}

	}

	
	public Trajet getTrajet(int id) {
		Trajet t = new Trajet();
		VilleGestionImpl vg = new VilleGestionImpl();
		ProfilGestionImpl pg = new ProfilGestionImpl();
		
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Trajet where idTrajet=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			int idRecupere;
			while(rs.next())
			{
				idRecupere = rs.getInt("idTrajet");
				if(idRecupere==id)
				{
					t.setId(rs.getInt("idProfil"));
					t.setDepart(vg.getVilleParID(rs.getInt("villeDepart")));
					t.setDestination(vg.getVilleParID(rs.getInt("villeArrivee")));
					t.setDate(rs.getString("date"));
					t.setHeure(rs.getString("heure"));
					t.setPlaces(rs.getInt("places"));
					t.setPrix(rs.getDouble("prix"));
					t.setConducteur(pg.getProfilFromID(rs.getInt("idConducteur")));
				
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur getProfilFromPseudo table Trajet");
			e.printStackTrace();
		}
		return t;

	}

	public void toto() {
		// TODO Auto-generated method stub
		
	}

}
