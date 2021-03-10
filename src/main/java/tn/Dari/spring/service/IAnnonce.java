package tn.Dari.spring.service;

import java.util.List;


import tn.Dari.spring.entity.Annonce;

public interface IAnnonce {
	List<Annonce> retrieveAllAnnance();
	Annonce addAnnance(Annonce a);
	void deleteAnnance(int id);
	Annonce updateAnnance(Annonce a);
	Annonce retrieveAnnance(int id);
	List<Annonce> retrieveAllAnnanceAscPrice();
	List<Annonce> retrieveAllAnnanceDescPrice();
	List<Annonce> retrieveAllAnnanceAdresse(String adresse);
	List<Annonce> retrieveAllAnnanceregion(String region);
	List<Annonce> retrieveAllAnnanceville(String ville);
	

}
