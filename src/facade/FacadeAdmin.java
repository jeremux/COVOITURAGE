package facade;

import metier.MessageGestionImpl;
import metier.VoyageursGestionImpl;
import model.Profil;
import model.Trajet;
import model.Voyageurs;

public class FacadeAdmin implements IOperationsAdmin {
	private MessageGestionImpl messageDAO = new MessageGestionImpl();
	private VoyageursGestionImpl voyageursDAO = new VoyageursGestionImpl();
	
	@Override
	public void supprimerMessage(Trajet t) {
			messageDAO.delete(t);
	}

	@Override
	public void supprimerVoyageurs(Trajet t) {
		voyageursDAO.delete(t);
	}

	@Override
	public boolean isPaye(Trajet t, Profil p) {
		return voyageursDAO.find(t.getId(), p.getId()).isPaye();
	}

	@Override
	public boolean isReserve(Trajet t, Profil p) {
		Voyageurs v =voyageursDAO.find(t.getId(), p.getId());
		return v.getFlagExistence()!=-1;		

	}
	
	

}
