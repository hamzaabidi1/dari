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

import tn.Dari.spring.entity.Abonnement;
import tn.Dari.spring.service.IAbonnement;



@RequestMapping("/Abonnement")
@RestController
public class AbonnementController {
	@Autowired
	 IAbonnement  AbonnementService;
	@GetMapping("/retrieve-all-Abonnement")
	@ResponseBody
	public List<Abonnement> getAllAbonnement() {
		List<Abonnement> list = AbonnementService.retrieveAllAbonnement();
		return list;
	}
	@PostMapping("/add-Abonnement")
	@ResponseBody
	public Abonnement ajouterAbonnement(@RequestBody Abonnement a) {

		return AbonnementService.addAbonnement(a);
	}
	@DeleteMapping("/remove-Abonnement/{Abonnement-id}")
	@ResponseBody
	public void effacerAbonnement(@PathVariable("Abonnement-id") int id) {
		AbonnementService.deleteAbonnement(id);

	}
	@PutMapping("/modify-Abonnement")
	@ResponseBody
	public Abonnement modifierAbonnement(@RequestBody Abonnement a) {
		AbonnementService.updateAbonnement(a);
		return a;
	}
	@GetMapping("/retrieve-Abonnement/{Abonnement-id}")
	@ResponseBody
	public Abonnement getAbonnement(@PathVariable("Abonnement-id") int id) {
		return AbonnementService.retrieveAbonnement(id);
	}
	

}
