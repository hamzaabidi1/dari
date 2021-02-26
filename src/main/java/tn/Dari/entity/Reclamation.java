package tn.Dari.entity;

public class Reclamation {
	private int id;
	private String subject;
	private String description;
	private String categorie;
	public Reclamation(int id, String subject, String description, String categorie) {
		super();
		this.id = id;
		this.subject = subject;
		this.description = description;
		this.categorie = categorie;
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
	@Override
	public String toString() {
		return "Reclamation [id=" + id + ", subject=" + subject + ", description=" + description + ", categorie="
				+ categorie + "]";
	}
	
	
}
