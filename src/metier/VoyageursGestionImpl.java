package metier;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DAO;
import model.Passager;
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

}
