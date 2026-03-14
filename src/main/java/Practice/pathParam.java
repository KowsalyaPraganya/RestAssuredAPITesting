package Practice;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class pathParam {
	//Used to pass variables inside URL.
	@Test
	public void pathParameters() {
	Response response = RestAssured.given()
	   .headers(
             "x-api-key", "reqres_3625dc52793c46919fffc6303b69bb54",
             "Content-Type", "application/json"
         )
	   .pathParam("id", 5)
     .when()
     .get("https://reqres.in/api/users/{id}")
     .then()
     .statusCode(200)
    .extract().response();	
	System.out.println(response.asString());
	}
}
