package tn.Dari.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.Dari.spring.entity.Livraison;
import tn.Dari.spring.entity.MethodePayement;
import tn.Dari.spring.repository.LivraisonRepository;

public class LivraisonImpl implements ILivraison {
	@Autowired
	LivraisonRepository livraisonRepository;

	@Override
	public List<Livraison> retrieveAllLivraison() {
		List<Livraison> livraisons=new ArrayList<>();
		livraisons=(List<Livraison>)livraisonRepository.findAll();
		return livraisons;
	}

	@Override
	public Livraison addAnnanceMeuble(Livraison l) {
		livraisonRepository.save(l);
		return l;
	}

	@Override
	public void deleteAnnanceMeuble(int id) {
		livraisonRepository.deleteById(id);
		
	}

	@Override
	public Livraison updateAnnanceMeuble(Livraison l) {
		livraisonRepository.save(l);
		return l;
	}

	@Override
	public Livraison retrieveAnnanceMeuble(int id) {
		return livraisonRepository.findById(id).get();
	}
	
	public List<Livraison> retrieveAllLivraisonAdresse(String adresse) {
		List<Livraison> meubles=new ArrayList<>();
		meubles=livraisonRepository.findAllByAdresseLike(adresse);
		return meubles;
		
	}
	public List<Livraison> retrieveAllLivraisonPayement(String methode) {
		List<Livraison> meubles=new ArrayList<>();
		meubles=livraisonRepository.findAllByMethodePayementLike(methode);
		return meubles;
		
	}
	public List<Livraison> retrieveAllLivraisonStatus(String status) {
		List<Livraison> meubles=new ArrayList<>();
		meubles=livraisonRepository.findAllByLivraisonStatusLike(status);
		return meubles;
		
	}

}
