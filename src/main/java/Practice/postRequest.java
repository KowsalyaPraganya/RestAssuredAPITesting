package Practice;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class postRequest {
 
	
@Test
public void postReq() {
	 HashMap<String, Object> map = new HashMap<String, Object>();

	 map.put("first_name", "Kowsalya");
	 map.put("last_name", "Pachamuthu");
	 map.put("email", "kowsiselvi32@gmail.com");
	 
	Response response = RestAssured.given()
			   .headers(
		                "x-api-key", "reqres_3625dc52793c46919fffc6303b69bb54",
		                "Content-Type", "application/json"
		            )
	 .body(map)
	 .when()
	 .post("https://reqres.in/api/users")
	 .then() 
	 .assertThat()
	 .statusCode(201)
	 .extract().response();
	System.out.println("response is "+response.asString());
	System.out.println("status Code is  "+response.statusCode());

}
}
