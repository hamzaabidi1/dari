package tn.Dari.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.Dari.spring.entity.Reclamation;
import tn.Dari.spring.entity.User;
import tn.Dari.spring.repository.IReclamationRepository;


@Service
public class ReclamationImpl implements IReclamationService {
	private static final Logger l = LogManager.getLogger(ReclamationImpl.class);
    @Autowired
   IReclamationRepository reclamationrepostory ;
	@Override
	public Reclamation addReclamation(Reclamation rec) {
		return reclamationrepostory.save(rec);
	}

	@Override
	public void updateReclamation(Reclamation rec, int id) {
		Reclamation rc = reclamationrepostory.findById(id).get();
		rc.setReponse(rc.getReponse());
		rc.setSubject(rc.getSubject());
		rc.setCategorie(rc.getCategorie());
		reclamationrepostory.save(rc);
		
		
		
	}

	
	
	


	
	
	
	@Override
	public void setrespondtoreclamation(int id, String reponse) {
		reclamationrepostory.respondtoreclamation(id, reponse)	;
		
		
		
	}
	@Override
	public void DeleteReclamation(int id) {
		reclamationrepostory.deleteById(id);		
	}

//	@Override
//	public List<Reclamation> retreiveAllReclamation() {
//		List<Reclamation> rct = (List<Reclamation>) reclamationrepostory.findAll();
//		for(Reclamation rc : rct) {
//			l.info("prod +++ :" + rc);
//		}
//		return rct;
//	}
	@Override
	public List<Reclamation> retreiveAllReclamation() {
		return (List<Reclamation>) reclamationrepostory.findAll();
	}
	@Override
	public void addReponse(Reclamation rep, int id) {
		Reclamation re = reclamationrepostory.findById(id).get();
		re.setReponse(re.getReponse());
		//re.setRepondu(1);
		//rc.setCategorie(rc.getCategorie());
		reclamationrepostory.save(re);
		// TODO Auto-generated method stub
		
	}

	@Override
	public  Map<User,Integer> nombreR() {
	
		return reclamationrepostory.nombre();
	}

	
	@Override
	public void update(Reclamation rec, int id) {
		// TODO Auto-generated method stub
		
	}

	
}
