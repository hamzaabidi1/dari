package tn.Dari.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.Dari.spring.entity.AnnanceMeuble;
import tn.Dari.spring.repository.AnnanceMeubleRepository;

@Service
public class AnnonceMeubleImpl implements IAnnonceMeuble {
	
	
	
	@Autowired
	AnnanceMeubleRepository annonceMeubleRepository;
	
	
	

	public AnnonceMeubleImpl() {
		super();
	}

	@Override
	public List<AnnanceMeuble> retrieveAllAnnanceMeuble() {
		List<AnnanceMeuble> annanceMeubles=new ArrayList<AnnanceMeuble>();
		annanceMeubles=(List<AnnanceMeuble>)annonceMeubleRepository.findAll();
	
		return annanceMeubles;
	}

	@Override
	public AnnanceMeuble addAnnanceMeuble(AnnanceMeuble a) {
		annonceMeubleRepository.save(a);
		return a;
	}

	@Override
	public void deleteAnnanceMeuble(int id) {
		annonceMeubleRepository.deleteById(id);
		
	}

	@Override
	public AnnanceMeuble updateAnnanceMeuble(AnnanceMeuble a) {
		annonceMeubleRepository.save(a);
		return a;
	}

	@Override
	public AnnanceMeuble retrieveAnnanceMeuble(int id) {
		return annonceMeubleRepository.findById(id).get();
	}
	@Override
	public List<AnnanceMeuble> retrieveAllAnnanceMeubleAscPrice() {
		List<AnnanceMeuble> meubles=new ArrayList<>();
		meubles=annonceMeubleRepository.findAllOrderByPrixAsc();
		return meubles;
		
	}
	@Override
	public List<AnnanceMeuble> retrieveAllAnnanceMeubleDescPrice() {
		List<AnnanceMeuble> meubles=new ArrayList<>();
		meubles=annonceMeubleRepository.findAllOrderByPrixDesc();
		return meubles;
		
	}
	@Override
	public List<AnnanceMeuble> retrieveAllAnnanceMeubleAdresse(String adresse) {
		List<AnnanceMeuble> meubles=new ArrayList<>();
		meubles=annonceMeubleRepository.findAllByAdresseLike(adresse);
		return meubles;
		
	}

	@Override
	public List<AnnanceMeuble> retrieveAllAnnanceMeubleregion(String region) {
		List<AnnanceMeuble> meubles=new ArrayList<>();
		meubles=annonceMeubleRepository.findAllByRegionLike(region);
		return meubles;
	}

	@Override
	public List<AnnanceMeuble> retrieveAllAnnanceMeubleville(String ville) {
		List<AnnanceMeuble> meubles=new ArrayList<>();
		meubles=annonceMeubleRepository.findAllByVilleLike(ville);
		return meubles;
	}

}
