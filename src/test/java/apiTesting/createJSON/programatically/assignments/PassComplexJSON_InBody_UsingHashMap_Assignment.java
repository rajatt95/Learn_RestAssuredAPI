package apiTesting.createJSON.programatically.assignments;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import apiTesting.base.API_Testing_Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PassComplexJSON_InBody_UsingHashMap_Assignment extends API_Testing_Base {

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

		/**
		 * Refer newUser_Assignment.json file for Object
		 */
		HashMap<String, Object> map = new HashMap();

		map.put("email", "shreya@gmail.com");
		map.put("firstName", "shreya");
		map.put("lastName", "Kuhrana");
		map.put("mobile", getListOfMobileNumbers_JSONArray());
		map.put("address", getMapOfAddress_JSONObject());
		map.put("primarySkills", getListOfPrimarySkills_JSONArray());
		map.put("secondarySkills", getListOfSecondarySkills_JSONArray());
		map.put("education", getListOfMaps_ForCourses_JSONArrayOfJSONObject());

		return map;
	}

	private static HashMap<String, String> getMapOfAddress_JSONObject() {

		HashMap<String, String> address = new HashMap<String, String>();
		address.put("flatNo", "563");
		address.put("city", "Hisar");
		address.put("state", "Haryana");
		address.put("country", "India");

		return address;
	}

	private static List<HashMap<String, String>> getListOfMaps_ForCourses_JSONArrayOfJSONObject() {

		ArrayList<HashMap<String, String>> listOfCourses = new ArrayList<HashMap<String, String>>();

		HashMap<String, String> map_course_BTech = new HashMap<String, String>();
		map_course_BTech.put("course", "B.Tech");
		map_course_BTech.put("percentage", "70");

		HashMap<String, String> map_course_MTech = new HashMap<String, String>();
		map_course_MTech.put("course", "M.Tech");
		map_course_MTech.put("percentage", "75");

		listOfCourses.add(map_course_BTech);
		listOfCourses.add(map_course_MTech);

		return listOfCourses;

	}

	private static ArrayList<Integer> getListOfMobileNumbers_JSONArray() {
		ArrayList<Integer> listOfMobNumbers = new ArrayList<Integer>();
		listOfMobNumbers.add(9876543);
		listOfMobNumbers.add(6789543);

		return listOfMobNumbers;
	}

	private static ArrayList<String> getListOfPrimarySkills_JSONArray() {
		ArrayList<String> listOfPrimarySkills = new ArrayList<String>();
		listOfPrimarySkills.add("C++");
		listOfPrimarySkills.add("Java");
		listOfPrimarySkills.add("Python");
		listOfPrimarySkills.add("Ruby");

		return listOfPrimarySkills;
	}

	private static ArrayList<String> getListOfSecondarySkills_JSONArray() {
		ArrayList<String> listOfSecondarySkills = new ArrayList<String>();
		listOfSecondarySkills.add("Shell Scripting");
		listOfSecondarySkills.add("ML");
		listOfSecondarySkills.add("AI");
		return listOfSecondarySkills;
	}
}
