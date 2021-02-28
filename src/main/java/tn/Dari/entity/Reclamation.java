package tn.Dari.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "reclamation")
public class Reclamation implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String subject;
	private String description;
	private String categorie;
	@ManyToOne
	private User user;
	@ManyToOne
	private Annonce annonce;
	
	public Reclamation(int id, String subject, String description, String categorie, User user, Annonce annonce) {
		super();
		this.id = id;
		this.subject = subject;
		this.description = description;
		this.categorie = categorie;
		this.user = user;
		this.annonce = annonce;
	}
	public Reclamation() {
		super();
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
				+ categorie + "]";
	}
	
	
}
