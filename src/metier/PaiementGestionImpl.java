package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Paiement;
import model.Passager;
import model.Profil;
import model.Trajet;
import util.Conversion;

public class PaiementGestionImpl implements IPaiementGestion {

	@Override
	public void addPaiement(Paiement p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Paiement (idPassager,idTrajet,paiementValide) values (?,?,?);");
			ps.setInt(1, p.getPassager().getId());
			ps.setInt(2, p.getTrajet().getId());
			ps.setInt(3, Conversion.toSqliteBool(p.isPaiementValide()));
			
			int nbModif = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur insert into table Paiement");
			e.printStackTrace();
		}

	}

	@Override
	public void deletePaiement(Paiement p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("delete from Paiement where idPassager=? and idTrajet=?");
			ps.setInt(1,p.getPassager().getId());
			ps.setInt(2, p.getTrajet().getId());
			
			int nbModif = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur delete from table Paiement");
			e.printStackTrace();
		}

	}

	@Override
	public void deletePaiement(Passager p, Trajet t) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("delete from Paiement where idPassager=? and idTrajet=?");
			ps.setInt(1,p.getId());
			ps.setInt(2, t.getId());
			
			int nbModif = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur delete from table Paiement");
			e.printStackTrace();
		}
		
	}

	

}
