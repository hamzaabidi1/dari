package tn.Dari.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table
public class Reviews implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idr;
	@Column
	private int note1;
	@Column
	private int note2;
	@Column
	private int note3;
	@Column
	private int note4;
	@Column
	private int note5;
	@Column
	private int note6;
	@Column
	private String commentaire;
    @ManyToOne
	private User userReviwer ;
    @ManyToOne
	private Annonce annonce;
	
	
	


	public Reviews(int idr, int note1, int note2, int note3, int note4, int note5, int note6, User userReviwer,
			 Annonce annonce) {
		super();
		this.idr = idr;
		this.note1 = note1;
		this.note2 = note2;
		this.note3 = note3;
		this.note4 = note4;
		this.note5 = note5;
		this.note6 = note6;
		this.userReviwer = userReviwer;
		this.annonce = annonce;
	}


	public Reviews() {
		super();
	}


	public int getIdr() {
		return idr;
	}


	public void setIdr(int idr) {
		this.idr = idr;
	}


	public int getNote1() {
		return note1;
	}


	public void setNote1(int note1) {
		this.note1 = note1;
	}


	public int getNote2() {
		return note2;
	}


	public void setNote2(int note2) {
		this.note2 = note2;
	}


	public int getNote3() {
		return note3;
	}


	public void setNote3(int note3) {
		this.note3 = note3;
	}


	public int getNote4() {
		return note4;
	}


	public void setNote4(int note4) {
		this.note4 = note4;
	}


	public int getNote5() {
		return note5;
	}


	public void setNote5(int note5) {
		this.note5 = note5;
	}


	public int getNote6() {
		return note6;
	}


	public void setNote6(int note6) {
		this.note6 = note6;
	}
	
	


	public User getUserReviwer() {
		return userReviwer;
	}


	public void setUserReviwer(User userReviwer) {
		this.userReviwer = userReviwer;
	}





	public Annonce getAnnonce() {
		return annonce;
	}


	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}


	@Override
	public String toString() {
		return "Reviews [idr=" + idr + ", note1=" + note1 + ", note2=" + note2 + ", note3=" + note3 + ", note4=" + note4
				+ ", note5=" + note5 + ", note6=" + note6 + "]";
	}
	
	
	
	
	
	
	

}
