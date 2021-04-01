package tn.Dari.spring.service;

import java.util.List;

import tn.Dari.spring.entity.Banque;

public interface IBanque {
	public Banque addBanque(Banque bnq);
	public void updateBanque(Banque bnq ,int id);
	public void DeleteBanque(int id);
	public List<Banque> retreiveAllBanque() ;
	public void validbanque(int id);
	public void editTmmBanque(int id, float tmm);
	public void editPourcentageBenefBanque(int id, float prcbnfice);
}
