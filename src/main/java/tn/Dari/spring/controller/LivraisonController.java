package tn.Dari.spring.controller;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.Dari.spring.entity.Livraison;
import tn.Dari.spring.service.LivraisonImpl;

@RestController
public class LivraisonController {
	
	LivraisonImpl livraisonService= new LivraisonImpl();
	
	
	@GetMapping("/retrieve-all-Livraison")
	@ResponseBody
	public List<Livraison> getAllLivraison() {
		List<Livraison> list = livraisonService.retrieveAllLivraison();
		return list;
	}
	@PostMapping("/add-Livraison")
	@ResponseBody
	public Livraison ajouterLivraison(@RequestBody Livraison l) {

		return livraisonService.addLivraison(l);
	}
	@DeleteMapping("/remove-Livraison/{Livraison-id}")
	@ResponseBody
	public void effacerAnnanceMeuble(@PathVariable("Livraison-id") int id) {
		livraisonService.deleteLivraison(id);

	}
	@PutMapping("/modify-Livraison")
	@ResponseBody
	public Livraison modifierLivraison(@RequestBody Livraison l) {
		livraisonService.updateLivraison(l);
		return l;
	}
	@GetMapping("/retrieve-Livraison/{livraison-id}")
	@ResponseBody
	public Livraison getLivraison(@PathVariable("Livraison-id") int id) {
		return livraisonService.retrieveLivraison(id);
	}
	@GetMapping("/retrieve-all-Livraison-adresse/{adresse}")
	@ResponseBody
	public List<Livraison> getAllLivraisonAdresse(@PathVariable("adresse")String Adresse) {
		List<Livraison> list = livraisonService.retrieveAllLivraisonAdresse(Adresse);
		return list;

	}
	@GetMapping("/retrieve-all-Livraison-payement/{payement}")
	@ResponseBody
	public List<Livraison> getAllLivraisonPayement(@PathVariable("payement")String methode) {
		List<Livraison> list = livraisonService.retrieveAllLivraisonPayement(methode);
		return list;

	}
	@GetMapping("/retrieve-all-Livraison-status/{status}")
	@ResponseBody
	public List<Livraison> getAllLivraisonStatus(@PathVariable("status") String status) {
		List<Livraison> list = livraisonService.retrieveAllLivraisonStatus(status);
		return list;

	}
	@PutMapping("/modify-Livraison/{AnnounceMeuble-id}/{Livraison-id}")
	@ResponseBody
	public void ajoutMaubleToLivraison(@PathVariable("AnnounceMeuble-id")int idAnnoncemeuble,@PathVariable("Livraison-id") int idlivraison) {

		livraisonService.AddMaubleToLivraison(idAnnoncemeuble, idlivraison);

	}

}
