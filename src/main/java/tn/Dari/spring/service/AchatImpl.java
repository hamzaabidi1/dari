package tn.Dari.spring.service;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.FlashMap;

import io.jsonwebtoken.lang.Collections;
import tn.Dari.spring.entity.Annonce;
import tn.Dari.spring.entity.Recherche;
import tn.Dari.spring.entity.User;
import tn.Dari.spring.entity.taux;
import tn.Dari.spring.repository.AchatRepository;
import tn.Dari.spring.repository.rechercheRepository;

@Service
public class AchatImpl implements IAchat {
	@Autowired
	AchatRepository achatRespository;
	@Autowired
	rechercheRepository rechercheRespository;

	public AchatImpl() {
		super();

	}

	@Override
	public List<Annonce> retrieveAllAnnanceAscPrice() {
		List<Annonce> annonces = new ArrayList<>();
		annonces = achatRespository.findAllOrderByAscPrice();
		return annonces;
	}

	@Override
	public List<Annonce> retrieveAllAnnanceDescPrice() {
		List<Annonce> annonces = new ArrayList<>();
		annonces = achatRespository.findAllOrderByDescPrice();
		return annonces;
	}

	@Override
	public List<Annonce> retrieveAllAnnanceCategorie(String categorie) {
		List<Annonce> annonces = new ArrayList<>();
		annonces = achatRespository.findAllByCategorieLike(categorie);
		return annonces;
	}

	@Override
	public List<Annonce> retrieveAllAnnanceType(String type) {
		List<Annonce> annonces = new ArrayList<>();
		annonces = achatRespository.findAllByTypeLike(type);
		return annonces;
	}

	@Override
	public List<Annonce> retrieveAllAnnanceSurface(int surfMin, int surfMax) {
		List<Annonce> annonces = new ArrayList<>();
		annonces = achatRespository.findBySurfaceBetween(surfMin, surfMax);
		return annonces;
	}

	@Override
	public List<Annonce> retrieveAllAnnanceRegion(String region) {
		List<Annonce> annonces = new ArrayList<>();
		annonces = achatRespository.findAllByRegionLike(region);
		return annonces;
	}

	@Override
	public List<Annonce> retrieveAllAnnanceVille(String ville) {
		List<Annonce> annonces = new ArrayList<>();
		annonces = achatRespository.findAllByVilleLike(ville);
		return annonces;
	}

	@Override
	public List<Annonce> retrieveAllAnnanceNombreDeChambre(int nbreChambre) {
		List<Annonce> annonces = new ArrayList<>();
		annonces = achatRespository.findAllBynbreChambreLike(nbreChambre);
		return annonces;
	}

	@Override
	public float prixParMetre(String region) {
		if ((region == "benarous") || (region == "tunis") || (region == "ariana") || (region == "manouba"))
			return 1000;
		else if ((region == "sousse") || (region == "hammamet") || (region == "monastir") || (region == "sfax"))
			return 600;
		else if ((region == "bizerte") || (region == "gabes") || (region == "nabeul") || (region == "djerba"))
			return 450;
		else
			return 200;

<<<<<<< HEAD
	
	
	
=======
public class AchatImpl implements IAchat {
>>>>>>> cfd0ecfc70f8e1bd72f1399eac27d6770d0d4607
=======
	}

	@Override
	public Annonce dernierBiensVendu() {
		return achatRespository.findLastAnnounce();
	}

	@Override
	public void saveSearchForUser(String categorie, int surfMin, int surfMax, String region, float prixmin,
			float prixmax, String ville, int nbreChambre, User user) {
		Recherche recherche = new Recherche(region, ville, categorie, prixmin, prixmax, surfMin, surfMax, nbreChambre,
				user);
		rechercheRespository.save(recherche);
	}

	@Override
	public List<Annonce> retrieveAllAnnanceForSearchPerUser(User user) {
		List<Recherche> lstRecherche = (List<Recherche>) rechercheRespository.findAllPerUser(user);
		List<Annonce> lstAnnonce = new ArrayList<>();
		for (Recherche recherche : lstRecherche) {
			lstAnnonce = achatRespository.findForUser(recherche.getCategorie(), recherche.getRegion(),
					recherche.getVille(), recherche.getNbrChambres(), recherche.getUser(), recherche.getMinPrice(),
					recherche.getMaxPrice(), recherche.getMinsurface(), recherche.getMaxsurface());
		}
		return lstAnnonce;
	}

	@Override
	public Map<String,Float> tauxAchatPerRegion() {
		Map<String,Float> tauxMap = new HashMap<>();
		int Allnbre = achatRespository.nbreAnnounce();
		List<String> AllRegion = new ArrayList<String>();
		AllRegion=achatRespository.findAllRegion();
		String compare =AllRegion.get(0);
		int nbre =0;
		for (int i=0;i<AllRegion.size();i++) {			
				if (compare==AllRegion.get(0)) {
				nbre++;
				float result =nbre*100/Allnbre;
				tauxMap.put(compare, result);
				AllRegion.remove(0);
				compare=AllRegion.get(0);
					nbre=0;
				}
		//	compare =AllRegion.get(0);
			}
			
  return tauxMap;
>>>>>>> master

	
}
	}
