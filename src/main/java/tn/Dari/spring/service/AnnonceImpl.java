package tn.Dari.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.Dari.spring.entity.Annonce;
import tn.Dari.spring.repository.AnnonceRepository;

public class AnnonceImpl implements IAnnonce {
	@Autowired
	AnnonceRepository annonceRepository;

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

	

}
