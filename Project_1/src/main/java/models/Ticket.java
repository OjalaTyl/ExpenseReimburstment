package models;

public class Ticket {
	private int reimburstment_ticket_id;
	private int reimburstment_user_id;
	private String username;
	private double amount;
	private String description;
	private int reimburstment_type;
	private int approved;
	
	public Ticket() {
		super();
	}
	
	public Ticket(int reimburstment_ticket_id, int reimburstment_user_id, String username, double amount, String description, int reimburstment_type, int approved) {
		this.reimburstment_ticket_id = reimburstment_ticket_id;
		this.reimburstment_user_id = reimburstment_user_id;
		this.username = username;
		this.amount = amount;
		this.description = description;
		this.reimburstment_type = reimburstment_type;
		this.approved = approved;
	}

	public Ticket(int reimburstment_user_id, String username, double amount, String description, int reimburstment_type, int approved) {
		this.reimburstment_user_id = reimburstment_user_id;
		this.username = username;
		this.amount = amount;
		this.description = description;
		this.reimburstment_type = reimburstment_type;
		this.approved = approved;
	}
	
	public Ticket(int reimburstment_user_id, int approved) {
		this.reimburstment_user_id = reimburstment_user_id;
		this.approved = approved;
	}
	
	public Ticket(double amount, String description, int reimburstment_type) {
		this.amount = amount;
		this.description = description;
		this.reimburstment_type = reimburstment_type;
	}
	
	public int getReimburstment_ticket_id() {
		return reimburstment_ticket_id;
	}

	public void setReimburstment_ticket_id(int reimburstment_ticket_id) {
		this.reimburstment_ticket_id = reimburstment_ticket_id;
	}

	public int getReimburstment_user_id() {
		return reimburstment_user_id;
	}

	public void setReimburstment_user_id(int reimburstment_user_id) {
		this.reimburstment_user_id = reimburstment_user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReimburstment_type() {
		return reimburstment_type;
	}

	public void setReimburstment_type(int reimburstment_type) {
		this.reimburstment_type = reimburstment_type;
	}

	public int getApproved() {
		return approved;
	}

	public void setApproved(int approved) {
		this.approved = approved;
	}
}
