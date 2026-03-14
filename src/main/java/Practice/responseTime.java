package Practice;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class responseTime {
   @Test
   public void responseTime()
   {
	   RestAssured.given()
	   .queryParam("page", 2)
	   .header("x-api-key", "reqres_3625dc52793c46919fffc6303b69bb54")
	   .when()
	   .get("https://reqres.in/api/users")
	   .then()
	   .time(Matchers.lessThan(2000L));
   }
}
