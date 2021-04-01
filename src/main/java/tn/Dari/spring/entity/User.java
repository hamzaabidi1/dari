package tn.Dari.spring.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.HashSet;

import java.util.Set;


import javax.persistence.*;



import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long userId;
	private long cin;
	private String name;
	private String address;
	private String email;
	private String numTel;
	private String sex;
	private int codeVerif;
	@Column(columnDefinition = "integer default 0 not null")
	private int counterLogin;
	@Column(columnDefinition="tinyint(1) default 0 not null")
	private boolean desactivate;
	@Temporal(TemporalType.DATE)
	private Date lastLoginDate;
	@Temporal(TemporalType.DATE)
	private Date dateCreate;
	@Column(columnDefinition = "integer default 0 not null")
	private int point;
	private int lastyearaddpoint;
	private String password;
	private int age;
	@JsonIgnore
	private boolean isConnected;
	@JsonIgnore
	private boolean viewAd;
	private boolean Verified;
	public boolean isVerified() {
		return Verified;
	}








	public void setVerified(boolean verified) {
		Verified = verified;
	}




	@JsonIgnore
    private String resetToken;
	@ManyToMany(fetch = FetchType.LAZY,cascade= CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Roles> roles = new HashSet<>();
   

	
	
	
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
	
	


	
	
	

	public int getCounterLogin() {
		return counterLogin;
	}

	public void setCounterLogin(int counterLogin) {
		this.counterLogin = counterLogin;
	}

	public boolean isDesactivate() {
		return desactivate;
	}

	public void setDesactivate(boolean desactivate) {
		this.desactivate = desactivate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getLastyearaddpoint() {
		return lastyearaddpoint;
	}

	public void setLastyearaddpoint(int lastyearaddpoint) {
		this.lastyearaddpoint = lastyearaddpoint;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isConnected() {
		return isConnected;
	}

	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}

	public boolean isViewAd() {
		return viewAd;
	}

	public void setViewAd(boolean viewAd) {
		this.viewAd = viewAd;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCin() {
		return cin;
	}

	public void setCin(long cin) {
		this.cin = cin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Set<Reviews> getListeReviews() {
		return listeReviews;
	}

	public void setListeReviews(Set<Reviews> listeReviews) {
		this.listeReviews = listeReviews;
	}

	public User(long cin, String name, String address, String email, String numTel, int age) {
		super();
		this.cin = cin;
		this.name = name;
		this.address = address;
		this.email = email;
		this.numTel = numTel;
		this.age = age;
		

	}
	
	public User(String name2, String email2, String encode, String address2, int age2, long cin2, String numTel2 ) {
		this.name=name2;
		this.address=address2;
		this.age=age2;
		this.email=email2;
		this.numTel=numTel2;
		this.password=encode;
		this.cin=cin2;
		
	}

	public User(String name2, String email2, String encode) {
		// TODO Auto-generated constructor stub
	}
	

	public User(long userId, long cin,int codeVerif, String name, String address, String email, String numTel, String sex,
			String verificationCode, int counterLogin, boolean desactivate, Date lastLoginDate, Date dateCreate,
			int point, int lastyearaddpoint, String password, int age, boolean isConnected, boolean viewAd,
			String resetToken, Set<Roles> roles, Set<AnnanceMeuble> listeAnnanceMeuble, Set<Annonce> listeAnnance,
			Set<Abonnement> listeAbannement, Set<Reclamation> listeReclamation, Set<Recherche> listeRecherche,
			Set<Operation> listeOperation, Set<Message> listeMessage, Set<Reviews> listeReviews) {
		super();
		this.userId = userId;
		this.cin = cin;
		this.name = name;
		this.address = address;
		this.email = email;
		this.numTel = numTel;
		this.sex = sex;
		this.codeVerif = codeVerif;
		this.counterLogin = counterLogin;
		this.desactivate = desactivate;
		this.lastLoginDate = lastLoginDate;
		this.dateCreate = dateCreate;
		this.point = point;
		this.lastyearaddpoint = lastyearaddpoint;
		this.password = password;
		this.age = age;
		this.isConnected = isConnected;
		this.viewAd = viewAd;
		this.resetToken = resetToken;
		this.roles = roles;
		this.listeAnnanceMeuble = listeAnnanceMeuble;
		this.listeAnnance = listeAnnance;
		this.listeAbannement = listeAbannement;
		this.listeReclamation = listeReclamation;
		this.listeRecherche = listeRecherche;
		this.listeOperation = listeOperation;
		this.listeMessage = listeMessage;
		this.listeReviews = listeReviews;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", cin=" + cin + ", name=" + name + ", address=" + address + ", email="
				+ email + ", numTel=" + numTel + ", sex=" + sex + ", verificationCode=" + codeVerif
				+ ", counterLogin=" + counterLogin + ", desactivate=" + desactivate + ", lastLoginDate=" + lastLoginDate
				+ ", dateCreate=" + dateCreate + ", point=" + point + ", lastyearaddpoint=" + lastyearaddpoint
				+ ", password=" + password + ", age=" + age + ", isConnected=" + isConnected + ", viewAd=" + viewAd
				+ ", resetToken=" + resetToken + ", roles=" + roles + ", listeAnnanceMeuble=" + listeAnnanceMeuble
				+ ", listeAnnance=" + listeAnnance + ", listeAbannement=" + listeAbannement + ", listeReclamation="
				+ listeReclamation + ", listeRecherche=" + listeRecherche + ", listeOperation=" + listeOperation
				+ ", listeMessage=" + listeMessage + ", listeReviews=" + listeReviews + "]";
	}









	public int getCodeVerif() {
		return codeVerif;
	}








	public void setCodeVerif(int codeVerif) {
		this.codeVerif = codeVerif;
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


	

	public User(String name2, String email2, String encode, String address2, int age2, long cin2, String numTel2,
			String sex2) {
		// TODO Auto-generated constructor stub
	}








	
	
	
}
