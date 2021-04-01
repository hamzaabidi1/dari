package tn.Dari.spring.service;

import java.util.List;



import tn.Dari.spring.entity.AnnanceMeuble;



public interface IAnnonceMeuble {
	List<AnnanceMeuble> retrieveAllAnnanceMeuble();
	AnnanceMeuble addAnnanceMeuble(AnnanceMeuble a);
	void deleteAnnanceMeuble(int id);
	AnnanceMeuble updateAnnanceMeuble(AnnanceMeuble a);
	AnnanceMeuble retrieveAnnanceMeuble(int id);
	List<AnnanceMeuble> retrieveAllAnnanceMeubleAscPrice();
	List<AnnanceMeuble> retrieveAllAnnanceMeubleDescPrice();
	List<AnnanceMeuble> retrieveAllAnnanceMeubleAdresse(String adresse);
	List<AnnanceMeuble> retrieveAllAnnanceMeubleregion(String region);
	List<AnnanceMeuble> retrieveAllAnnanceMeubleville(String ville);

}
