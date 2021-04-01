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
import tn.Dari.spring.entity.SimulateurCredit;
import tn.Dari.spring.entity.User;
import tn.Dari.spring.repository.BanqueRepository;
import tn.Dari.spring.repository.UserRepository;
import tn.Dari.spring.service.ISimulateurCredit;
import tn.Dari.spring.service.SMSService;

@RestController
@RequestMapping("/SimulateurCredit")
public class SimulateurCreditController {
	@Autowired
	ISimulateurCredit SimulateurCreditService;
	@Autowired
	UserRepository userrep;
	@Autowired
	BanqueRepository banquerep;
	
	@GetMapping(value = "/retrieves-all-SimulateurCredit")
	@ResponseBody
	public List<SimulateurCredit> getSimulateurCredit() {
		List<SimulateurCredit> list = SimulateurCreditService.retrieveAllSimulateurCredit();
		return list;
	}
	@GetMapping(value = "/retrieves-all-SimulateurCredit-byuser{id}")
	@ResponseBody
	public List<SimulateurCredit> getSimulateurCreditByUser(@PathVariable("id")int id) {
		List<SimulateurCredit> list = SimulateurCreditService.retrieveSimulateurCreditByUser(id);
		return list;
	}
	@GetMapping(value = "/retrieves-all-SimulateurCredit-byuserbanque/{id}/{idbnq}")
	@ResponseBody
	public List<SimulateurCredit> getSimulateurCreditByUserBanque(@PathVariable("id")int id,@PathVariable("idbnq")int idbnq) {
		List<SimulateurCredit> list = SimulateurCreditService.retrieveSimulateurCreditByUserBanque(id, idbnq);
		return list;
	}
	@PostMapping(value="save-SimulateurCredit")
	public SimulateurCredit saveSimulateurCredit(@RequestBody SimulateurCredit sc) {
		Banque bnq=sc.getBanque();
		float tmm=bnq.getTmm();
		float pb= bnq.getPourcentageBinefice();
		float revenu=sc.getRevenuAnnuel();
		float annuel = sc.getSalaireBrut()*12;
		if(revenu>annuel) {
			float mnt= (float) (((((revenu*tmm/100)+(revenu*pb/100)+revenu)/12)*sc.getDuree())*0.4);
			sc.setMontant(mnt);
		}
		else {
			float mnt= (float) (((((annuel*tmm/100)+(annuel*pb/100)+annuel)/12)*sc.getDuree())*0.4);
			sc.setMontant(mnt);
		}
		SimulateurCreditService.addSimulateurCredit(sc);
		 SMSService.send("21573407","Banque: "+sc.getBanque().getTitre()+" RevenuAnnuel: "+sc.getRevenuAnnuel()+" salaire: "+sc.getSalaireBrut()+" montant: " +sc.getMontant());
		 //SMSService.send(sc.getUser().getPhone(),"RevenuAnnuel: "+sc.getRevenuAnnuel()+"salaire: "+sc.getSalaireBrut()+"montant: " +sc.getMontant());
		return sc;
	
	}
	@PutMapping("/update-SimulateurCredit/{id}")
  	@ResponseBody
  	public ResponseEntity<String> updateSimulateurCredit(@RequestBody SimulateurCredit sc,@PathVariable("id")int id) {
		SimulateurCreditService.updateSimulateurCredit(sc,id);
  		return new ResponseEntity<String>("SimulateurCredit updated successfully",HttpStatus.OK);
  		
  	}
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deletePost(@PathVariable int id){
		
		SimulateurCreditService.DeleteSimulateurCredit(id);
		
		return new ResponseEntity<String>("SimulateurCredit Deleted",HttpStatus.OK);
	} 
}
