/*
 * Classe pour l'interaction avec la table Message
 *
 * @author Jeremy FONTAINE
 * @since 1.0
 */
package metier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dao.DAO;
import model.Message;
import model.Trajet;
import util.RecupereID;

public class MessageGestionImpl extends DAO<Message> {

	@Override
	public Message find(int id) {
		Message m = new Message();
		ProfilGestionImpl profilDao = new ProfilGestionImpl();
		TrajetGestionImpl trajetDao = new TrajetGestionImpl();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Message where idMessage=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			int idp;
			while (rs.next()) {
				idp = rs.getInt("idMessage");
				if (idp == id) {
					m.setId(idp);
					m.setContenu(rs.getString("contenu"));
					m.setDestinataire(profilDao.find(rs.getInt("idDestinataire")));
					m.setExpediteur(profilDao.find(rs.getInt("idExpediteur")));
					m.setObjet(rs.getString("objet"));
					m.setTrajet(trajetDao.find(rs.getInt("idTrajet")));
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur find table message");
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
			ps.setInt(4, m.getExpediteur().getId());

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
			PreparedStatement ps = this.connection.prepareStatement("update Message set objet=?," + "contenu = ?,"
					+ "idDestinataire = ?," + "idExpediteur = ?," + "idTrajet = ?" + "where idMessage = ?;");

			ps.setString(1, m.getObjet());
			ps.setString(2, m.getContenu());
			ps.setInt(3, m.getDestinataire().getId());
			ps.setInt(4, m.getExpediteur().getId());
			ps.setInt(5, m.getTrajet().getId());
			ps.setInt(6, m.getId());

			ps.executeUpdate();

			res = this.find(m.getId());

		} catch (SQLException e) {
			System.err.println("Erreur update table Message");
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public void delete(Message m) {
		try {
			PreparedStatement ps = this.connection.prepareStatement("delete from Message where idMessage=?");
			ps.setInt(1, m.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Erreur delete from table Message");
			e.printStackTrace();
		}

	}

	public List<Message> findRecus(int idProfil) {
		List<Message> res = new ArrayList<Message>();
		Message m = new Message();
		ProfilGestionImpl profilDao = new ProfilGestionImpl();
		TrajetGestionImpl trajetDao = new TrajetGestionImpl();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from Message where idDestinataire=?");
			ps.setInt(1, idProfil);
			ResultSet rs = ps.executeQuery();

			int idp;
			while (rs.next()) {
				idp = rs.getInt("idDestinataire");
				if (idp == idProfil) {
					m = new Message();
					m.setId(idp);
					m.setContenu(rs.getString("contenu"));
					m.setDestinataire(profilDao.find(rs.getInt("idDestinataire")));
					m.setExpediteur(profilDao.find(rs.getInt("idExpediteur")));
					m.setObjet(rs.getString("objet"));
					m.setTrajet(trajetDao.find(rs.getInt("idTrajet")));

					res.add(m);
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur find from table Message where idDestinataire="+idProfil);
			e.printStackTrace();
		}

		return res;
	}

	public List<Message> findEnvoyes(int idProfil) {
		List<Message> res = new ArrayList<Message>();
		Message m = new Message();
		ProfilGestionImpl profilDao = new ProfilGestionImpl();
		TrajetGestionImpl trajetDao = new TrajetGestionImpl();
		Trajet t;

		try {
			PreparedStatement ps = connection.prepareStatement("select * from Message where idExpediteur=?");
			ps.setInt(1, idProfil);
			ResultSet rs = ps.executeQuery();

			int idp;
			while (rs.next()) {
				idp = rs.getInt("idExpediteur");
				if (idp == idProfil) {
					m = new Message();
					m.setId(rs.getInt("idMessage"));
					m.setContenu(rs.getString("contenu"));
					m.setDestinataire(profilDao.find(rs.getInt("idDestinataire")));
					m.setExpediteur(profilDao.find(rs.getInt("idExpediteur")));
					m.setObjet(rs.getString("objet"));
					t = trajetDao.find(rs.getInt("idTrajet"));
					m.setTrajet(t);

					res.add(m);
				}
			}
		} catch (SQLException e) {
			System.err.println("Erreur find from table Message");
			e.printStackTrace();
		}

		return res;
	}

	public void delete(Trajet t) {
		try {
			PreparedStatement ps = this.connection.prepareStatement("delete from Message where idTrajet=?");
			ps.setInt(1, t.getId());

			ps.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Erreur delete from table Message");
			e.printStackTrace();
		}
	}

}
