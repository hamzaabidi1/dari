package tn.Dari.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Livraison implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String adresse;
	private String tel;
	@Enumerated(EnumType.STRING)
	private MethodePayement methodePayement;
	@Enumerated(EnumType.STRING)
	private LivraisonStatus livraisonStatus;
	@JsonManagedReference
	@OneToMany(mappedBy = "livraison")
	private List<AnnanceMeuble> annonceMeuble;

	public Livraison(int id, String adresse, String tel, MethodePayement methodePayement,
			LivraisonStatus livraisonStatus, List<AnnanceMeuble> annonceMeuble) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.tel = tel;
		this.methodePayement = methodePayement;
		this.livraisonStatus = livraisonStatus;
		this.annonceMeuble = annonceMeuble;
	}

	public Livraison() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public MethodePayement getMethodePayement() {
		return methodePayement;
	}

	public void setMethodePayement(MethodePayement methodePayement) {
		this.methodePayement = methodePayement;
	}

	public LivraisonStatus getLivraisonStatus() {
		return livraisonStatus;
	}

	public void setLivraisonStatus(LivraisonStatus livraisonStatus) {
		this.livraisonStatus = livraisonStatus;
	}

	public List<AnnanceMeuble> getAnnonceMeuble() {
		return annonceMeuble;
	}

	public void setAnnonceMeuble(List<AnnanceMeuble> annonceMeuble) {
		this.annonceMeuble = annonceMeuble;
	}

	@Override
	public String toString() {
		return "Livraison [id=" + id + ", Adresse=" + adresse + ", tel=" + tel + ", methodePayement=" + methodePayement
				+ ", livraisonStatus=" + livraisonStatus + "]";
	}

}
