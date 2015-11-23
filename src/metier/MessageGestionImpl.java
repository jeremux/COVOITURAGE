package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

import model.Message;
import util.RecupereID;

public class MessageGestionImpl implements IMessageGestion {

	@Override
	public void addMessage(Message m) {
		Connection connection = SingletonConnection.getConnection();
		Set<Integer> listIdAvant = RecupereID.getListID("idMessage", "Message");
		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO Message (objet,contenu,idDestinataire,"
					+ "idExpediteur,idTrajet) values (?,?,?,?,?);");
			ps.setString(1, m.getObjet());
			ps.setString(2, m.getContenu());
			ps.setInt(3, m.getDestinataire().getId());
			ps.setInt(4,m.getExpediteur().getId());
			ps.setInt(5, m.getTrajet().getId());
			
			int nbModif = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur insert into table Message");
			e.printStackTrace();
		}
		/* On met à jour l'id */
		m.setId(RecupereID.getNewId("idMessage", "Message", listIdAvant));

	}

	@Override
	public void deleteMessage(Message m) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("delete from Message where idMessage=?");
			ps.setInt(1,m.getId());
			
			int nbModif = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erreur prepareStatement table Message");
			e.printStackTrace();
		}

	}

}
