package tn.Dari.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.Dari.spring.entity.Abonnement;
import tn.Dari.spring.entity.AbonnementType;
import tn.Dari.spring.entity.User;
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

	@Override
	public List<Abonnement> retrieveAbonnementPerUser(User user) {
		List<Abonnement> Abonnements=new ArrayList<>();
		Abonnements=(List<Abonnement>)abonnementRepository.retrieveAbonnementPerUser(user);
		return Abonnements;
	}


	@Override
	public int findAbonnementByTypesAndName(String nom, AbonnementType type , User user) {
		return abonnementRepository.findAbonnementByTypesAndName(nom, type, user);
	 

	}

	@Override
	public int TotalAbonnement() {
		
	return abonnementRepository.totalAbonnement();
	}

	@Override
	public Map<String, Float> tauxAbonnement() {

   Map<String,Float> tauxMap = new HashMap<>();
 int total=abonnementRepository.totalAbonnement();
Map<String,Integer> abonnementmap=abonnementRepository.totalAbonnementPerName();
		      Iterator <Entry<String, Integer>> Iterator = abonnementmap.entrySet().iterator();
			  while (Iterator.hasNext()) {
				  
				  Map.Entry <String,Integer> mapentry= Iterator.next();
				  tauxMap.put(mapentry.getKey(),(float) (mapentry.getValue()*100/total));
			  }
			  return tauxMap;
	}

	

	
   
  }
	
	

