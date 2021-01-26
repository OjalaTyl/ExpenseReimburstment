package models;

public class User {
	private int id;
	private String name;
	private boolean manager;
	
	public User() {
		super();
	}
	
	public User(int id, String name, boolean manager) {
		this.id = id;
		this.name = name;
		this.manager = manager;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}
	
}
