package tn.Dari.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Annonce implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private String categorie;
	private float prix;
	@ElementCollection
	private List<String> photo = new ArrayList<>();
	private String adresse;
	@Enumerated(EnumType.STRING)
	private Type type;
	private int surface;
	@Enumerated(EnumType.STRING)
	private Status status;
	@Temporal (TemporalType.DATE)
	private Date date;
	private int nbreChambre;
	private String region;
	private String ville;
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="annonce")
	private List<RendezVous> rendezVous = new ArrayList<>();
	@OneToMany(mappedBy="annonce")
	private Set<Message> Messages = new HashSet<>();;	
	@OneToMany(mappedBy="annonce")
	private Set<Operation> operations = new HashSet<>();;
	@OneToMany(mappedBy="annonce")
	private Set<Reviews> reviews = new HashSet<>();;
	@OneToMany(mappedBy="annonce")
	private Set<Reclamation> reclamations= new HashSet<>();;
	
	
	

	
	public Annonce(int id, String title, String description, String categorie, float prix, List<String> photo,
			String adresse, Type type, int surface, Status status, Date date, int nbreChambre, String region,
			String ville) {
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

	public List<String> getPhoto() {
		return photo;
	}
	public void setPhoto(List<String> photo) {
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
	public int getSurface() {
		return surface;
	}
	public void setSurface(int surface) {
		this.surface = surface;
	}

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
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
		
	public Set<Message> getMessages() {
		return Messages;
	}
	public void setMessages(Set<Message> messages) {
		Messages = messages;
	}
	public Set<Operation> getOperations() {
		return operations;
	}
	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
	@Override
	public String toString() {
		return "Annonce [id=" + id + ", title=" + title + ", description=" + description + ", categorie=" + categorie
				+ ", prix=" + prix + ", photo=" + photo + ", adresse=" + adresse + ", type=" + type + ", surface="
				+ surface + ", status=" + status + ", date=" + date + ", nbreChambre=" + nbreChambre + ", region="
				+ region + ", ville=" + ville + "]";
	}
	
	

}
