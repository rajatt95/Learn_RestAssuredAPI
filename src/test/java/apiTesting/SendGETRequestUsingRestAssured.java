package apiTesting;

import static io.restassured.RestAssured.given;

import apiTesting.base.API_Testing_Base;
import io.restassured.response.Response;

/*import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
*/
public class SendGETRequestUsingRestAssured extends API_Testing_Base {

	/*
	 * Set Authentication - Basic Auth / Bearer token using Headers
	 * 
	 * Send Req -> set of request specifications - given()
	 * 
	 * Get response -> Do validation
	 * 
	 * Content-type -> 1. using contentType() 2. adding the content type in the
	 * headers
	 * 
	 */

	/**
	 * 1. How to set content type and how to use API Key using BASIC Authentication
	 * 
	 * 2. How to hit GET Request - GET all Customers
	 * 
	 * 3. How to hit GET Request and limit - GET all Customers but in limit
	 * 
	 * 4. How to get response code
	 */

	public static void main(String[] args) {

		// setContentType();
		Response response = given().auth().basic(API_KEY, "").get(URL);
		printResponse(response);

		// Response response_With_QueryParameter_limit = given().param("limit",
		// 1).auth().basic(API_KEY, "").get(URL);

		// All customers will be listed having "rajatvermaa95@gmail.com" as their Email
		Response response_With_QueryParameter_limit = given().auth().basic(API_KEY, "").formParam("limit", 2)
				.formParam("email", "rajatvermaa95@gmail.com").get(URL);
		printResponse(response_With_QueryParameter_limit);

		getResponseStatusCode(response);
		// getResponseStatusCode(response_With_QueryParameter_limit);
	}

	/**
	 * 1. How to use API key by HEADER AUTHORIZATION
	 * 
	 * 2. How to hit GET Request - GET particular Customer using ID
	 * 
	 * 
	 */
	public static void main1(String[] args) {

		Response response = given().header(HEADER_AUTHORIZATION_TYPE, BEARER + API_KEY).get(URL + Customer_Rajat_ID);
		response.prettyPrint();
	}

	private static void getResponseStatusCode(Response response) {
		System.out.println("Response Status code: " + response.getStatusCode());
	}

	private static void printResponse(Response response) {
		// response.prettyPrint();
		String jsonResponse = response.asString();
		System.out.println(jsonResponse);
	}

	private static void setContentType() {
		// given().contentType(ContentType.JSON);
		// given().contentType("application/json");
		// given().header("content-type","application/json");
	}

}
