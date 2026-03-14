package Practice;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class AddHeader {
	//4.	Write code to add headers in a Rest Assured request.
	@Test
	public void AddingHeader() {
		      Response response =  RestAssured.given()
		        //.header("x-api-key", "reqres_3625dc52793c46919fffc6303b69bb54")
		        .headers(
		                "x-api-key", "reqres_3625dc52793c46919fffc6303b69bb54",
		                "Content-Type", "application/json"
		            )
		        .when()
		        .get("https://reqres.in/api/users/1"); 
             System.out.println(response.asString());
		    }
	}
  
  

