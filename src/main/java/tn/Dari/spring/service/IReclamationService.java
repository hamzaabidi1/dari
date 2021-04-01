package tn.Dari.spring.service;

import java.util.List;
import java.util.Map;

import tn.Dari.spring.entity.Reclamation;
import tn.Dari.spring.entity.User;

public interface IReclamationService {
	public Reclamation addReclamation(Reclamation rec);
	public void updateReclamation(Reclamation rec ,int id);
	public void DeleteReclamation(int id);

	public List<Reclamation> retreiveAllReclamation();
	
	public void addReponse(Reclamation rep , int id);
	public  Map<User,Integer> nombreR();
	//void Repondre(Reclamation rec, int id);
	//void respondtoreclamation(Long id);
	void update(Reclamation rec, int id);
	//public void respondtoreclamation(long parseLong, String string);
	//void respondtoreclamation(Long id, String reponse);
	void setrespondtoreclamation(int id, String reponse);
	
	
	
	

}
