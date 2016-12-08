package model;

public class User {
	String username, password, firstName, lastName, email;
	
	public User(String username, String password, String firstName, String lastName, String email) {
		this.username = username;
		this.password = password; //In a complete implementation the password would be hashed
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public boolean verifyPassword(String password) {
		return this.password.equals(password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		firstName = name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String name) {
		lastName = name;
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
