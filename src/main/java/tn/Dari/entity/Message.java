package tn.Dari.entity;


public class Message {
	private int id;
	private String text;
	private User sender;
	private User reciver;
	private Annonce annonce;
	
	public Message(int id, String text, User sender, Annonce annonce) {
		super();
		this.id = id;
		this.text = text;
		this.sender = sender;
		this.annonce = annonce;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	public User getReciver() {
		return reciver;
	}

	public void setReciver(User reciver) {
		this.reciver = reciver;
	}
	
	
	
	
	
	

}
