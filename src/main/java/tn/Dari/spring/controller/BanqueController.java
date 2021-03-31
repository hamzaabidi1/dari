package tn.Dari.spring.controller;
import java.util.List;

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

import tn.Dari.spring.entity.Banque;
import tn.Dari.spring.service.IBanque;
@RestController
@RequestMapping("/banque")
public class BanqueController {
	
	@Autowired
	IBanque banqueService;
	
	@GetMapping(value = "/retrieves-all-banque")
	@ResponseBody
	public List<Banque> getBanque() {
		List<Banque> list = banqueService.retreiveAllBanque();
		return list;
	}
	@PostMapping(value="save-Banque")
	public Banque saveBanque(@RequestBody Banque bnq) {
		
		banqueService.addBanque(bnq);
		return bnq;
	
	}
	@PutMapping("/update-BanqueTmm/{id}")
  	@ResponseBody
  	public ResponseEntity<String> updateTmmBanque(@RequestBody float tmm,@PathVariable("id")int id) {
		banqueService.editTmmBanque(id, tmm);
  		return new ResponseEntity<String>("Banque Tmm updated successfully",HttpStatus.OK);
  		
  	}
	@PutMapping("/update-BanquePourcentBenef/{id}")
  	@ResponseBody
  	public ResponseEntity<String> updatePourcentBenefBanque(@RequestBody float pourcentbenef,@PathVariable("id")int id) {
		banqueService.editPourcentageBenefBanque(id,pourcentbenef );
  		return new ResponseEntity<String>("Banque profit percentage updated successfully",HttpStatus.OK);
  		
  	}
	@PutMapping("/update-Banque/{id}")
  	@ResponseBody
  	public ResponseEntity<String> updateBanque(@RequestBody Banque bnq,@PathVariable("id")int id) {
		banqueService.updateBanque(bnq, id);
  		return new ResponseEntity<String>("Banque updated successfully",HttpStatus.OK);
  		
  	}
	
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deletePost(@PathVariable int id){
		
		banqueService.DeleteBanque(id);
		
		return new ResponseEntity<String>("Banque Deleted",HttpStatus.OK);
	} 
	
	@PutMapping("/valid-Banque/{id}")
  	@ResponseBody
  	public ResponseEntity<String> validBanque(@PathVariable("id")int id) {
		banqueService.validbanque(id);
  		return new ResponseEntity<String>("Banque valid successfully",HttpStatus.OK);
  		
  	}

}
