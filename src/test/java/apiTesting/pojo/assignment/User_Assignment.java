package apiTesting.pojo.assignment;

import java.util.ArrayList;

public class User_Assignment {

	private String email;
	private String firstName;
	private String lastName;
	private ArrayList<Integer> mobile;
	private Address_Assignment address;
	private ArrayList<String> primarySkills;
	private ArrayList<String> secondarySkills;
	private ArrayList<Education_Assignment> education;

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

	public ArrayList<Integer> getMobile() {
		return mobile;
	}

	public void setMobile(ArrayList<Integer> mobile) {
		this.mobile = mobile;
	}

	public Address_Assignment getAddress() {
		return address;
	}

	public void setAddress(Address_Assignment address) {
		this.address = address;
	}

	public ArrayList<String> getPrimarySkills() {
		return primarySkills;
	}

	public void setPrimarySkills(ArrayList<String> primarySkills) {
		this.primarySkills = primarySkills;
	}

	public ArrayList<String> getSecondarySkills() {
		return secondarySkills;
	}

	public void setSecondarySkills(ArrayList<String> secondarySkills) {
		this.secondarySkills = secondarySkills;
	}

	public ArrayList<Education_Assignment> getEducation() {
		return education;
	}

	public void setEducation(ArrayList<Education_Assignment> education) {
		this.education = education;
	}

	public User_Assignment(String email, String firstName, String lastName, ArrayList<Integer> mobile,
			Address_Assignment address, ArrayList<String> primarySkills, ArrayList<String> secondarySkills,
			ArrayList<Education_Assignment> education) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.address = address;
		this.primarySkills = primarySkills;
		this.secondarySkills = secondarySkills;
		this.education = education;
	}

}
