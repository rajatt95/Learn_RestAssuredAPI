package apiTesting.createJSON.programatically;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import apiTesting.base.API_Testing_Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PassComplexJSON_InBody_UsingHashMap extends API_Testing_Base {

	/* OR0003573506 */
	/**
	 * 1. How to pass complex JSON Object using HashMap
	 * 
	 * 
	 */

	public static void main(String[] args) {

		Response response = given().contentType(ContentType.JSON).body(getComplexJSON_ObjectUsingMap()).log().all()
				.post(URL_W2A);
		response.prettyPrint();
		System.out.println("================= Status code: " + response.statusCode());

	}

	private static HashMap<String, Object> getComplexJSON_ObjectUsingMap() {
		/*
		 * { "email":"rahul@gmail.com", "firstName":"Rahul", "lastName":"Arora",
		 * "mobile":[2323232,232322], "address":{ "flatNo":"A-131", "city":"New Delhi",
		 * "State":"Delhi", "country":"India" } }
		 */

		HashMap<String, Object> map = new HashMap();

		map.put("email", "rajatvermaa95@gmail.com");
		map.put("firstName", "Rajat");
		map.put("lastName", "Verma");
		map.put("mobile", getListOfMobileNumbers());
		map.put("address", getMapOfAddress());
		return map;
	}

	private static HashMap<String, String> getMapOfAddress() {

		HashMap<String, String> address = new HashMap<String, String>();
		address.put("flatNo", "563");
		address.put("city", "Hisar");
		address.put("state", "Haryana");
		address.put("country", "India");

		return address;
	}

	private static ArrayList<Integer> getListOfMobileNumbers() {
		ArrayList<Integer> listOfMobNumbers = new ArrayList<Integer>();
		listOfMobNumbers.add(9876543);
		listOfMobNumbers.add(6789543);

		return listOfMobNumbers;
	}
}
