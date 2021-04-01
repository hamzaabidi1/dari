package tn.Dari.spring.service;

<<<<<<< HEAD
import java.util.List;
import java.util.Map;
import java.util.Set;

import tn.Dari.spring.entity.Annonce;
import tn.Dari.spring.entity.User;
import tn.Dari.spring.entity.taux;

public interface IAchat {
	List<Annonce> retrieveAllAnnanceAscPrice();
	List<Annonce> retrieveAllAnnanceDescPrice();
	List<Annonce> retrieveAllAnnanceCategorie(String categorie);
	List<Annonce> retrieveAllAnnanceType(String type);
	List<Annonce> retrieveAllAnnanceSurface(int surfMin,int surfMax);
	List<Annonce> retrieveAllAnnanceRegion(String region);
	List<Annonce> retrieveAllAnnanceVille(String ville);
	List<Annonce> retrieveAllAnnanceNombreDeChambre(int nbreChambre);
	float prixParMetre (String region);
	Annonce dernierBiensVendu();
	void saveSearchForUser(String categorie,int surfMin, int surfMax,String region,float prixmin,float prixmax,String ville,int nbreChambre,User user);
	List<Annonce> retrieveAllAnnanceForSearchPerUser(User user);
	Map<String,Float> tauxAchatPerRegion();




=======
public interface IAchat {
>>>>>>> cfd0ecfc70f8e1bd72f1399eac27d6770d0d4607

}
