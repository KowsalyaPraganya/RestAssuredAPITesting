package Practice;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class patchRequest {
@Test
public void patchRequest() {
	HashMap<String, Object> map = new HashMap<String, Object>();
	map.put("first_name", "Kowsalya");
	Response response = RestAssured.given()
	 // .header("x-api-key", "reqres_3625dc52793c46919fffc6303b69bb54")
      .headers(
              "x-api-key", "reqres_3625dc52793c46919fffc6303b69bb54",
              "Content-Type", "application/json"
          )
      .body(map)
      .when()
      .patch("https://reqres.in/api/users/1")
      .then()
      .statusCode(200)
      .extract().response();
	
	System.out.println(response.asString());
}
}
