package tn.Dari.entity;

import java.util.Date;
import java.util.List;

public class Annonce {
	private int id;
	private String title;
	private String description;
	private String categorie;
	private float prix;
	private String photo;
	private String adresse;
	private Type type;
	private String surface;
	private String status;
	private Date date;
	private int nbreChambre;
	private String region;
	private String ville;
	private User user;
	private List<RendezVous> rendezVous;
	private List<Message> Messages;
	
	
	public Annonce(int id, String title, String description, String categorie, float prix, String photo, String adresse,
			Type type, String surface, String status, Date date, int nbreChambre, String region, String ville,
			User user, List<RendezVous> rendezVous, List<Message> messages) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.categorie = categorie;
		this.prix = prix;
		this.photo = photo;
		this.adresse = adresse;
		this.type = type;
		this.surface = surface;
		this.status = status;
		this.date = date;
		this.nbreChambre = nbreChambre;
		this.region = region;
		this.ville = ville;
		this.user = user;
		this.rendezVous = rendezVous;
		Messages = messages;
	}
	public Annonce() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNbreChambre() {
		return nbreChambre;
	}
	public void setNbreChambre(int nbreChambre) {
		this.nbreChambre = nbreChambre;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<RendezVous> getRendezVous() {
		return rendezVous;
	}
	public void setRendezVous(List<RendezVous> rendezVous) {
		this.rendezVous = rendezVous;
	}
	
	public List<Message> getMessages() {
		return Messages;
	}
	public void setMessages(List<Message> messages) {
		Messages = messages;
	}
	@Override
	public String toString() {
		return "Annonce [id=" + id + ", title=" + title + ", description=" + description + ", categorie=" + categorie
				+ ", prix=" + prix + ", photo=" + photo + ", adresse=" + adresse + ", type=" + type + ", surface="
				+ surface + ", status=" + status + ", date=" + date + ", nbreChambre=" + nbreChambre + ", region="
				+ region + ", ville=" + ville + "]";
	}
	
	

}
