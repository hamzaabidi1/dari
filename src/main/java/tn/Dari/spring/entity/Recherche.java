package tn.Dari.spring.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Recherche implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String region;
	private String ville;
	private String categorie;
	private float minPrice;
	private float maxPrice;
	private int minsurface;
	private int maxsurface;
	private int nbrChambres;
	private String gamme;
	@Enumerated(EnumType.STRING)
	private Status statut;
	@ManyToOne
 //   @JsonBackReference
	private User user;

	public Recherche() {
		super();
	}

	public Recherche(int id, String region, String ville, float minPrice, float maxPrice, int nbrChambres, String gamme,
			Status statut) {
		super();
		Id = id;
		this.region = region;
		this.ville = ville;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.nbrChambres = nbrChambres;
		this.gamme = gamme;
		this.statut = statut;
	}
	

	

	public Recherche(String region, String ville, String categorie, float minPrice, float maxPrice, int minsurface,
			int maxsurface, int nbrChambres, User user) {
		super();
		this.region = region;
		this.ville = ville;
		this.categorie = categorie;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.minsurface = minsurface;
		this.maxsurface = maxsurface;
		this.nbrChambres = nbrChambres;
		this.user = user;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public float getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}

	public float getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getNbrChambres() {
		return nbrChambres;
	}

	public void setNbrChambres(int nbrChambres) {
		this.nbrChambres = nbrChambres;
	}

	public String getGamme() {
		return gamme;
	}

	public void setGamme(String gamme) {
		this.gamme = gamme;
	}

	public Status getStatut() {
		return statut;
	}

	public void setStatut(Status statut) {
		this.statut = statut;
	}
	
	

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getMinsurface() {
		return minsurface;
	}

	public void setMinsurface(int minsurface) {
		this.minsurface = minsurface;
	}

	public int getMaxsurface() {
		return maxsurface;
	}

	public void setMaxsurface(int maxsurface) {
		this.maxsurface = maxsurface;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Recherche [Id=" + Id + ", region=" + region + ", ville=" + ville + ", minPrice=" + minPrice
				+ ", maxPrice=" + maxPrice + ", nbrChambres=" + nbrChambres + ", gamme=" + gamme + ", statut=" + statut
				+ "]";
	}

}
