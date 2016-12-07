package model;

public class User {
	String username, password, name, email;
	
	public User(String username, String password, String name, String email) {
		this.username = username;
		this.password = password; //In a complete implementation the password would be hashed
		this.name = name;
		this.email = email;
	}
	
	public boolean verifyPassword(String password) {
		return this.password == password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/** Checks for equality with usernames OR emails, as both of these things should be unique to a User
	 */
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof User)) {
			return false;
		}
		User u = (User) o;
		if(username.equals(u.getUsername()) || email.equals(u.getEmail())) {
			return true;
		}
		return false;
	}
}
