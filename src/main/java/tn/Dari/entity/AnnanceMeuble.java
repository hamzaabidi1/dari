package tn.Dari.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table
public class AnnanceMeuble implements Serializable {
	
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
	private String adresse;
	@Column
	private List<String> images;
	@Column
	private float prix;	
	@ManyToOne
	private User user;
	@OneToOne(mappedBy="annonceMeuble")
	private Livraison livraison;
	
	
	
	public AnnanceMeuble() {
		super();
	}



	public AnnanceMeuble(int id, String title, String description, String adresse, List<String> images, float prix) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.adresse = adresse;
		this.images = images;
		this.prix = prix;
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



	@Override
	public String toString() {
		return "AnnanceMeuble [id=" + id + ", title=" + title + ", description=" + description + ", adresse=" + adresse
				+ ", images=" + images + ", prix=" + prix + "]";
	}
	
	
	
	

}
