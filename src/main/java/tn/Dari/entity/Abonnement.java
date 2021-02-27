package tn.Dari.entity;

public class Abonnement {
	private int id;
	private String nom;
	private Delais delais;
	private AbonnementType type;
	private String contrat;
	private User user;
	public Abonnement(int id, String nom, Delais delais, AbonnementType type, String contrat, User user) {
		super();
		this.id = id;
		this.nom = nom;
		this.delais = delais;
		this.type = type;
		this.contrat = contrat;
		this.user = user;
	}
	public Abonnement() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Delais getDelais() {
		return delais;
	}
	public void setDelais(Delais delais) {
		this.delais = delais;
	}
	public AbonnementType getType() {
		return type;
	}
	public void setType(AbonnementType type) {
		this.type = type;
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
	
	
	
	

}
