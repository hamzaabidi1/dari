package tn.Dari.spring.service;

import java.util.List;
import tn.Dari.spring.entity.Abonnement;

public interface IAbonnement {
	List<Abonnement> retrieveAllAbonnement();
	Abonnement addAbonnement(Abonnement a);
	void deleteAbonnement(int id);
	Abonnement updateAbonnement(Abonnement a);
	Abonnement retrieveAbonnement(int id);

}
