package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Passager;
import model.Trajet;
import model.Voyageurs;

public class VoyageursGestionImpl implements IVoyageursGestion {

	@Override
	public void add(Voyageurs v) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Voyageurs (idPassager,idTrajet) values (?,?);");
			ps.setInt(1, v.getPassager().getId());
			ps.setInt(2, v.getTrajet().getId());
			
			int nbModif = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur insert into table Voyageurs");
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Voyageurs v) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("delete from Voyageurs where idPassager=? and idTrajet=?");
			ps.setInt(1,v.getPassager().getId());
			ps.setInt(2, v.getTrajet().getId());
			
			int nbModif = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur delete from table Voyageurs");
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Passager p, Trajet t) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("delete from Voyageurs where idPassager=? and idTrajet=?");
			ps.setInt(1,p.getId());
			ps.setInt(2, t.getId());
			
			int nbModif = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur delete from table Voyageurs");
			e.printStackTrace();
		}

	}

}
