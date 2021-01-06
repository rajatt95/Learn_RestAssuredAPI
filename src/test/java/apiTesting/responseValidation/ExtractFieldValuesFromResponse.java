package apiTesting.responseValidation;

import static io.restassured.RestAssured.given;

import apiTesting.base.API_Testing_Base;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ExtractFieldValuesFromResponse extends API_Testing_Base {

	/**
	 * 1. address - JSON Object
	 * 
	 * line1, postal_code, state - PArameters inside address
	 * 
	 * 2. preferred_locales - JSON Array
	 * 
	 */
	public static void main(String[] args) {

		Response response = given().auth().basic(API_KEY, "").formParam("name", "Shreya")
				.formParam("email", "shreya@gmail.com").formParam("description", "POST Request from Rest Assured API")
				.formParam("preferred_locales[0]", "Hindi").formParam("preferred_locales[1]", "English")
				.formParam("address[line1]", "563").formParam("address[city]", "Hisar")
				.formParam("address[postal_code]", "125001").formParam("address[state]", "Haryana").post(URL);

		response.prettyPrint();

		doValidationForResponse(response);

	}

	private static void doValidationForResponse(Response response) {
		JsonPath json = response.jsonPath();
		System.out.println("==========================================");
		System.out.println("ID: " + json.get("id"));
		System.out.println("-------Address: JSON Object--------");
		System.out.println("address: " + json.get("address"));
		System.out.println("address.line1: " + json.get("address.line1"));
		System.out.println("-------preferred_locales: JSON Array--------");
		System.out.println("preferred_locales: " + json.get("preferred_locales"));
		System.out.println("preferred_locales[0]: " + json.get("preferred_locales[0]"));

		getTheCountOfFieldsInResponse(json);

	}

	private static void getTheCountOfFieldsInResponse(JsonPath json) {
		System.out.println("-------Count of the fields in the response--------");
		System.out.println("Count of the fields in the reponse: " + json.getMap("$").size());

		System.out.println("-------Count of the fields in the address - JSON Object--------");
		System.out.println("Count of the fields in the address: " + json.getMap("address").size());
		System.out.println("address: " + json.get("address"));

		System.out.println("-------Count of the fields in the preferred_locales - JSON Array--------");
		System.out.println("Count of the fields in the preferred_locales: " + json.getList("preferred_locales").size());
		System.out.println("preferred_locales: " + json.get("preferred_locales"));
	}
}
