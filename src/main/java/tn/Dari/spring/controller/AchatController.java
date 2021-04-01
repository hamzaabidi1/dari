package tn.Dari.spring.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.Dari.spring.entity.Annonce;
import tn.Dari.spring.entity.Recherche;
import tn.Dari.spring.entity.User;
import tn.Dari.spring.entity.taux;
import tn.Dari.spring.service.IAchat;
import tn.Dari.spring.service.IAnnonce;

@RequestMapping("/Achat")
@RestController
public class AchatController {

	//AchatImpl achatService = new AchatImpl();
	@Autowired
	IAchat achatService;
	@Autowired
	IAnnonce announceService;

	@GetMapping("/retrieve-all-Announce-Asc")
	@ResponseBody
	List<Annonce> findAllOrderByAscPrice() {
		List<Annonce> list = achatService.retrieveAllAnnanceAscPrice();
		return list;
	}

	@GetMapping("/retrieve-all-Announce-Desc")
	@ResponseBody
	List<Annonce> findAllOrderByDescPrice() {
		List<Annonce> list = achatService.retrieveAllAnnanceDescPrice();
		return list;
	}

	@GetMapping("/retrieve-all-Announce-categorie/{categorie}")
	@ResponseBody
	List<Annonce> findAllByCategorieLike(@PathVariable("categorie") String categorie) {
		List<Annonce> list = achatService.retrieveAllAnnanceCategorie(categorie);
		return list;
	}

	@GetMapping("/retrieve-all-Announce-type/{type}")
	@ResponseBody
	List<Annonce> findAllByTypeLike(@PathVariable("type") String type) {
		List<Annonce> list = achatService.retrieveAllAnnanceType(type);
		return list;
	}

	@GetMapping("/retrieve-all-Announce-surface/{surfMin}/{surfMax}")
	@ResponseBody
	List<Annonce> findBySurfaceBetween(@PathVariable("surfMin") int surfMin, @PathVariable("surfMax") int surfMax) {
		List<Annonce> list = achatService.retrieveAllAnnanceSurface(surfMin, surfMax);
		return list;
	}

	@GetMapping("/retrieve-all-muebleAnnounce-region/{region}")
	@ResponseBody
	List<Annonce> findAllByRegionLike(@PathVariable("region") String region) {
		List<Annonce> list = achatService.retrieveAllAnnanceRegion(region);
		return list;
	}

	@GetMapping("/retrieve-all-muebleAnnounce-ville/{ville}")
	@ResponseBody
	List<Annonce> findAllByVilleLike(@PathVariable("ville") String ville) {
		List<Annonce> list = achatService.retrieveAllAnnanceVille(ville);
		return list;
	}

	@GetMapping("/retrieve-all-muebleAnnounce-nbre/{nbre}")
	@ResponseBody
	List<Annonce> findAllByNombreDeChambreLike(@PathVariable("nbre") int nbreChambre) {
		List<Annonce> list = achatService.retrieveAllAnnanceNombreDeChambre(nbreChambre);
		return list;
	}
	@GetMapping("/estimatedBien/{id}")
	@ResponseBody
	float estimationUnBien (@PathVariable("id")int idAnnounce) {
		Annonce annonce=announceService.retrieveAnnance(idAnnounce);
		return annonce.getSurface()*achatService.prixParMetre(annonce.getRegion());
	}
	
	@GetMapping("/dernierBienVendu")
	@ResponseBody
	Annonce DernierBienVendu () {
		return achatService.dernierBiensVendu();
	}
	@GetMapping("/prixParMetre")
	@ResponseBody
	float prixDeMetreParBien(@RequestBody Annonce annonce) {
		return achatService.prixParMetre(annonce.getRegion());
	}
	
	@PostMapping("/add-Recherche-user")
	@ResponseBody
	public void enregistrerRechercheUser(@RequestBody Recherche recherche) {
	achatService.saveSearchForUser(recherche.getCategorie(), recherche.getMinsurface(), recherche.getMaxsurface(), recherche.getRegion(), recherche.getMinPrice(), recherche.getMaxPrice(), recherche.getVille(), recherche.getNbrChambres(), recherche.getUser());	
	}
	@GetMapping("/retrieve-all-RechercheAnnounce-user")
	@ResponseBody
	List<Annonce> findAllAnnanceForSearch(@RequestBody User user){
		 return achatService.retrieveAllAnnanceForSearchPerUser(user);
	}
	
	@GetMapping("/tauxPerRegion")
	@ResponseBody
	Map<String,Float> retriveTauxPerRegion(){
		return achatService.tauxAchatPerRegion();
		
	}
	
	
	 
}
