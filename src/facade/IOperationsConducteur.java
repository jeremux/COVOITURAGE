package facade;

import model.Trajet;
import model.Ville;

public interface IOperationsConducteur {
	
	public void ajouterTrajet(Trajet t);
	public void supprimerTrajet(Trajet t);
	public void updateTrajet(Trajet t);
	
}
