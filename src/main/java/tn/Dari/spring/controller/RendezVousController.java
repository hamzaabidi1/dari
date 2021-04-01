package tn.Dari.spring.controller;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.Dari.spring.entity.RendezVous;
import tn.Dari.spring.repository.RendezVousRepository;
import tn.Dari.spring.service.IRendezVous;
import tn.Dari.spring.service.SMSService;

@RestController
@RequestMapping("/RendezVous")
public class RendezVousController {
	@Autowired
	IRendezVous RendezVousService;
	@Autowired
	RendezVousRepository rvrep;
	@GetMapping(value = "/retrieves-all-RendezVous")
	@ResponseBody
	
	public List<RendezVous> getRendezVous() {
		List<RendezVous> list = RendezVousService.retreiveAllRendezVous();
		return list;
	}
	@PostMapping(value="/save-RendezVous")
	public RendezVous saveRendezVous(@RequestBody RendezVous rdv) {
		RendezVousService.addRendezVous(rdv);
		return rdv;
	
	}
	@PutMapping("/update-RendezVous/{id}")
  	@ResponseBody
  	public ResponseEntity<String> updateRendezVous(@RequestBody RendezVous rdv,@PathVariable("id")int id) {
		RendezVousService.updateRendezVous(rdv, id);
  		return new ResponseEntity<String>("RendezVous updated successfully"+rdv.toString(),HttpStatus.OK);
  		
  	}
	
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deletePost(@PathVariable int id){
		
		RendezVousService.DeleteRendezVous(id);
		
		return new ResponseEntity<String>("RendezVous Deleted",HttpStatus.OK);
	} 
	@PutMapping("/valid-RendezVous/{id}")
  	@ResponseBody
  	public ResponseEntity<String> validRendezVous(@PathVariable("id")int id,@RequestBody String message) {
		RendezVousService.validRDV(id,message);
		RendezVous rv= rvrep.findById(id).get();
		 SMSService.send("21573407","Votre rendez-vous est accepté pour l'annonce \n "+rv.getAnnonce());
  		return new ResponseEntity<String>("RendezVous valid successfully",HttpStatus.OK);
  		
  	}
	@PutMapping("/reject-RendezVous/{id}")
  	@ResponseBody
  	public ResponseEntity<String> rejectRendezVous(@PathVariable("id")int id,@RequestBody String message) {
		RendezVousService.rejectRDV(id,message);
		RendezVous rv= rvrep.findById(id).get();
		 SMSService.send("21573407","Votre rendez-vous est refusé pour l'annonce \n "+rv.getAnnonce());
  		return new ResponseEntity<String>("RendezVous not valid",HttpStatus.OK);
  		
  	}
	@GetMapping(value = "/retrieves-myrec-RendezVous/{id}")
	@ResponseBody
	
	public List<RendezVous> getMyRecRendezVous(@PathVariable("id")int iduser) {
		List<RendezVous> list = RendezVousService.retrieveRDVRecByUser(iduser);
		return list;
	}
	@GetMapping(value = "/retrieves-mysent-RendezVous/{id}")
	@ResponseBody
	
	public List<RendezVous> getMySentRendezVous(@PathVariable("id")int iduser) {
		List<RendezVous> list = RendezVousService.retrieveRDVSentByUser(iduser);
		return list;
	}
}
