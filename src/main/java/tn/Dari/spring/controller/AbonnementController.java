package tn.Dari.spring.controller;
import java.util.List;
import java.util.Map;

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
import tn.Dari.spring.entity.AbonnementType;
import tn.Dari.spring.entity.User;
import tn.Dari.spring.service.IAbonnement;
import tn.Dari.spring.service.SMSService;



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
	public Abonnement ajouterAbonnement(@RequestBody Abonnement a ) {
     //SMSService.send("21573407","Votre abonnement est fait avec succée");
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
	@GetMapping("/retrieve-Abonnement-PerUser")
	@ResponseBody
	public List<Abonnement> findAbonnement(@RequestBody User user)  {
		return AbonnementService.retrieveAbonnementPerUser(user);
	}
	
	/*@GetMapping("/verifyAssurance")
	@ResponseBody
	public boolean VerifyAssurance (@RequestBody User user ) {
	List <Abonnement> ls= AbonnementService.retrieveAbonnementPerUser(user);
	if (ls.contains(AbonnementType.assurance))
	return true;
	return false; 
} */
	@GetMapping("/recherche-Abonnement/{Abonnement-nom}/{Abonnement-type}")
	@ResponseBody
	public int RechercheAbonnement(@PathVariable("Abonnement-nom") String nom, @PathVariable("Abonnement-type") AbonnementType type, @RequestBody User user) {
	return AbonnementService.findAbonnementByTypesAndName(nom,type,user);
}


	@GetMapping("/Taux-Abonnement")
	@ResponseBody
	Map<String, Float> RetrieveTauxAbonnement(){
	return AbonnementService.tauxAbonnement();
 
			}
	@GetMapping("/verifyAssurance/{id}")
	@ResponseBody
	public boolean VerifyAssurance (@PathVariable int id ) {
	 Abonnement ab= AbonnementService.retrieveAbonnement(id);
	if (ab.getType()==AbonnementType.assurance)
	return true;
	return false; 
	} 
}