package tn.Dari.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class AnnanceMeuble implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private String region;
	private String ville;
	private String adresse;
	@ElementCollection
	private List<String> images = new ArrayList<>();
	private float prix;
	@ManyToOne
	@JsonBackReference
	private User user;
	@ManyToOne
	@JsonBackReference
	private Livraison livraison;

	public AnnanceMeuble() {
		super();
	}

	public AnnanceMeuble(int id, String title, String description, String region, String ville, String adresse,
			List<String> images, float prix, User user, Livraison livraison) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.region = region;
		this.ville = ville;
		this.adresse = adresse;
		this.images = images;
		this.prix = prix;
		this.user = user;
		this.livraison = livraison;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Livraison getLivraison() {
		return livraison;
	}

	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}

	@Override
	public String toString() {
		return "AnnanceMeuble [id=" + id + ", title=" + title + ", description=" + description + ", adresse=" + adresse
				+ ", images=" + images + ", prix=" + prix + "]";
	}

}
