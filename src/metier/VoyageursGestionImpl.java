package metier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import model.Passager;
import model.Profil;
import model.Trajet;
import model.Voyageurs;
import util.Conversion;

// TODO: Auto-generated Javadoc
/**
 * The Class VoyageursGestionImpl.
 */
public class VoyageursGestionImpl extends DAO<Voyageurs> {

	/* (non-Javadoc)
	 * @see dao.DAO#create(java.lang.Object)
	 */
	@Override
	public Voyageurs create(Voyageurs v) {

		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Voyageurs (idPassager,idTrajet,paye) values (?,?,?);");
			ps.setInt(1, v.getPassager().getId());
			ps.setInt(2, v.getTrajet().getId());
			ps.setInt(3, Conversion.toSqliteBool(v.isPaye()));
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur insert into table Voyageurs");
			e.printStackTrace();
		}
		
		return v;

	}

	/* (non-Javadoc)
	 * @see dao.DAO#delete(java.lang.Object)
	 */
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

	/**
	 * Delete.
	 *
	 * @param p the p
	 * @param t the t
	 */
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

	/* (non-Javadoc)
	 * @see dao.DAO#find(int)
	 */
	@Override
	public Voyageurs find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see dao.DAO#update(java.lang.Object)
	 */
	@Override
	public Voyageurs update(Voyageurs v) {
		try {
			PreparedStatement ps = this.connection.prepareStatement("update Voyageurs set "
					+ "paye=? "
					+ "where idTrajet=? and idProfil=?");
			
			System.out.println("=====================");
			System.out.println("idTrajet = "+v.getTrajet().getId());
			System.out.println("idProfil = "+v.getPassager().getId());
			System.out.println("DEBUG = "+Conversion.toSqliteBool(v.isPaye()));
			
			ps.setInt(Conversion.toSqliteBool(v.isPaye()), 1);
			ps.setInt(v.getPassager().getId(),2);
			ps.setInt(v.getTrajet().getId(), 3);
			
			
			int nb = ps.executeUpdate();
			System.out.println("nb ligne modifié = "+nb);
			System.out.println("=====================");
			
		} catch (SQLException e) {
			System.err.println("Erreur update table Paiement");
			e.printStackTrace();
		}
		
		return v;
	}
	
	/**
	 * Find.
	 *
	 * @param p the p
	 * @return the list
	 */
	public List<Trajet> find(Profil p)
	{
		List<Trajet> res =  new ArrayList<Trajet>();
		
		Trajet t = new Trajet();
		TrajetGestionImpl tg = new TrajetGestionImpl();

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

	/**
	 * Find by trajet.
	 *
	 * @param t the t
	 * @return the list
	 */
	public List<Profil> findByTrajet(Trajet t) {
		List<Profil> res =  new ArrayList<Profil>();
		
		Profil p = new Profil();
		ProfilGestionImpl pg = new ProfilGestionImpl();

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

	/**
	 * Delete.
	 *
	 * @param t the t
	 */
	public void delete(Trajet t) {
		try {
			PreparedStatement ps = connection.prepareStatement("delete from Voyageurs where idTrajet=?");		
			ps.setInt(1, t.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur delete from table Voyageurs");
			e.printStackTrace();
		}
	}

	/**
	 * Find.
	 *
	 * @param idTrajet the id trajet
	 * @param idProfil the id profil
	 * @return the voyageurs
	 */
	public Voyageurs find(int idTrajet, int idProfil) {
		Voyageurs res = new Voyageurs();
		ProfilGestionImpl profilDAO = new ProfilGestionImpl();
		TrajetGestionImpl trajetDAO = new TrajetGestionImpl();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Voyageurs where idTrajet=? and idPassager=?;");
			ps.setInt(1,idTrajet);
			ps.setInt(2, idProfil);
			ResultSet rs = ps.executeQuery();
	
			while(rs.next())
			{	
				Passager passager = new Passager(profilDAO.find(idProfil));
				res.setPassager(passager);
				res.setTrajet(trajetDAO.find(idTrajet));
				res.setPaye(Conversion.sqliteToBool(rs.getInt(3)));
				System.out.println("payé = "+rs.getInt(3));
				res.setFlagExistence(1);
			}
			
		} catch (SQLException e) {
			System.err.println("Erreur select table Voyageurs");
			e.printStackTrace();
		}
		
		return res;
	}



}
