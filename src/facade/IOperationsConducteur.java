/*
 * Interface des operations conducteurs
 *
 * @author Jeremy FONTAINE
 * @since 1.0
 */
package facade;

import java.util.List;

import model.Conducteur;
import model.Trajet;


public interface IOperationsConducteur {
	
	public void ajouterTrajet(Trajet t);
	public void supprimerTrajet(Trajet t);
	public void updateTrajet(Trajet t);
	public List<Trajet> getAnnonces();
	
}
