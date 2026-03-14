package Practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class pagination {

	@Test
	public void handlePagination() {
		Response response = RestAssured
		.given()
		.queryParam("page", 1)
		.header("x-api-key", "reqres_3625dc52793c46919fffc6303b69bb54")
		.when()
		.get("https://reqres.in/api/users");
		System.out.println(response.asString());
	}
}
