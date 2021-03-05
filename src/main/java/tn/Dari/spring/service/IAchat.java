package tn.Dari.spring.service;

import java.util.List;


import tn.Dari.spring.entity.Annonce;

public interface IAchat {
	List<Annonce> retrieveAllAnnanceAscPrice();
	List<Annonce> retrieveAllAnnanceDescPrice();
	List<Annonce> retrieveAllAnnanceCategorie(String categorie);
	List<Annonce> retrieveAllAnnanceType(String type);
	List<Annonce> retrieveAllAnnanceSurface(int surfMin,int surfMax);
	List<Annonce> retrieveAllAnnanceRegion(String region);
	List<Annonce> retrieveAllAnnanceVille(String ville);
	List<Annonce> retrieveAllAnnanceNombreDeChambre(int nbreChambre);






}
