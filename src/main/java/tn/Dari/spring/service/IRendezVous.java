package tn.Dari.spring.service;

import java.util.List;

import tn.Dari.spring.entity.RendezVous;

public interface IRendezVous {
	public RendezVous addRendezVous(RendezVous appoint);
	public void updateRendezVous(RendezVous appoint ,int id);
	public void DeleteRendezVous(int id);
	public List<RendezVous> retreiveAllRendezVous() ;
	public void validRDV (int id, String message);
	public List<RendezVous> retrieveRDVRecByUser(int idusr);
	public List<RendezVous> retrieveRDVSentByUser(int iduser);
	public void rejectRDV (int id, String message);
}
