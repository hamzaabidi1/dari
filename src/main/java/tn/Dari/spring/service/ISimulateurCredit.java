package tn.Dari.spring.service;

import java.util.List;

import tn.Dari.spring.entity.SimulateurCredit;

public interface ISimulateurCredit {

	public SimulateurCredit addSimulateurCredit(SimulateurCredit SC);
	public void updateSimulateurCredit(SimulateurCredit SC ,int id);
	public void DeleteSimulateurCredit(int id);
	public List<SimulateurCredit> retrieveAllSimulateurCredit() ;
	public List<SimulateurCredit> retrieveSimulateurCreditByUser(int iduser) ;
	public List<SimulateurCredit> retrieveSimulateurCreditByUserBanque(int iduser,int idbnq) ;

	
}
