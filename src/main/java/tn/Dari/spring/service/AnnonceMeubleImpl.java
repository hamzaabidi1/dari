package tn.Dari.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.Dari.spring.entity.AnnanceMeuble;
import tn.Dari.spring.repository.AnnanceMeubleReopsitory;

public class AnnonceMeubleImpl implements IAnnonceMeuble {
	@Autowired
	AnnanceMeubleReopsitory annonceMeubleRiposotry;

	@Override
	public List<AnnanceMeuble> retrieveAllAnnanceMeuble() {
		List<AnnanceMeuble> annanceMeubles=new ArrayList<>();
		annanceMeubles=(List<AnnanceMeuble>)annonceMeubleRiposotry.findAll();
		return annanceMeubles;
	}

	@Override
	public AnnanceMeuble addAnnanceMeuble(AnnanceMeuble a) {
		annonceMeubleRiposotry.save(a);
		return a;
	}

	@Override
	public void deleteAnnanceMeuble(int id) {
		annonceMeubleRiposotry.deleteById(id);
		
	}

	@Override
	public AnnanceMeuble updateAnnanceMeuble(AnnanceMeuble a) {
		annonceMeubleRiposotry.save(a);
		return a;
	}

	@Override
	public AnnanceMeuble retrieveAnnanceMeuble(int id) {
		return annonceMeubleRiposotry.findById(id).get();
	}
	
	public List<AnnanceMeuble> retrieveAllAnnanceMeubleAscPrice() {
		List<AnnanceMeuble> meubles=new ArrayList<>();
		meubles=annonceMeubleRiposotry.findAllOrderByPrixAsc();
		return meubles;
		
	}

}
