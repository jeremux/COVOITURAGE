/*
 * Classe pour effectuer les opérations conducteur
 *
 * @author Jeremy FONTAINE
 * @since 1.0
 */
package facade;

import java.util.List;

import metier.TrajetGestionImpl;
import model.Conducteur;
import model.Trajet;

public class FacadeConducteur implements IOperationsConducteur {
	
	private TrajetGestionImpl trajetDAO =  new TrajetGestionImpl();
	private Conducteur c;
	
	public FacadeConducteur(Conducteur c) {
		super();
		this.setConducteur(c);
		
	}

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

	@Override
	public List<Trajet> getAnnonces() {
		return trajetDAO.find(this.getConducteur());
	}

	public Conducteur getConducteur() {
		return c;
	}

	public void setConducteur(Conducteur c) {
		this.c = c;
	}

	

}
