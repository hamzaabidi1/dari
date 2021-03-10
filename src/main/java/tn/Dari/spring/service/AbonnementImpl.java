package tn.Dari.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.Dari.spring.entity.Abonnement;
import tn.Dari.spring.repository.AbonnementRepository;

@Service
public class AbonnementImpl implements IAbonnement {
	
	@Autowired
	AbonnementRepository abonnementRepository;
	
	@Override
	public List<Abonnement> retrieveAllAbonnement() {
		List<Abonnement> Abonnements=new ArrayList<>();
		Abonnements=(List<Abonnement>)abonnementRepository.findAll();
		return Abonnements;
	}

	@Override
	public Abonnement addAbonnement(Abonnement a) {
		abonnementRepository.save(a);
		return a;
	}

	@Override
	public void deleteAbonnement(int id) {
		abonnementRepository.deleteById(id);
		
	}

	@Override
	public Abonnement updateAbonnement(Abonnement a) {
		abonnementRepository.save(a);
		return a;
	}

	@Override
	public Abonnement retrieveAbonnement(int id) {
	return abonnementRepository.findById(id).get();
	}

}
