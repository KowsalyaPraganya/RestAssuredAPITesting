package Practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ExtractDataFromJsonResponse {

	//10.	Write code to extract specific data from a JSON response using Rest Assured.
	@Test
	public void extractData() {
		Response response = RestAssured.given()
		  .headers(
	                "x-api-key", "reqres_3625dc52793c46919fffc6303b69bb54",
	                "Content-Type", "application/json"
	            )
	        .when()
	        .get("https://reqres.in/api/users")
	        .then()
	        .statusCode(200)
	        .assertThat()
	        .contentType("application/json")
	        .body("RestResponse.", null)
	        .extract().response();
		System.out.println(response.asString());
		
		String emailId = response.jsonPath().getString("data[0].email");
		System.out.println(emailId);
		
		String totalElements = response.jsonPath().getString("total");
		System.out.println(totalElements);
		
		
		
		
		
	}
}
