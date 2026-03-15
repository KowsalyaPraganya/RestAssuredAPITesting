package api.endPoints;

import api.payload.UserPayload;
import api.utilities.ReadConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints_oldd {
	public static Response createUser(UserPayload payload) {
		
		Response response = RestAssured.given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		.when()
		.post(ReadConfig.get_postURL());
		return response;
	}
	

	
	public static Response GetUser(String UserName) {
		Response response = RestAssured.given()
		.accept(ContentType.JSON)
		.pathParam("username", UserName)
		.when()
		.get(ReadConfig.get_getURL());
		return response;
	}
	
	public static Response UpdateUser(String UserName, UserPayload payload) {
		Response response = RestAssured.given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON) 
		.pathParam("username", UserName)
		.body(payload)
		.when()
		.put(ReadConfig.get_putURL());
		return response;
	}
	
	public static Response DeleteUser(String UserName) {
		Response response = RestAssured.given()
		.pathParam("username", UserName)
		.when()
		.delete(ReadConfig.get_deleteURL());
		
		return response;
	}
}
