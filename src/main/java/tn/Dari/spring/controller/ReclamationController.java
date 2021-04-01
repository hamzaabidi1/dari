package tn.Dari.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.Dari.spring.SecurityConfiguration.SharedLogg;
import tn.Dari.spring.SecurityConfiguration.UserDetailsImpl;
import tn.Dari.spring.entity.Reclamation;
import tn.Dari.spring.entity.User;
import tn.Dari.spring.repository.UserRepository;
import tn.Dari.spring.service.IReclamationService;

@RestController
@RequestMapping("/reclamation")
public class ReclamationController {
	
	@Autowired
	IReclamationService reclamationservice;
	@Autowired
	UserRepository userRepositiry;
	
	@GetMapping(value = "/retrieves-all-reclamation")
	//@PreAuthorize("hasRole('ADMIN')")
	@ResponseBody
	public List<Reclamation> getAllReclmation( ) {
		List<Reclamation> list = reclamationservice.retreiveAllReclamation();
		//UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		//SharedLogg.addlog("user", "insert",userDetails);	
		return list ;	
	}
	@GetMapping(value = "/retrieves-all-reclamationNull")
	@ResponseBody
	public List<Reclamation> getAllReclmationNull() {
		List<Reclamation> list = reclamationservice.retreiveAllReclamation();
		List<Reclamation> listresult = new ArrayList<>();
		for(Reclamation r:list) {
			if (r.getReponse()== null)
			{
				listresult.add(r);
			}
		}
		return listresult ;	
	}
		@PostMapping(value="save-reclamation")
	public Reclamation saveRecalamtion(@RequestBody Reclamation rec) {
		reclamationservice.addReclamation(rec);
		return rec;
	
	}
	
	@PutMapping("repondre/{id}/{reponse}")
  	@ResponseBody
  	public String respondtoreclamation(@PathVariable("id") String id ,@PathVariable("reponse") String reponse) {
		reclamationservice.setrespondtoreclamation(Integer.parseInt(id),reponse);
  		return "Done";
  		
  	}
	@PutMapping("update-reclamation/{id}")
  	@ResponseBody
  	public ResponseEntity<String> updatereclamation(@RequestBody Reclamation rec,@PathVariable("id")int id) {
		reclamationservice.updateReclamation(rec, id);
  		return new ResponseEntity<String>("Reclamation updated successfully",HttpStatus.OK);
  		
  	}
	
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deletePost(@PathVariable int id){
		
		reclamationservice.DeleteReclamation(id);
		
		return new ResponseEntity<String>("reclamation supprime",HttpStatus.OK);
	} 
	
	@DeleteMapping(value = "/delete")
	public void deleteUser(){
		
		 Map<User,Integer> nbr=reclamationservice.nombreR();
		for (int u : nbr.values())
		{ if( u > 5)
		userRepositiry.delete((User)nbr.keySet());}

		
		//return new ResponseEntity<String>("reclamation supprime",HttpStatus.OK);
	} 
}

