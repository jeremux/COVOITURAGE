package metier;

import java.util.List;

import model.Message;

public interface IMessageGestion {

	public List<Message> getMessageRecu(long idDestinataire);
	public List<Message> getMessageEnvoye(long idExpediteur);
	public Message getMessage(long idTrajet,long idExpediteur, long idDestinataire);
}
