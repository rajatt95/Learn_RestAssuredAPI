package apiTesting.createJSON.programatically;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;

import apiTesting.base.API_Testing_Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreatingJSONRuntimeUsingJSONObjectClass extends API_Testing_Base {

	/**
	 * 1. How to pass complex JSON Object using JSONObject class
	 * 
	 * MVN repo - <!--https://mvnrepository.com/artifact/org.json/json -->
	 * 
	 */

	public static void main(String[] args) {

		String jsonObjectInString = getJSONObject_UsingJSONObjectClass().toString();

		Response response = given().contentType(ContentType.JSON).body(jsonObjectInString).log().all().post(URL_W2A);
		response.prettyPrint();
		System.out.println("================= Status code: " + response.statusCode());

	}

	private static JSONObject getJSONObject_UsingJSONObjectClass() {
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("email", "rajatvermaa95@gmail.com");
		jsonObject.put("firstName", "Rajat");
		jsonObject.put("lastName", "Verma");
		jsonObject.put("mobile", getListOfMobileNumers_UsingJSONArray());
		jsonObject.put("address", getAddressDetails_UsingJSONObject());
		return jsonObject;
	}

	private static JSONObject getAddressDetails_UsingJSONObject() {
		JSONObject address = new JSONObject();
		address.put("flatNo", "563");
		address.put("city", "Hisar");
		address.put("state", "Haryana");
		address.put("country", "India");

		return address;
	}

	private static JSONArray getListOfMobileNumers_UsingJSONArray() {
		JSONArray listOfMobileNumbers = new JSONArray();
		listOfMobileNumbers.put(2323232);
		listOfMobileNumbers.put(232322);
		return listOfMobileNumbers;
	}
}
