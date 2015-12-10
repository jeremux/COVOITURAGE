package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connexion.SingletonConnection;
import dao.DAO;
import model.Conducteur;
import model.Passager;
import model.Profil;
import model.Trajet;
import model.Voyageurs;

public class VoyageursGestionImpl extends DAO<Voyageurs> {

	@Override
	public Voyageurs create(Voyageurs v) {

		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Voyageurs (idPassager,idTrajet) values (?,?);");
			ps.setInt(1, v.getPassager().getId());
			ps.setInt(2, v.getTrajet().getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur insert into table Voyageurs");
			e.printStackTrace();
		}
		
		return v;

	}

	@Override
	public void delete(Voyageurs v) {

		try {
			PreparedStatement ps = connection.prepareStatement("delete from Voyageurs where idPassager=? and idTrajet=?");
			ps.setInt(1,v.getPassager().getId());
			ps.setInt(2, v.getTrajet().getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur delete from table Voyageurs");
			e.printStackTrace();
		}
	}

	public void delete(Passager p, Trajet t) {
		try {
			PreparedStatement ps = connection.prepareStatement("delete from Voyageurs where idPassager=? and idTrajet=?");
			ps.setInt(1,p.getId());
			ps.setInt(2, t.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur delete from table Voyageurs");
			e.printStackTrace();
		}

	}

	@Override
	public Voyageurs find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Voyageurs update(Voyageurs v) {
		return null;
	}
	
	public List<Trajet> find(Profil p)
	{
		List<Trajet> res =  new ArrayList<Trajet>();
		
		Trajet t = new Trajet();
		TrajetGestionImpl tg = new TrajetGestionImpl();

		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Voyageurs where idPassager=?;");
			ps.setInt(1,p.getId());
			ResultSet rs = ps.executeQuery();
	
			while(rs.next())
			{	
				
				t = tg.find(rs.getInt("idTrajet"));
				
				res.add(t);
			}
			
		} catch (SQLException e) {
			System.err.println("Erreur select table Voyageurs");
			e.printStackTrace();
		}
		
		return res;
	}

	public List<Profil> findByTrajet(Trajet t) {
		List<Profil> res =  new ArrayList<Profil>();
		
		Profil p = new Profil();
		ProfilGestionImpl pg = new ProfilGestionImpl();

		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Voyageurs where idTrajet=?;");
			ps.setInt(1,t.getId());
			ResultSet rs = ps.executeQuery();
	
			while(rs.next())
			{	
				
				p = pg.find(rs.getInt("idPassager"));
				
				res.add(p);
			}
			
		} catch (SQLException e) {
			System.err.println("Erreur select table Voyageurs");
			e.printStackTrace();
		}
		
		return res;
	}



}
