package tn.Dari.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.Dari.spring.entity.AnnanceMeuble;
import tn.Dari.spring.entity.Livraison;
import tn.Dari.spring.repository.AnnanceMeubleReopsitory;
import tn.Dari.spring.repository.LivraisonRepository;

public class LivraisonImpl implements ILivraison {
	@Autowired
	LivraisonRepository livraisonRepository;
	@Autowired
	AnnanceMeubleReopsitory annanceMeubleReopsitory;

	@Override
	public List<Livraison> retrieveAllLivraison() {
		List<Livraison> livraisons=new ArrayList<>();
		livraisons=(List<Livraison>)livraisonRepository.findAll();
		return livraisons;
	}

	@Override
	public Livraison addLivraison(Livraison l) {
		livraisonRepository.save(l);
		return l;
	}

	@Override
	public void deleteLivraison(int id) {
		livraisonRepository.deleteById(id);
		
	}

	@Override
	public Livraison updateLivraison(Livraison l) {
		livraisonRepository.save(l);
		return l;
	}

	@Override
	public Livraison retrieveLivraison(int id) {
		return livraisonRepository.findById(id).get();
	}
	@Override
	public List<Livraison> retrieveAllLivraisonAdresse(String Adresse) {
		List<Livraison> meubles=new ArrayList<>();
		meubles=livraisonRepository.findAllByAdresseLike(Adresse);
		return meubles;
		
	}
	@Override
	 public List<Livraison> retrieveAllLivraisonPayement(String methode) {
		List<Livraison> meubles=new ArrayList<>();
		meubles=livraisonRepository.findAllByMethodePayementLike(methode);
		return meubles;
		
	}
	@Override
	public List<Livraison> retrieveAllLivraisonStatus(String status) {
		List<Livraison> meubles=new ArrayList<>();
		meubles=livraisonRepository.findAllByLivraisonStatusLike(status);
		return meubles;
		
	}
	@Override
	public void AddMaubleToLivraison(int idAnnoncemeuble,int idlivraison) {
		
		Livraison livraison =livraisonRepository.findById(idlivraison).get();
		List<AnnanceMeuble> meubles =livraison.getAnnonceMeuble();
		meubles.add(annanceMeubleReopsitory.findById(idAnnoncemeuble).get());
		livraison.setAnnonceMeuble(meubles);
		livraisonRepository.save(livraison);
		
	}
}
