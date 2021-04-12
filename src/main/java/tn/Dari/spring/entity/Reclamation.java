package tn.Dari.spring.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Reclamation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	public Reclamation(String reponse, boolean repondu) {
		super();
		this.reponse = reponse;
		this.repondu = repondu;
	}
	private String subject;
	private String description;
	private String categorie;
	private String reponse;
	private boolean repondu;
	@ManyToOne
	@JsonBackReference
	private User user;
	@ManyToOne
	@JsonBackReference
	private Annonce annonce;
	
	
	public Reclamation(int id, String subject, String description, String categorie, String reponse, boolean repondu,
			User user, Annonce annonce) {
		super();
		this.id = id;
		this.subject = subject;
		this.description = description;
		this.categorie = categorie;
		this.reponse = reponse;
		this.repondu = repondu;
		this.user = user;
		this.annonce = annonce;
	}
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	public boolean isRepondu() {
		return repondu;
	}
	public void setRepondu(boolean repondu) {
		this.repondu = repondu;
	}
	public Reclamation() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Annonce getAnnonce() {
		return annonce;
	}
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", subject=" + subject + ", description=" + description + ", categorie="
				+ categorie + ", reponse=" + reponse + ", repondu=" + repondu + ", user=" + user + ", annonce="
				+ annonce + "]";
	}
	
	
	
}
