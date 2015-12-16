package facade;

import model.Profil;
import model.Trajet;


public interface IOperationsAdmin {
	public void supprimerMessage(Trajet t);
	public void supprimerVoyageurs(Trajet t);
	public boolean isPaye(Trajet t,Profil p);
	public boolean isReserve(Trajet t,Profil p);
}
