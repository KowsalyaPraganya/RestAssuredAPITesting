package Practice;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class jsonArraySize {
@Test
public void verifyJsonArraySize() {
 RestAssured
 .given()
 .queryParam("page", 2)
  .header("x-api-key", "reqres_3625dc52793c46919fffc6303b69bb54")
 .when()
 .get("https://reqres.in/api/users")
 .then()
 //.body("data", Matchers.hasSize(3)) //If the array name is Animals then we should use that name instead of data.
 .body("data.size()", Matchers.greaterThan(5)) 
 .time(Matchers.greaterThan(1000L));
 } 
}
