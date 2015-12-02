package facade;

import metier.TrajetGestionImpl;
import model.Trajet;

public class FacadeConducteur implements IOperationsConducteur {
	
	private TrajetGestionImpl trajetDAO =  new TrajetGestionImpl(); 

	@Override
	public void ajouterTrajet(Trajet t) {
		trajetDAO.create(t);

	}

	@Override
	public void supprimerTrajet(Trajet t) {
		trajetDAO.delete(t);

	}

	@Override
	public void updateTrajet(Trajet t) {
		trajetDAO.update(t);
		
	}

}
