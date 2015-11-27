package metier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DAO;
import model.Paiement;
import model.Passager;
import util.Conversion;

public class PaiementGestionImpl extends DAO<Paiement>{


	@Override
	public Paiement find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Paiement find(int idPassager,int idTrajet) {
		Paiement p = new Paiement();
		ProfilGestionImpl pg = new ProfilGestionImpl();
		TrajetGestionImpl tg = new TrajetGestionImpl();
		
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Paiement where "
					+ "idPassager=? and"
					+ "idTrajet=?;");
			ps.setInt(1,idPassager);
			ps.setInt(2, idTrajet);
			
			ResultSet rs = ps.executeQuery();
			
			int idp,idt;
			while(rs.next())
			{
				idp = rs.getInt("idPassager");
				idt = rs.getInt("idTrajet");
				if(idp==idPassager && idt==idTrajet)
				{
					p.setPassager((Passager)pg.find(idp));
					p.setTrajet(tg.find(idt));
					p.setPaiementValide(Conversion.sqliteToBool(rs.getInt("paiementValide")));
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur find table Paiement");
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Paiement create(Paiement p) {
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Paiement (idPassager,idTrajet,paiementValide) values (?,?,?);");
			ps.setInt(1, p.getPassager().getId());
			ps.setInt(2, p.getTrajet().getId());
			ps.setInt(3, Conversion.toSqliteBool(p.isPaiementValide()));
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur insert into table Paiement");
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public Paiement update(Paiement p) {
		try {
			PreparedStatement ps = this.connection.prepareStatement("update Paiement set"
					+ "idPassager=?,"
					+ "idTrajet=?,"
					+ "paiementValide=?");
			
			ps.setInt(p.getPassager().getId(),1);
			ps.setInt(p.getTrajet().getId(), 2);
			ps.setInt(Conversion.toSqliteBool(p.isPaiementValide()), 3);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur update table Paiement");
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public void delete(Paiement p) {
		try {
			PreparedStatement ps = connection.prepareStatement("delete from Paiement where idPassager=? and idTrajet=?");
			ps.setInt(1,p.getPassager().getId());
			ps.setInt(2, p.getTrajet().getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur delete from table Paiement");
			e.printStackTrace();
		}
		
	}

	

}
