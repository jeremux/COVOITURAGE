package metier;

import model.Message;

public interface IMessageGestion {

	public void addMessage(Message m);
	public void deleteMessage(Message m);
}
