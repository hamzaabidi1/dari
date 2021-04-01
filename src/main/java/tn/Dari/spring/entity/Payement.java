package tn.Dari.spring.entity;

public class Payement {

	private int id;
	private String justification;

	public Payement(int id, String justification) {
		super();
		this.id = id;
		this.justification = justification;
	}

	public Payement() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

}
