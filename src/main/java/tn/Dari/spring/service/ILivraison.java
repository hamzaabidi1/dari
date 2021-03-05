package tn.Dari.spring.service;

import java.util.List;

import tn.Dari.spring.entity.Livraison;



public interface ILivraison {
	List<Livraison> retrieveAllLivraison();
	Livraison addAnnanceMeuble(Livraison l);
	void deleteAnnanceMeuble(int id);
	Livraison updateAnnanceMeuble(Livraison l);
	Livraison retrieveAnnanceMeuble(int id);
	List<Livraison> retrieveAllLivraisonAdresse(String Adresse);
	List<Livraison> retrieveAllLivraisonStatus(String status);
	List<Livraison> retrieveAllLivraisonPayement(String methode);
	void AddMaubleToLivraison(int idAnnoncemeuble,int idlivraison);
	

}
