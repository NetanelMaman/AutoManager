
public class User {

	private String ID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String password;
	
	public User(String ID, String firstName, String lastName, String phoneNumber,
													String email,String password) {
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}
	
	public boolean LoginUser() {
		return true;
	}
	
	public boolean AddVehicle(Vehicle v) {
		return true;
	}
	
	public boolean DeleteVehicle(Vehicle v) {
		return true;
	}
	
	public boolean AddDriver(Driver d) {
		return true;
	}
	
	public boolean DeleteDriver(Driver d) {
		return true;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
