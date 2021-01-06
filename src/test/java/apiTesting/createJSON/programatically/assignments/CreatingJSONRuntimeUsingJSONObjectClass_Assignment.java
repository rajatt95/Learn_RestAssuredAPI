package apiTesting.createJSON.programatically.assignments;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import apiTesting.base.API_Testing_Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreatingJSONRuntimeUsingJSONObjectClass_Assignment extends API_Testing_Base {

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

		jsonObject.put("email", "shreya@gmail.com");
		jsonObject.put("firstName", "Shreya");
		jsonObject.put("lastName", "Khurana");
		jsonObject.put("mobile", getListOfMobileNumers_UsingJSONArray());
		jsonObject.put("address", getAddressDetails_UsingJSONObject());
		jsonObject.put("primarySkills", getListOfPrimarySkills_UsingJSONArray());
		jsonObject.put("secondarySkills", getListOfSecondarySkills_UsingJSONArray());
		jsonObject.put("education", getListOfMaps_ForCourses_UsingJSONArrayOfJSONObject());

		return jsonObject;
	}

	private static ArrayList<JSONObject> getListOfMaps_ForCourses_UsingJSONArrayOfJSONObject() {

		ArrayList<JSONObject> listOfCourses = new ArrayList<JSONObject>();

		JSONObject jsonObject_course_BTech = new JSONObject();
		jsonObject_course_BTech.put("course", "B.Tech");
		jsonObject_course_BTech.put("percentage", "70");

		JSONObject jsonObject_course_MTech = new JSONObject();
		jsonObject_course_MTech.put("course", "M.Tech");
		jsonObject_course_MTech.put("percentage", "75");

		HashMap<String, String> map_course_MTech = new HashMap<String, String>();
		map_course_MTech.put("course", "M.Tech");
		map_course_MTech.put("percentage", "75");

		listOfCourses.add(jsonObject_course_BTech);
		listOfCourses.add(jsonObject_course_MTech);

		return listOfCourses;

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

	private static JSONArray getListOfPrimarySkills_UsingJSONArray() {
		JSONArray listOfPrimarySkills = new JSONArray();
		listOfPrimarySkills.put("C++");
		listOfPrimarySkills.put("Java");
		listOfPrimarySkills.put("Python");
		listOfPrimarySkills.put("Ruby");

		return listOfPrimarySkills;
	}

	private static JSONArray getListOfSecondarySkills_UsingJSONArray() {
		JSONArray listOfSecondarySkills = new JSONArray();
		listOfSecondarySkills.put("Shell Scripting");
		listOfSecondarySkills.put("ML");
		listOfSecondarySkills.put("AI");
		return listOfSecondarySkills;
	}

}
