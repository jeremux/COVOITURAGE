package metier;

import model.Trajet;

public interface ItrajetGestion {
	
	public void addTrajet(Trajet t);
	public void deleteTrajet(int id);
	public Trajet getTrajet(int id);
	public void toto();
	
}
