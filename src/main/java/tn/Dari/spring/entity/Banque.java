package tn.Dari.spring.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Banque {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id ;
private String titre ;
private String description;
private float tmm ;
private float pourcentageBinefice;
private boolean valid;
@JsonManagedReference
@OneToMany(cascade = CascadeType.ALL ,mappedBy="banque")
private Set<SimulateurCredit> listeSimulation = new HashSet<>();
@OneToOne
@JsonBackReference
private User user;

public Banque(int id, String titre, String description, float tmm, float pourcentageBinefice, boolean valid,
		User user) {
	super();
	this.id = id;
	this.titre = titre;
	this.description = description;
	this.tmm = tmm;
	this.pourcentageBinefice = pourcentageBinefice;
	this.valid = valid;
	this.user = user;
}

public Banque(int id, String titre, String description, float tmm, float pourcentageBinefice, boolean valid,
		Set<SimulateurCredit> listeSimulation, User user) {
	super();
	this.id = id;
	this.titre = titre;
	this.description = description;
	this.tmm = tmm;
	this.pourcentageBinefice = pourcentageBinefice;
	this.valid = valid;
	this.listeSimulation = listeSimulation;
	this.user = user;
}

public Banque() {
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public boolean isValid() {
	return valid;
}
public void setValid(boolean valid) {
	this.valid = valid;
}
public Set<SimulateurCredit> getListeSimulation() {
	return listeSimulation;
}
public void setListeSimulation(Set<SimulateurCredit> listeSimulation) {
	this.listeSimulation = listeSimulation;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

public float getPourcentageBinefice() {
	return pourcentageBinefice;
}

public void setPourcentageBinefice(float pourcentageBinefice) {
	this.pourcentageBinefice = pourcentageBinefice;
}


public float getTmm() {
	return tmm;
}

public void setTmm(float tmm) {
	this.tmm = tmm;
}

@Override
public String toString() {
	return "Banque [id=" + id + ", titre=" + titre + ", description=" + description + ", tmm=" + tmm
			+ ", pourcentageBinefice=" + pourcentageBinefice + ", valid=" + valid + ", user=" + user + "]";
}

}