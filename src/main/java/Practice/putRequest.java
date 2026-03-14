package Practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class putRequest {
	
	@Test
	public void putRequest(){
		Response putResponse = RestAssured
		.given()
		.header("x-api-key", "reqres_3625dc52793c46919fffc6303b69bb54")
		.header("Content-Type", "application/json")
		.body("{\"email\" : \"kowsiselvi2@gmail.com\"}")
		.when()
		.put("https://reqres.in/api/users/2");
	
		System.out.println(putResponse.asString());
	                      Response getResponse = RestAssured
				               .given()
				           	.header("x-api-key", "reqres_3625dc52793c46919fffc6303b69bb54")
				           	.when()
				           	.get("https://reqres.in/api/users/2");
				           	
	                      System.out.println(getResponse.asString());
	}

}
