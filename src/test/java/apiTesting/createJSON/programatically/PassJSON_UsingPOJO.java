package apiTesting.createJSON.programatically;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import apiTesting.base.API_Testing_Base;
import apiTesting.pojo.Address;
import apiTesting.pojo.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PassJSON_UsingPOJO extends API_Testing_Base {

	/**
	 * 1. How to pass complex JSON Object using POJO
	 * 
	 * 
	 */

	public static void main(String[] args) {

		User user = new User("rajatvermaa95@gmail.com", "Rajat", "Verma", getListOfMobileNumbers(),
				getAddressDetails());

		Response response = given().contentType(ContentType.JSON).body(user).log().all().post(URL_W2A);
		response.prettyPrint();
		System.out.println("================= Status code: " + response.statusCode());
	}

	private static Address getAddressDetails() {
		Address address = new Address("563", "Hisar", "Haryana", "India");
		return address;
	}

	private static ArrayList<Integer> getListOfMobileNumbers() {
		ArrayList<Integer> listOfMobileNumbers = new ArrayList<Integer>();
		listOfMobileNumbers.add(987652);
		listOfMobileNumbers.add(230954);
		return listOfMobileNumbers;
	}
}