package tn.Dari.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int Id;
	private String firstName;
	private String lastName;
	private String pseudo;
	private String password;	
	@Transient
	private String confirmedPassword;
	private String email;
	private String phone;
	@Temporal (TemporalType.DATE)
	private Date birthDate;
	private String adress;
	private String codePostal;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Enumerated(EnumType.STRING)
	private Role role;
	@Enumerated(EnumType.STRING)
	private Status status;
	private String image;
	@OneToMany(mappedBy="user")
	private List<RendezVous> listeRendezVous = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="user")
	private Set<AnnanceMeuble> listeAnnanceMeuble= new HashSet<>();;
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="user")
	private Set<Annonce> listeAnnance = new HashSet<>();;
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="user")
	private Set<Abonnement> listeAbannement = new HashSet<>();;
	@OneToMany(mappedBy="user")
	private Set<Reclamation> listeReclamation = new HashSet<>();;
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="user")
	private Set<Recherche> listeRecherche = new HashSet<>();;
	@OneToMany(mappedBy="user")
	private Set<Operation> listeOperation = new HashSet<>();;
	@OneToMany(mappedBy="sender")
	private Set<Message> listeMessage = new HashSet<>();;
	@OneToMany(cascade = CascadeType.ALL ,mappedBy="userReviwer")
	private Set<Reviews> listeReviews = new HashSet<>();;
	
	
	
	public User() {
		super();
	}
	
	public User(String pseudo, String password, String email) {
		super();
		this.pseudo = pseudo;
		this.password = password;
		this.email = email;
	}


	public User(int id, String firstName, String lastName, String pseudo, String password, String confirmedPassword,
			String email, String phone, Date birthDate, String adress, String codePostal, Gender gender, Role role,
			Status status, String image, List<RendezVous> listeRendezVous, Set<AnnanceMeuble> listeAnnanceMeuble,
			Set<Annonce> listeAnnance, Set<Abonnement> listeAbannement) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pseudo = pseudo;
		this.password = password;
		this.confirmedPassword = confirmedPassword;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
		this.adress = adress;
		this.codePostal = codePostal;
		this.gender = gender;
		this.role = role;
		this.status = status;
		this.image = image;
		this.listeRendezVous = listeRendezVous;
		this.listeAnnanceMeuble = listeAnnanceMeuble;
		this.listeAnnance = listeAnnance;
		this.listeAbannement = listeAbannement;
	}

	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmedPassword() {
		return confirmedPassword;
	}


	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	

	public List<RendezVous> getListeRendezVous() {
		return listeRendezVous;
	}

	public void setListeRendezVous(List<RendezVous> listeRendezVous) {
		this.listeRendezVous = listeRendezVous;
	}
	
	

	public Set<AnnanceMeuble> getListeAnnanceMeuble() {
		return listeAnnanceMeuble;
	}

	public void setListeAnnanceMeuble(Set<AnnanceMeuble> listeAnnanceMeuble) {
		this.listeAnnanceMeuble = listeAnnanceMeuble;
	}
	
	

	public Set<Annonce> getListeAnnance() {
		return listeAnnance;
	}

	public void setListeAnnance(Set<Annonce> listeAnnance) {
		this.listeAnnance = listeAnnance;
	}
	
	

	public Set<Abonnement> getListeAbannement() {
		return listeAbannement;
	}

	public void setListeAbannement(Set<Abonnement> listeAbannement) {
		this.listeAbannement = listeAbannement;
	}
	
	

	public Set<Reclamation> getListeReclamation() {
		return listeReclamation;
	}

	public void setListeReclamation(Set<Reclamation> listeReclamation) {
		this.listeReclamation = listeReclamation;
	}
	
	

	public Set<Recherche> getListeRecherche() {
		return listeRecherche;
	}

	public void setListeRecherche(Set<Recherche> listeRecherche) {
		this.listeRecherche = listeRecherche;
	}
	
	

	public Set<Operation> getListeOperation() {
		return listeOperation;
	}

	public void setListeOperation(Set<Operation> listeOperation) {
		this.listeOperation = listeOperation;
	}
	
	

	public Set<Message> getListeMessage() {
		return listeMessage;
	}

	public void setListeMessage(Set<Message> listeMessage) {
		this.listeMessage = listeMessage;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", pseudo=" + pseudo
				+ ", password=" + password + ", confirmedPassword=" + confirmedPassword + ", email=" + email
				+ ", phone=" + phone + ", birthDate=" + birthDate + ", adress=" + adress + ", codePostal=" + codePostal
				+ ", gender=" + gender + ", role=" + role + ", status=" + status + "]";
	}
	
	
	
	
	
	
	
}
