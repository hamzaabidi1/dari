package tn.Dari.spring.service;

import java.util.List;
import java.util.Map;

import tn.Dari.spring.entity.Abonnement;
import tn.Dari.spring.entity.AbonnementType;
import tn.Dari.spring.entity.User;

public interface IAbonnement {
	List<Abonnement> retrieveAllAbonnement();
	Abonnement addAbonnement(Abonnement a);
	void deleteAbonnement(int id);
	Abonnement updateAbonnement(Abonnement a);
	Abonnement retrieveAbonnement(int id);
	List<Abonnement> retrieveAbonnementPerUser (User user);
	int TotalAbonnement();
	Map<String,Float> tauxAbonnement();
	int findAbonnementByTypesAndName(String nom, AbonnementType type , User user);
	
}
