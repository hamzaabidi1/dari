package tn.Dari.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.Dari.spring.entity.Annonce;
import tn.Dari.spring.service.IAnnonce;



@RequestMapping("/Annonce")
@RestController
public class AnnonceController {
	
//AnnonceImpl annonceService = new AnnonceImpl();
	
	@Autowired
	IAnnonce annonceService;
	
	@GetMapping("/retrieve-all-announces")
	@ResponseBody
	public List<Annonce> getAllAnnonce() {
		List<Annonce> list = annonceService.retrieveAllAnnance();
		return list;
	}

	@PostMapping("/add-Announce")
	@ResponseBody
	public Annonce ajouterAnnonce(@RequestBody Annonce a) {
		Annonce announce = annonceService.addAnnance(a);
		return announce;
	}

	@DeleteMapping("/remove-announce/{announce-id}")
	@ResponseBody
	public void effacerAnnance(@PathVariable("announce-id") int id) {

		annonceService.deleteAnnance(id);
	}

	@PutMapping("/modify-announce")
	@ResponseBody
	public Annonce modifierAnnance(@RequestBody Annonce a) {
		Annonce announce = annonceService.updateAnnance(a);
		return announce;
	}

	@GetMapping("/retrieve-announcee/{announce-id}")
	@ResponseBody
	public Annonce getAnnonce(@PathVariable("announce-id") int id) {
		Annonce announce = annonceService.retrieveAnnance(id);
		return announce;
	}

	@GetMapping("/retrieve-all-Announces-price-Asc")
	@ResponseBody
	public List<Annonce> getAllAnnanceMeubleAscPrice() {
		List<Annonce> list = annonceService.retrieveAllAnnanceAscPrice();
		return list;

	}

	@GetMapping("/retrieve-all-Announces-price-Desc")
	@ResponseBody
	public List<Annonce> getAllAnnonceDescPrice() {

		List<Annonce> list = annonceService.retrieveAllAnnanceDescPrice();
		return list;

	}

	@GetMapping("/retrieve-Announces-adresse/{adresse}")
	@ResponseBody
	public List<Annonce> getAllAnnanceAdresse(@PathVariable("adresse")String adresse) {

		List<Annonce> list = annonceService.retrieveAllAnnanceAdresse(adresse);
		return list;

	}
	@GetMapping("/retrieve-Announces-ville/{ville}")
	@ResponseBody
	public List<Annonce> getAllAnnanceVille(@PathVariable("ville")String vile) {
		List<Annonce> list = annonceService.retrieveAllAnnanceville(vile);
		return list;

	}
	@GetMapping("/retrieve-all-Announces-region/{region}")
	@ResponseBody
	public List<Annonce> getAllAnnanceRegion(@PathVariable("region")String region)  {

		List<Annonce> list = annonceService.retrieveAllAnnanceregion(region);
		return list;

	}

}



