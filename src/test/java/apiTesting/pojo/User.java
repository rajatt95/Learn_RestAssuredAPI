package apiTesting.pojo;

import java.util.ArrayList;

public class User {

	private String email;
	private String firstName;
	private String lastName;
	private ArrayList<Integer> mobile;
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User(String email, String firstName, String lastName, ArrayList<Integer> mobile, Address address) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.address = address;
	}

	public ArrayList<Integer> getMobile() {
		return mobile;
	}
	

	public void setMobile(ArrayList<Integer> mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}
