package tn.Dari.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class RendezVous implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal (TemporalType.DATE)
	private Date dateRdv;
	private String message;
	@Enumerated(EnumType.STRING)
	private ValidationRdv validation;
	@ManyToOne
	private Annonce annonce;
	@ManyToOne
	private User user;
	
	public RendezVous(int id, Date dateRdv, ValidationRdv validation, Annonce annonce, User user) {
		super();
		this.id = id;
		this.dateRdv = dateRdv;
		this.validation = validation;
		this.annonce = annonce;
		this.user = user;
	}
	
	public RendezVous(int id, Date dateRdv, String message, ValidationRdv validation, Annonce annonce, User user) {
		super();
		this.id = id;
		this.dateRdv = dateRdv;
		this.message = message;
		this.validation = validation;
		this.annonce = annonce;
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RendezVous() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateRdv() {
		return dateRdv;
	}
	public void setDateRdv(Date dateRdv) {
		this.dateRdv = dateRdv;
	}
	public ValidationRdv getValidation() {
		return validation;
	}
	public void setValidation(ValidationRdv validation) {
		this.validation = validation;
	}
	public Annonce getAnnonce() {
		return annonce;
	}
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "RendezVous [id=" + id + ", dateRdv=" + dateRdv + ", message=" + message + ", validation=" + validation
				+ ", annonce=" + annonce + ", user=" + user + "]";
	}
	
	

}
