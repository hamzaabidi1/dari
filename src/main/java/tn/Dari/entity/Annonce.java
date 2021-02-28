package tn.Dari.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table
public class Annonce implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private String categorie;
	@Column
	private float prix;
	@Column
	private String photo;
	@Column
	private String adresse;
	@Column
	private Type type;
	@Column
	private String surface;
	@Column
	private String status;
	@Temporal (TemporalType.DATE)
	private Date date;
	@Column
	private int nbreChambre;
	@Column
	private String region;
	@Column
	private String ville;
	@ManyToOne
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="annonce")
	private List<RendezVous> rendezVous;
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="annonce")
	private Set<Message> Messages;
	
	@OneToMany
	private Set<Operation> operations;
	
	

	public Annonce(int id, String title, String description, String categorie, float prix, String photo, String adresse,
			Type type, String surface, String status, Date date, int nbreChambre, String region, String ville,
			User user, List<RendezVous> rendezVous, Set<Message> messages, Set<Operation> operations) {
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
		this.operations = operations;
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
