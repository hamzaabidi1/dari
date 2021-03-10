package tn.Dari.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.Dari.spring.entity.Annonce;
import tn.Dari.spring.repository.AnnonceRepository;
@Service
public class AnnonceImpl implements IAnnonce {
	@Autowired
	AnnonceRepository annonceRepository;
	
	

	public AnnonceImpl() {
		super();
	}

	@Override
	public List<Annonce> retrieveAllAnnance() {
		List<Annonce> annances=new ArrayList<>();
		annances=(List<Annonce>)(annonceRepository.findAll());
		return annances;
	}

	@Override
	public Annonce addAnnance(Annonce a) {
		annonceRepository.save(a);
		return a;
	}

	@Override
	public void deleteAnnance(int id) {
		annonceRepository.deleteById(id);
		
	}

	@Override
	public Annonce updateAnnance(Annonce a) {
		annonceRepository.save(a);
		return a;
	}

	@Override
	public Annonce retrieveAnnance(int id) {
		Annonce annonce=annonceRepository.findById(id).get();
		return annonce;
	}
	

	@Override
	public List<Annonce> retrieveAllAnnanceAscPrice() {
		List<Annonce> Annonces=new ArrayList<>();
		Annonces=annonceRepository.findAllOrderByPrixAsc();
		return Annonces;
	}

	@Override
	public List<Annonce> retrieveAllAnnanceDescPrice() {
		List<Annonce> Annonces=new ArrayList<>();
		Annonces=annonceRepository.findAllOrderByPrixDesc();
		return Annonces;
	}

	@Override
	public List<Annonce> retrieveAllAnnanceAdresse(String adresse) {
		List<Annonce> Annonces=new ArrayList<>();
		Annonces=annonceRepository.findAllByAdresseLike(adresse);
		return Annonces;
	}

	@Override
	public List<Annonce> retrieveAllAnnanceregion(String region) {
		List<Annonce> Annonces=new ArrayList<>();
		Annonces=annonceRepository.findAllByRegionLike(region);
		return Annonces;
	}

	@Override
	public List<Annonce> retrieveAllAnnanceville(String ville) {
		List<Annonce> Annonces=new ArrayList<>();
		Annonces=annonceRepository.findAllByVilleLike(ville);
		return Annonces;
	}

}

	
