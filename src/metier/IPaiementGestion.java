package metier;

import model.Paiement;
import model.Passager;
import model.Trajet;

public interface IPaiementGestion {
	
	public void addPaiement(Paiement p);
	public void deletePaiement(Paiement p);
	public void deletePaiement(Passager p,Trajet t);
}
