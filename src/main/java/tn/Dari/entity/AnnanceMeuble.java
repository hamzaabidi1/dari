package tn.Dari.entity;

import java.util.List;

public class AnnanceMeuble {
	private int id;
	private String title;
	private String description;
	private String adresse;
	private List<String> images;
	private float prix;
	
	
	
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



	@Override
	public String toString() {
		return "AnnanceMeuble [id=" + id + ", title=" + title + ", description=" + description + ", adresse=" + adresse
				+ ", images=" + images + ", prix=" + prix + "]";
	}
	
	
	
	

}
