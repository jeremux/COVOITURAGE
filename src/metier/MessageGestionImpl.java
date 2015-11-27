package metier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import dao.DAO;
import model.Message;
import util.RecupereID;

public class MessageGestionImpl extends DAO<Message> {

	

	@Override
	public Message find(int id) {
		Message m = new Message();
		ProfilGestionImpl profilDao = new ProfilGestionImpl();
		TrajetGestionImpl trajetDao = new TrajetGestionImpl();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Message where idMessage=?");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			int idp;
			while(rs.next())
			{
				idp = rs.getInt("idMessage");
				if(idp==id)
				{
					m.setId(idp);
					m.setContenu(rs.getString("contenu"));
					m.setDestinataire(profilDao.find(rs.getInt("idDestinataire")));
					m.setDestinataire(profilDao.find(rs.getInt("idExpediteur")));
					m.setObjet(rs.getString("objet"));
					m.setTrajet(trajetDao.find(rs.getInt("idTrajet")));
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur getPreference table Preference");
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public Message create(Message m) {
		Set<Integer> listIdAvant = RecupereID.getListID("idMessage", "Message");
		try {
			PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Message (objet,contenu,idDestinataire,"
					+ "idExpediteur,idTrajet) values (?,?,?,?,?);");
			ps.setString(1, m.getObjet());
			ps.setString(2, m.getContenu());
			ps.setInt(3, m.getDestinataire().getId());
			ps.setInt(4,m.getExpediteur().getId());
			
			ps.setInt(5, m.getTrajet().getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur insert into table Message");
			e.printStackTrace();
		}
		/* On met à jour l'id */
		m.setId(RecupereID.getNewId("idMessage", "Message", listIdAvant));
		return m;
	}

	@Override
	public Message update(Message m) {
		Message res = new Message();
		try {
			PreparedStatement ps = this.connection.prepareStatement("update Message set objet=?,"
					+ "contenu = ?,"
					+ "idDestinataire = ?,"
					+ "idExpediteur = ?,"
					+ "idTrajet = ?"
					+ "where idMessage = ?;");
			
			ps.setString(1, m.getObjet());
			ps.setString(2, m.getContenu());
			ps.setInt(3, m.getDestinataire().getId());
			ps.setInt(4,m.getExpediteur().getId());
			ps.setInt(5, m.getTrajet().getId());
			ps.setInt(6, m.getId());
			
			ps.executeUpdate();
			
			res = this.find(m.getId());
			
		} catch (SQLException e) {
			System.err.println("Erreur insert into table Message");
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public void delete(Message m) {
		try {
			PreparedStatement ps = this.connection.prepareStatement("delete from Message where idMessage=?");
			ps.setInt(1,m.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur prepareStatement table Message");
			e.printStackTrace();
		}
		
	}

}
