package tn.Dari.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SimulateurCredit {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int age;
	private float montant;
	private float salaireBrut;
	private float revenuAnnuel;
	private int duree;
	@ManyToOne
	private User user;
	@ManyToOne
	private Banque banque;
	
	
	public SimulateurCredit(int id, int age, float montant, float salaireBrut, float revenuAnnuel,int duree, User user,
			Banque banque) {
		super();
		this.id = id;
		this.age = age;
		this.montant = montant;
		this.salaireBrut = salaireBrut;
		this.revenuAnnuel = revenuAnnuel;
		this.duree = duree;
		this.user = user;
		this.banque = banque;
	}
	
	public SimulateurCredit(int id, int age, float salaireBrut, float revenuAnnuel,int duree, User user, Banque banque) {
		super();
		this.id = id;
		this.age = age;
		this.salaireBrut = salaireBrut;
		this.revenuAnnuel = revenuAnnuel;
		this.duree = duree;
		this.user = user;
		this.banque = banque;
	}
	public SimulateurCredit(int age, float salaireBrut, float revenuAnnuel,int duree, User user, Banque banque) {
		this.age = age;
		this.salaireBrut = salaireBrut;
		this.revenuAnnuel = revenuAnnuel;
		this.duree = duree;
		this.user = user;
		this.banque = banque;
	}

	public SimulateurCredit() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;}
	
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public float getSalaireBrut() {
		return salaireBrut;
	}
	public void setSalaireBrut(float salaireBrut) {
		this.salaireBrut = salaireBrut;
	}
	public float getRevenuAnnuel() {
		return revenuAnnuel;
	}
	public void setRevenuAnnuel(float revenuAnnuel) {
		this.revenuAnnuel = revenuAnnuel;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	@Override
	public String toString() {
		return "SimulateurCredit [id=" + id + ", age=" + age + ", montant=" + montant + ", salaireBrut=" + salaireBrut
				+ ", revenuAnnuel=" + revenuAnnuel + ", duree=" + duree + ", user=" + user + ", banque=" + banque + "]";
	}


	
	
	

}
