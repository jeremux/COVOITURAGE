package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import connexion.SingletonConnection;
import dao.DAO;
import model.Conducteur;
import model.Trajet;
import model.Ville;
import util.RecupereID;

public class TrajetGestionImpl extends DAO<Trajet> {


	public Trajet find(int id) {
		Trajet t = new Trajet();
		VilleGestionImpl vg = new VilleGestionImpl();
		ProfilGestionImpl pg = new ProfilGestionImpl();
		Conducteur c = new Conducteur();
		
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
					t.setId(rs.getInt("idTrajet"));
					t.setDepart(vg.find(rs.getInt("villeDepart")));
					t.setDestination(vg.find(rs.getInt("villeArrivee")));
					t.setDate(rs.getString("date"));
					t.setHeure(rs.getString("heure"));
					t.setPlaces(rs.getInt("places"));
					t.setPrix(rs.getDouble("prix"));
					c = new Conducteur(pg.find(rs.getInt("idConducteur")));
					t.setConducteur(c);
				
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur getProfilFromPseudo table Trajet");
			e.printStackTrace();
		}
		return t;
	}


	@Override
	public Trajet create(Trajet t) {
		Set<Integer> listIdAvant = RecupereID.getListID("idTrajet", "Trajet");
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
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur insert into table Trajet");
			e.printStackTrace();
		}
		
		/* On met à jour l'id */
		t.setId(RecupereID.getNewId("idTrajet", "Trajet", listIdAvant));
		
		return t;
	}


	@Override
	public Trajet update(Trajet t) {
		Trajet res= new Trajet();
		try {
			PreparedStatement ps = this.connection.prepareStatement("update Trajet set "
					+ "villeDepart=?,"
					+ "villeArrivee= ?,"
					+ "date= ?,"
					+ "heure= ?,"
					+ "places=?,"
					+ "prix=?,"
					+ "idConducteur=?,"
					+ "where idTrajet=?");
	
			ps.setInt(1,t.getDepart().getId());
			ps.setInt(2,t.getDestination().getId());
			ps.setString(3,t.getDate());
			ps.setString(4,t.getHeure());
			ps.setInt(5,t.getPlaces());
			ps.setDouble(6, t.getPrix());
			ps.setInt(7,t.getConducteur().getId());
			ps.setInt(8, t.getId());
		
			
			ps.executeUpdate();
			
			res = this.find(t.getId());
			
		} catch (SQLException e) {
			System.err.println("Erreur insert into Trajet");
			e.printStackTrace();
		}
		
		return res;
	}


	@Override
	public void delete(Trajet t) {
		try {
			PreparedStatement ps = connection.prepareStatement("delete from Trajet where idTrajet=?");
			ps.setInt(1,t.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur delete from table Trajet");
			e.printStackTrace();
		}
		
	}


	public List<Trajet> find(Ville depart, Ville arrivee) {
		List<Trajet> res =  new ArrayList<Trajet>();
		
		Trajet t = new Trajet();
		VilleGestionImpl vg = new VilleGestionImpl();
		ProfilGestionImpl pg = new ProfilGestionImpl();
		Conducteur c;
		
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Trajet where villeDepart=? and villeArrivee=?;");
			ps.setInt(1,depart.getId());
			ps.setInt(2, arrivee.getId());
			ResultSet rs = ps.executeQuery();
	
			while(rs.next())
			{		
				t.setId(rs.getInt("idTrajet"));
				t.setDepart(vg.find(rs.getInt("villeDepart")));
				t.setDestination(vg.find(rs.getInt("villeArrivee")));
				t.setDate(rs.getString("date"));
				t.setHeure(rs.getString("heure"));
				t.setPlaces(rs.getInt("places"));
				t.setPrix(rs.getDouble("prix"));
				c = new Conducteur(pg.find(rs.getInt("idConducteur")));
				t.setConducteur(c);
				
				res.add(t);
			}
			
		} catch (SQLException e) {
			System.err.println("Erreur select table Trajet");
			e.printStackTrace();
		}
		
		return res;
	}


	public List<Trajet> find(Ville depart, Ville arrivee, String date) {
		List<Trajet> res =  new ArrayList<Trajet>();
		
		
		
		Trajet t = new Trajet();
		VilleGestionImpl vg = new VilleGestionImpl();
		ProfilGestionImpl pg = new ProfilGestionImpl();
		Conducteur c;
		
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Trajet where villeDepart=? and villeArrivee=? and date=?;");
			ps.setInt(1,depart.getId());
			ps.setInt(2, arrivee.getId());
			ps.setString(3, date);
			ResultSet rs = ps.executeQuery();
	
			while(rs.next())
			{		
				t.setId(rs.getInt("idTrajet"));
				t.setDepart(vg.find(rs.getInt("villeDepart")));
				t.setDestination(vg.find(rs.getInt("villeArrivee")));
				t.setDate(rs.getString("date"));
				t.setHeure(rs.getString("heure"));
				t.setPlaces(rs.getInt("places"));
				t.setPrix(rs.getDouble("prix"));
				c = new Conducteur(pg.find(rs.getInt("idConducteur")));
				t.setConducteur(c);
				
				res.add(t);
			}
			
		} catch (SQLException e) {
			System.err.println("Erreur select table Trajet");
			e.printStackTrace();
		}

		return res;
	}


	public List<Trajet> findAll() {
		List<Trajet> res =  new ArrayList<Trajet>();
		
		Trajet t = new Trajet();
		VilleGestionImpl vg = new VilleGestionImpl();
		ProfilGestionImpl pg = new ProfilGestionImpl();
		Conducteur c;
		
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Trajet;");
			ResultSet rs = ps.executeQuery();
	
			while(rs.next())
			{	
				t = new Trajet();
				t.setId(rs.getInt("idTrajet"));
				t.setDepart(vg.find(rs.getInt("villeDepart")));
				t.setDestination(vg.find(rs.getInt("villeArrivee")));
				t.setDate(rs.getString("date"));
				t.setHeure(rs.getString("heure"));
				t.setPlaces(rs.getInt("places"));
				t.setPrix(rs.getDouble("prix"));
				c = new Conducteur(pg.find(rs.getInt("idConducteur")));
				t.setConducteur(c);
				
				
				res.add(t);
			}
			
		} catch (SQLException e) {
			System.err.println("Erreur select table Trajet");
			e.printStackTrace();
		}
		
		return res;
	}


	public List<Trajet> find(Ville arrivee) {
		
		List<Trajet> res =  new ArrayList<Trajet>();
		
		//Trajet t = new Trajet();
		VilleGestionImpl vg = new VilleGestionImpl();
		ProfilGestionImpl pg = new ProfilGestionImpl();
		Conducteur c;
		
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Trajet where villeArrivee=?;");
			ps.setInt(1,vg.findVille(arrivee).getId());
			ResultSet rs = ps.executeQuery();
	
			while(rs.next())
			{	
				Trajet t = new Trajet();
				t.setId(rs.getInt("idTrajet"));
				t.setDepart(vg.find(rs.getInt("villeDepart")));
				t.setDestination(vg.find(rs.getInt("villeArrivee")));
				t.setDate(rs.getString("date"));
				t.setHeure(rs.getString("heure"));
				t.setPlaces(rs.getInt("places"));
				t.setPrix(rs.getDouble("prix"));
				c = new Conducteur(pg.find(rs.getInt("idConducteur")));
				t.setConducteur(c);
				
				System.out.println("idTrajet = "+t.getId());
				System.out.println("villeArrivee = "+t.getDestination().getNom());
				res.add(t);

			}
			
		} catch (SQLException e) {
			System.err.println("Erreur select table Trajet");
			e.printStackTrace();
		}
		
		System.out.println("Boucle");
		for(Trajet t1: res)
		{
			t1.toString();
		}
		return res;
	}


	public List<Trajet> find(Ville arrivee, String date) {
List<Trajet> res =  new ArrayList<Trajet>();
		
		Trajet t = new Trajet();
		VilleGestionImpl vg = new VilleGestionImpl();
		ProfilGestionImpl pg = new ProfilGestionImpl();
		Conducteur c;
		
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Trajet where villeArrivee=? and date=?;");
			ps.setInt(1,vg.findVille(arrivee).getId());
			ps.setString(2, date);
			ResultSet rs = ps.executeQuery();
	
			while(rs.next())
			{	
				t = new Trajet();
				t.setId(rs.getInt("idTrajet"));
				t.setDepart(vg.find(rs.getInt("villeDepart")));
				t.setDestination(vg.find(rs.getInt("villeArrivee")));
				t.setDate(rs.getString("date"));
				t.setHeure(rs.getString("heure"));
				t.setPlaces(rs.getInt("places"));
				t.setPrix(rs.getDouble("prix"));
				c = new Conducteur(pg.find(rs.getInt("idConducteur")));
				t.setConducteur(c);
				
				
				res.add(t);
			}
			
		} catch (SQLException e) {
			System.err.println("Erreur select table Trajet");
			e.printStackTrace();
		}
		
		return res;
	}


	public List<Trajet> find(Conducteur conducteur) {
		List<Trajet> res =  new ArrayList<Trajet>();
		
		Trajet t = new Trajet();
		VilleGestionImpl vg = new VilleGestionImpl();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Trajet where idConducteur=?;");
			ps.setInt(1,conducteur.getId());
			ResultSet rs = ps.executeQuery();
	
			while(rs.next())
			{	
				t = new Trajet();
				t.setId(rs.getInt("idTrajet"));
				t.setDepart(vg.find(rs.getInt("villeDepart")));
				t.setDestination(vg.find(rs.getInt("villeArrivee")));
				t.setDate(rs.getString("date"));
				t.setHeure(rs.getString("heure"));
				t.setPlaces(rs.getInt("places"));
				t.setPrix(rs.getDouble("prix"));
				t.setConducteur(conducteur);
				
				
				res.add(t);
			}
			
		} catch (SQLException e) {
			System.err.println("Erreur select table Trajet");
			e.printStackTrace();
		}
		
		return res;
	}


	public List<Trajet> find(String date) {
		List<Trajet> res =  new ArrayList<Trajet>();
		Conducteur c;
		Trajet t = new Trajet();
		VilleGestionImpl vg = new VilleGestionImpl();
		ProfilGestionImpl pg = new ProfilGestionImpl();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Trajet where date like ?;");
			ps.setString(1,date);
			ResultSet rs = ps.executeQuery();
	
			while(rs.next())
			{	
				t = new Trajet();
				t.setId(rs.getInt("idTrajet"));
				t.setDepart(vg.find(rs.getInt("villeDepart")));
				t.setDestination(vg.find(rs.getInt("villeArrivee")));
				t.setDate(rs.getString("date"));
				t.setHeure(rs.getString("heure"));
				t.setPlaces(rs.getInt("places"));
				t.setPrix(rs.getDouble("prix"));
				c = new Conducteur(pg.find(rs.getInt("idConducteur")));
				t.setConducteur(c);
				
				
				res.add(t);
			}
			
		} catch (SQLException e) {
			System.err.println("Erreur select table Trajet");
			e.printStackTrace();
		}
		
		return res;
	}

}
