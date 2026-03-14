package Practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BasicAuthentication {
  //14.	How do you handle Basic Authentication in an API request using Rest Assured?
	@Test
	public void basicAuth() {
		RestAssured.given()
		.auth().basic("user", "pass")
		.when()
		.get("https://httpbin.org/basic-auth/user/pass")
		.then()
		.statusCode(200);
	}
}
