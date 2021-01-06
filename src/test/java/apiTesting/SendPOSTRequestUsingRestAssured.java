package apiTesting;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;

import apiTesting.base.API_Testing_Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SendPOSTRequestUsingRestAssured extends API_Testing_Base {

	/**
	 * 1. How to hit POST Request - Create a new Customer using Params
	 * 
	 * 2. Print the response data
	 * 
	 */
	public static void main1(String[] args) {

		Response response = given().auth().basic(API_KEY, "").formParam("name", "Shreya")
				.formParam("email", "shreya@gmail.com").formParam("description", "POST Request from Rest Assured API")
				.post(URL);

		response.prettyPrint();
	}

	/**
	 * 
	 * JSON String Data
	 * 
	 * 1. How to hit POST Request - Create a new Customer using Variable
	 * 
	 * 2. How to hit POST Request - Create a new Customer using Hashmap
	 * 
	 * 3. How to hit POST Request - Create a new Customer using external JSON file
	 */
	public static void main(String[] args) {

		// passJSONUsingVariable();

		// passJSONUsingHashMap();

		passJSONUsingExternalJSONFile();
	}

	private static void passJSONUsingExternalJSONFile() {

		// log().all() - will print everything attached to the Request
		Response response = given().contentType(ContentType.JSON).body(new File("./users.json")).log().all()
				.post("https://reqres.in/api/users");
		response.prettyPrint();

	}

	private static void passJSONUsingHashMap() {

		HashMap<String, String> map = new HashMap<String, String>();

		map.put("name", "morpheus");
		map.put("job", "leader");
		Response response = given().contentType(ContentType.JSON).body(map).post("https://reqres.in/api/users");
		response.prettyPrint();
	}

	private static void passJSONUsingVariable() {
		String bodyString = "{\"name\": \"morpheus\",\"job\": \"leader\"}";
		Response response = given().contentType(ContentType.JSON).body(bodyString).post("https://reqres.in/api/users");
		response.prettyPrint();
	}
}