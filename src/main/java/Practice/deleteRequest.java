package Practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class deleteRequest {
	//11.	How do you send a DELETE request using Rest Assured?
	@Test
	public void deleteReq() {
		Response response = RestAssured.given()
		 .headers(
	                "x-api-key", "reqres_3625dc52793c46919fffc6303b69bb54",
	                "Content-Type", "application/json"
	             )
	        .when()
	        .delete("https://reqres.in/api/users/1")
	        .then()
	        .statusCode(204)
	        .statusLine("HTTP/1.1 204 No Content")
	        .log().all()
	        .extract().response();    
		String strResponse = response.asString();
		System.out.println("Delete Response : "+strResponse);  //empty
	
	}

}
