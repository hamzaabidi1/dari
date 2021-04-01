package tn.Dari.spring.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.Dari.spring.entity.User;
import tn.Dari.spring.entity.Annonce;
import tn.Dari.spring.entity.RendezVous;
import tn.Dari.spring.entity.ValidationRdv;
import tn.Dari.spring.repository.AnnonceRepository;
import tn.Dari.spring.repository.RendezVousRepository;
import tn.Dari.spring.repository.UserRepository;

@Service
public class RendezVousImpl implements IRendezVous {
	private static final Logger l = LogManager.getLogger(RendezVousImpl.class);
	@Autowired
	RendezVousRepository RendezVousrepostory ;
	@Autowired
	UserRepository Userrepository;
	@Autowired
	AnnonceRepository Annoncerepository;
	
	@Override
	public RendezVous addRendezVous(RendezVous rdv) {
		return RendezVousrepostory.save(rdv);
	}

	@Override
	public void updateRendezVous(RendezVous rdv, int id) {
		RendezVous ap= RendezVousrepostory.findById(id).get();
		ap.setDateRdv(rdv.getDateRdv());
		ap.setValidation(rdv.getValidation());
		RendezVousrepostory.save(ap);
		
	}

	@Override
	public void DeleteRendezVous(int id) {
		RendezVousrepostory.deleteById(id);
		
	}

	@Override
	public List<RendezVous> retreiveAllRendezVous() {
		List<RendezVous> apts = (List<RendezVous>) RendezVousrepostory.findAll();
		for(RendezVous ap : apts) {
			l.info("RendezVous :" + ap);
		}
		return apts;
	}

	@Override
	public void validRDV(int id , String message) {
		RendezVous apt= RendezVousrepostory.findById(id).get();
		apt.setValidation(ValidationRdv.valide);
		apt.setMessage(message);
		RendezVousrepostory.save(apt);
		
	}
	@Override
	public void rejectRDV(int id , String message) {
		RendezVous apt= RendezVousrepostory.findById(id).get();
		apt.setValidation(ValidationRdv.rejecte);
		apt.setMessage(message);
		RendezVousrepostory.save(apt);
		
	}
	@Override
	public List<RendezVous> retrieveRDVRecByUser(int iduser) {
		User us =  Userrepository.findById((long) iduser).get();
		Set<Annonce> ann= us.getListeAnnance();
		List<RendezVous> apts = new ArrayList<RendezVous>();
		for(Annonce ap : ann) {
			List<RendezVous> rdvs= ap.getRendezVous();
			for(RendezVous rdv : rdvs) {
				
				l.info("Vos RendezVous :" + rdv);
				apts.add(rdv);
		}}
		return apts;
	}

	@Override
	public List<RendezVous> retrieveRDVSentByUser(int iduser) {
		User us =  Userrepository.findById((long) iduser).get();
		List<RendezVous> apts = us.getListeRendezVous();
		for(RendezVous ap : apts) {
			l.info("Vos RendezVous :" + ap);
		}
		return apts;
	}
}
