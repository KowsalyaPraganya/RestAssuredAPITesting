package Practice;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ValidateResponse {
	//17.	How do you check if a response JSONPath returns a non-null value?
	@Test
	public void Validatingresponse() {
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
	        //Approach 1 to ensure its not null
	       .body("data[0].email", Matchers.notNullValue())
	       .extract().response();	
		System.out.println(response.asString());
		
		//Approach 2 to ensure its not null
		String email = response.jsonPath().getString("data[0].email");
		if(email != null)
		{
		    System.out.println("Email is not null");
		}
		
		
	}

}
