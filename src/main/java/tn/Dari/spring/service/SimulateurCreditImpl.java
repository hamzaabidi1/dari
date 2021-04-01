package tn.Dari.spring.service;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.Dari.spring.entity.SimulateurCredit;
import tn.Dari.spring.repository.SimulateurCreditRepository;

@Service
public class SimulateurCreditImpl implements ISimulateurCredit {
	private static final Logger l = LogManager.getLogger(SimulateurCreditImpl.class);
	@Autowired
	SimulateurCreditRepository SimulateurCreditrepostory ;
	
	@Override
	public SimulateurCredit addSimulateurCredit(SimulateurCredit scr) {
		return SimulateurCreditrepostory.save(scr);
	}

	@Override
	public void updateSimulateurCredit(SimulateurCredit scr, int id) {
		SimulateurCredit sc= SimulateurCreditrepostory.findById(id).get();
		sc.setAge(scr.getAge());
		sc.setSalaireBrut(scr.getSalaireBrut());
		sc.setRevenuAnnuel(scr.getRevenuAnnuel());
		sc.setDuree(scr.getDuree());
		SimulateurCreditrepostory.save(sc);
		
	}

	@Override
	public void DeleteSimulateurCredit(int id) {
		SimulateurCreditrepostory.deleteById(id);
		
	}

	@Override
	public List<SimulateurCredit> retrieveAllSimulateurCredit() {
		List<SimulateurCredit> scs = (List<SimulateurCredit>) SimulateurCreditrepostory.findAll();
		for(SimulateurCredit sc : scs) {
			l.info("SimulateurCredit :" + sc);
		}
		return scs;
	}

	@Override
	public List<SimulateurCredit> retrieveSimulateurCreditByUser(int iduser) {
		List<SimulateurCredit> scs = (List<SimulateurCredit>) SimulateurCreditrepostory.retrieveSimulateurCreditByUser(iduser);
		for(SimulateurCredit sc : scs) {
			l.info("SimulateurCredit :" + sc);
		}
		return scs;
	}

	@Override
	public List<SimulateurCredit> retrieveSimulateurCreditByUserBanque(int iduser, int idbnq) {
		List<SimulateurCredit> scs = (List<SimulateurCredit>) SimulateurCreditrepostory.retrieveSimulateurCreditByUserBanque(iduser, idbnq);
		for(SimulateurCredit sc : scs) {
			l.info("SimulateurCredit :" + sc);
		}
		return scs;
	}

	
}
