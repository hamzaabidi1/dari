package tn.Dari.spring.entity;

public class SimulateurCredit {
	
	private int id;
	private int age;
	private final float tmm =6.15F;
	private float pourcentageBinefice;
	private float montant;
	private float salaireBrut;
	private float revenuAnnuel;
	
	public SimulateurCredit(int id, int age, float pourcentageBinefice, float montant, float salaireBrut,
			float revenuAnnuel) {
		super();
		this.id = id;
		this.age = age;
		this.pourcentageBinefice = pourcentageBinefice;
		this.montant = montant;
		this.salaireBrut = salaireBrut;
		this.revenuAnnuel = revenuAnnuel;
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
		this.age = age;
	}
	public float getPourcentageBinefice() {
		return pourcentageBinefice;
	}
	public void setPourcentageBinefice(float pourcentageBinefice) {
		this.pourcentageBinefice = pourcentageBinefice;
	}
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
	public float getTmm() {
		return tmm;
	}
	@Override
	public String toString() {
		return "SimulateurCredit [id=" + id + ", age=" + age + ", tmm=" + tmm + ", pourcentageBinefice="
				+ pourcentageBinefice + ", montant=" + montant + ", salaireBrut=" + salaireBrut + ", revenuAnnuel="
				+ revenuAnnuel + "]";
	}
	
	
	

}
