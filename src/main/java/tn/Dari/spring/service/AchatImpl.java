package tn.Dari.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.Dari.spring.entity.Annonce;
import tn.Dari.spring.repository.AchatRespository;

public class AchatImpl implements IAchat {
	@Autowired
	AchatRespository achatRespository;
	
	

	public AchatImpl() {
		super();
	
	}

	@Override
	public List<Annonce> retrieveAllAnnanceAscPrice() {
		List<Annonce> annonces=new ArrayList<>();
		annonces=achatRespository.findAllOrderByAscPrice();
		return annonces;
	}

	@Override
	public List<Annonce> retrieveAllAnnanceDescPrice() {
		List<Annonce> annonces=new ArrayList<>();
		annonces=achatRespository.findAllOrderByDescPrice();
		return annonces;
	}

	@Override
	public List<Annonce> retrieveAllAnnanceCategorie(String categorie) {
		List<Annonce> annonces=new ArrayList<>();
		annonces=achatRespository.findAllByCategorieLike(categorie);
		return annonces;
	}

	@Override
	public List<Annonce> retrieveAllAnnanceType(String type) {
		List<Annonce> annonces=new ArrayList<>();
		annonces=achatRespository.findAllByTypeLike(type);
		return annonces;
	}

	@Override
	public List<Annonce> retrieveAllAnnanceSurface(int surfMin, int surfMax) {
		List<Annonce> annonces=new ArrayList<>();
		annonces=achatRespository.findBySurfaceBetween(surfMin, surfMax);
		return annonces;
	}

	@Override
	public List<Annonce> retrieveAllAnnanceRegion(String region) {
		List<Annonce> annonces=new ArrayList<>();
		annonces=achatRespository.findAllByRegionLike(region);
		return annonces;
	}

	@Override
	public List<Annonce> retrieveAllAnnanceVille(String ville) {
		List<Annonce> annonces=new ArrayList<>();
		annonces=achatRespository.findAllByVilleLike(ville);
		return annonces;
	}

	@Override
	public List<Annonce> retrieveAllAnnanceNombreDeChambre(int nbreChambre) {
		List<Annonce> annonces=new ArrayList<>();
		annonces=achatRespository.findAllBynbreChambreLike(nbreChambre);
		return annonces;
	}

	

	
	
	

}
