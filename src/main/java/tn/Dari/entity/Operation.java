
package tn.Dari.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "operation")
public class Operation implements Serializable {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private Type operationType;
	private String garantie;
	private String identity;
	private String lettreEngagement;
	private int price;
	private String contrat;
	@ManyToOne
	private User user;
	@ManyToOne
	private Annonce annonce;
	
	public Operation(int id, Type operationType, String garantie, String identity, String lettreEngagement, int price,
			String contrat, User user, Annonce annonce) {
		super();
		this.id = id;
		this.operationType = operationType;
		this.garantie = garantie;
		this.identity = identity;
		this.lettreEngagement = lettreEngagement;
		this.price = price;
		this.contrat = contrat;
		this.user = user;
		this.annonce = annonce;
	}
	public Operation() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Type getOperationType() {
		return operationType;
	}
	public void setOperationType(Type operationType) {
		this.operationType = operationType;
	}
	public String getGarantie() {
		return garantie;
	}
	public void setGarantie(String garantie) {
		this.garantie = garantie;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getLettreEngagement() {
		return lettreEngagement;
	}
	public void setLettreEngagement(String lettreEngagement) {
		this.lettreEngagement = lettreEngagement;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getContrat() {
		return contrat;
	}
	public void setContrat(String contrat) {
		this.contrat = contrat;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Annonce getAnnonce() {
		return annonce;
	}
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	@Override
	public String toString() {
		return "Operation [id=" + id + ", operationType=" + operationType + ", garantie=" + garantie + ", identity="
				+ identity + ", lettreEngagement=" + lettreEngagement + ", price=" + price + ", contrat=" + contrat
				+ ", user=" + user + ", annonce=" + annonce + "]";
	}
	
	
	

}
