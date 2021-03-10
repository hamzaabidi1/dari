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

import tn.Dari.spring.entity.AnnanceMeuble;
import tn.Dari.spring.service.AnnonceMeubleImpl;
import tn.Dari.spring.service.IAnnonceMeuble;

@RequestMapping("/AnnonceMeuble")
@RestController
public class AnnonceMeubleController {

	
	//AnnonceMeubleImpl annonceMeuble = new AnnonceMeubleImpl();
	@Autowired
	IAnnonceMeuble annonceMeuble;

	@GetMapping("/retrieve-all-muebleAnnounce")
	@ResponseBody
	public List<AnnanceMeuble> getAllAnnanceMeuble() {
		List<AnnanceMeuble> list = annonceMeuble.retrieveAllAnnanceMeuble();
		return list;
	}

	@PostMapping("/add-muebleAnnounce")
	@ResponseBody
	public AnnanceMeuble ajouterAnnanceMeuble(@RequestBody AnnanceMeuble a) {
		AnnanceMeuble announce = annonceMeuble.addAnnanceMeuble(a);
		return announce;
	}

	@DeleteMapping("/remove-announceMeuble/{announceMeuble-id}")
	@ResponseBody
	public void effacerAnnanceMeuble(@PathVariable("announceMeuble-id") int id) {

		annonceMeuble.deleteAnnanceMeuble(id);
	}

	@PutMapping("/modify-announceMeuble")
	@ResponseBody
	public AnnanceMeuble modifierAnnanceMeuble(@RequestBody AnnanceMeuble a) {
		AnnanceMeuble announce = annonceMeuble.updateAnnanceMeuble(a);
		return announce;
	}

	@GetMapping("/retrieve-announceMeuble/{announceMeuble-id}")
	@ResponseBody
	public AnnanceMeuble getAnnanceMeuble(@PathVariable("announceMeubles-id") int id) {
		AnnanceMeuble announce = annonceMeuble.retrieveAnnanceMeuble(id);
		return announce;
	}

	@GetMapping("/retrieve-all-muebleAnnounce-price-Asc")
	@ResponseBody
	public List<AnnanceMeuble> getAllAnnanceMeubleAscPrice() {
		List<AnnanceMeuble> list = annonceMeuble.retrieveAllAnnanceMeubleAscPrice();
		return list;

	}

	@GetMapping("/retrieve-all-muebleAnnounce-price-Desc")
	@ResponseBody
	public List<AnnanceMeuble> getAllAnnanceMeubleDescPrice() {

		List<AnnanceMeuble> list = annonceMeuble.retrieveAllAnnanceMeubleDescPrice();
		return list;

	}

	@GetMapping("/retrieve-all-muebleAnnounce-adresse")
	@ResponseBody
	public List<AnnanceMeuble> getAllAnnanceMeubleAdresse(String adresse) {

		List<AnnanceMeuble> list = annonceMeuble.retrieveAllAnnanceMeubleAdresse(adresse);
		return list;

	}
	@GetMapping("/retrieve-all-muebleAnnounce-ville")
	@ResponseBody
	public List<AnnanceMeuble> getAllAnnanceMeubleVille(String vile) {

		List<AnnanceMeuble> list = annonceMeuble.retrieveAllAnnanceMeubleville(vile);
		return list;

	}
	@GetMapping("/retrieve-all-muebleAnnounce-region")
	@ResponseBody
	public List<AnnanceMeuble> getAllAnnanceMeubleRegion(String region) {

		List<AnnanceMeuble> list = annonceMeuble.retrieveAllAnnanceMeubleregion(region);
		return list;

	}

}
