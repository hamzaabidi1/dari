package tn.Dari.entity;

import java.util.Date;

public class User {

	private int Id;
	private String firstName;
	private String lastName;
	private String pseudo;
	private String password;
	private String confirmedPassword;
	private String email;
	private String phone;
	private Date birthDate;
	private String adress;
	private String codePostal;
	private Gender gender;
	private Role role;
	private Status status;
	private String image;
	
	
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
			Status status, String image) {
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

	@Override
	public String toString() {
		return "User [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", pseudo=" + pseudo
				+ ", password=" + password + ", confirmedPassword=" + confirmedPassword + ", email=" + email
				+ ", phone=" + phone + ", birthDate=" + birthDate + ", adress=" + adress + ", codePostal=" + codePostal
				+ ", gender=" + gender + ", role=" + role + ", status=" + status + "]";
	}
	
	
	
	
	
	
	
}
