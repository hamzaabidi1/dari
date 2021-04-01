package tn.Dari.spring.entity;

public class taux {
	String Key;
	int value;
	
	
	
	public taux() {
		super();
	}
	public taux(String key, int value) {
		super();
		Key = key;
		this.value = value;
	}
	public String getKey() {
		return Key;
	}
	public void setKey(String key) {
		Key = key;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	

}
