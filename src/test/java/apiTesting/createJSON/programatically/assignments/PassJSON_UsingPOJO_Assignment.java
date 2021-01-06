package apiTesting.createJSON.programatically.assignments;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import apiTesting.base.API_Testing_Base;
import apiTesting.pojo.assignment.Address_Assignment;
import apiTesting.pojo.assignment.Education_Assignment;
import apiTesting.pojo.assignment.User_Assignment;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PassJSON_UsingPOJO_Assignment extends API_Testing_Base {

	/**
	 * 1. How to pass complex JSON Object using POJO
	 * 
	 * 
	 */

	public static void main(String[] args) {

		User_Assignment user_Assignment = new User_Assignment("rajatvermaa95@gmail.com", "Rajat", "Verma",
				getListOfMobileNumbers(), getAddressDetails(), getListOfPrimarySkills(), getListOfSecondarySkills(),
				getListOfEducationDetails());

		Response response = given().contentType(ContentType.JSON).body(user_Assignment).log().all().post(URL_W2A);
		response.prettyPrint();
		System.out.println("================= Status code: " + response.statusCode());
	}

	private static Address_Assignment getAddressDetails() {
		Address_Assignment address_Assignment = new Address_Assignment("563", "Hisar", "Haryana", "India");
		return address_Assignment;
	}

	private static ArrayList<String> getListOfSecondarySkills() {
		ArrayList<String> listOfSecondarySkills = new ArrayList<String>();
		listOfSecondarySkills.add("Shell Scripting");
		listOfSecondarySkills.add("ML");
		listOfSecondarySkills.add("AI");
		return listOfSecondarySkills;
	}

	private static ArrayList<String> getListOfPrimarySkills() {
		ArrayList<String> listOfPrimarySkills = new ArrayList<String>();
		listOfPrimarySkills.add("C++");
		listOfPrimarySkills.add("Java");
		listOfPrimarySkills.add("Python");
		listOfPrimarySkills.add("Ruby");

		return listOfPrimarySkills;
	}

	private static ArrayList<Integer> getListOfMobileNumbers() {
		ArrayList<Integer> listOfMobileNumbers = new ArrayList<Integer>();
		listOfMobileNumbers.add(987652);
		listOfMobileNumbers.add(230954);
		return listOfMobileNumbers;
	}

	private static ArrayList<Education_Assignment> getListOfEducationDetails() {

		Education_Assignment education_course_bTech = new Education_Assignment("B.Tech", "70");
		Education_Assignment education_course_mTech = new Education_Assignment("M.Tech", "75");

		ArrayList<Education_Assignment> listOfEducationCourses = new ArrayList<Education_Assignment>();
		listOfEducationCourses.add(education_course_bTech);
		listOfEducationCourses.add(education_course_mTech);
		return listOfEducationCourses;
	}
}