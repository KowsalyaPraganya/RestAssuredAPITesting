package Practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class queryParam {
	//13.	How do you handle query parameters in Rest Assured?
	//16.	How do you add multiple query parameters in a single request?
	@Test
	public void quryParamAndqueryParams() {
		Response response = RestAssured.given()
		  .headers(
	                "x-api-key", "reqres_3625dc52793c46919fffc6303b69bb54",
	                "Content-Type", "application/json"
	            )
//		  .queryParam("page", 2)
//		  .queryParam("per_page", 3)
		  .queryParams("page", 2, "per_page", 3)  //  https://reqres.in/api/users?page=2&per_page=3
		  .when()
		  .get("https://reqres.in/api/users");
	    System.out.println(response.asString());	
	}

}
