package Practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ValidateHeader {
@Test
public void validateHeader() {
	Response response =  RestAssured.given()
	        .header("x-api-key", "reqres_3625dc52793c46919fffc6303b69bb54")
	        .when()
	        .get("https://reqres.in/api/users")
	        .then()
	        .header("Content-Type", "application/json; charset=utf-8")
	        .header("Server", "cloudflare")
	       .log().all()
	        .extract().response();
	System.out.println("Response is : "+response.asString());
  }
}
