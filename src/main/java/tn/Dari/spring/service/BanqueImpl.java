package tn.Dari.spring.service;

import tn.Dari.spring.entity.Banque;
import tn.Dari.spring.repository.BanqueRepository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BanqueImpl implements IBanque{

	private static final Logger l = LogManager.getLogger(BanqueImpl.class);
	@Autowired
	BanqueRepository banquerepostory ;
	
	@Override
	public Banque addBanque(Banque bnq) {
		return banquerepostory.save(bnq);
	}

	@Override
	public void updateBanque(Banque bnq, int id) {
		Banque bq= banquerepostory.findById(id).get();
		bq.setTitre(bnq.getTitre());
		bq.setDescription(bnq.getDescription());
		banquerepostory.save(bq);
		
	}

	@Override
	public void DeleteBanque(int id) {
		banquerepostory.deleteById(id);
		
	}

	@Override
	public List<Banque> retreiveAllBanque() {
		List<Banque> bqs = (List<Banque>) banquerepostory.findAll();
		for(Banque bq : bqs) {
			l.info("banque :" + bq);
		}
		return bqs;
	}

	@Override
	public void validbanque(int id) {
		Banque bq= banquerepostory.findById(id).get();
		bq.setValid(true);
		banquerepostory.save(bq);
		
	}

	@Override
	public void editTmmBanque(int id, float tmm) {
		Banque bnq= banquerepostory.findById(id).get();
		bnq.setTmm(tmm);
		banquerepostory.save(bnq);
		
	}

	@Override
	public void editPourcentageBenefBanque(int id, float prcbnfice) {
		Banque bnq= banquerepostory.findById(id).get();
		bnq.setPourcentageBinefice(prcbnfice);
		banquerepostory.save(bnq);
		
	}
}
