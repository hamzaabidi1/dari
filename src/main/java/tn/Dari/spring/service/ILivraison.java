package tn.Dari.spring.service;

import java.util.List;
import tn.Dari.spring.entity.Livraison;



public interface ILivraison {
	List<Livraison> retrieveAllLivraison();
	Livraison addLivraison(Livraison l);
	void deleteLivraison(int id);
	Livraison updateLivraison(Livraison l);
	Livraison retrieveLivraison(int id);
	List<Livraison> retrieveAllLivraisonAdresse(String Adresse);
	List<Livraison> retrieveAllLivraisonStatus(String status);
	List<Livraison> retrieveAllLivraisonPayement(String methode);
	void AddMaubleToLivraison(int idAnnoncemeuble,int idlivraison);
	

}
