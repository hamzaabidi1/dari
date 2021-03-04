package tn.Dari.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
public class Livraison implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String Adresse;
	private String tel; 
	@Enumerated(EnumType.STRING)
	private MethodePayement methodePayement;
	@Enumerated(EnumType.STRING)
	private LivraisonStatus livraisonStatus;	
	@OneToMany(mappedBy="livraison")
	private List<AnnanceMeuble> annonceMeuble;
	
	


	public Livraison(int id, String adresse, String tel, MethodePayement methodePayement,
			LivraisonStatus livraisonStatus, List<AnnanceMeuble> annonceMeuble) {
		super();
		this.id = id;
		Adresse = adresse;
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
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
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
		return "Livraison [id=" + id + ", Adresse=" + Adresse + ", tel=" + tel + ", methodePayement=" + methodePayement
				+ ", livraisonStatus=" + livraisonStatus + "]";
	}
	
	
	
	

}
