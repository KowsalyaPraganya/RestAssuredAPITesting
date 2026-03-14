package api.endPoints;

import api.payload.UserPayload;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	public static Response createUser(UserPayload payload) {
		Response response = RestAssured.given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_url);
		return response;
	}
	

	
	public static Response GetUser(String UserName) {
		Response response = RestAssured.given()
		.accept(ContentType.JSON)
		.pathParam("username", UserName)
		.when()
		.get(Routes.get_url);
		return response;
	}
	
	public static Response UpdateUser(String UserName, UserPayload payload) {
		Response response = RestAssured.given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON) 
		.pathParam("username", UserName)
		.body(payload)
		.when()
		.put(Routes.put_url);
		return response;
	}
	
	public static Response DeleteUser(String UserName) {
		Response response = RestAssured.given()
		.pathParam("username", UserName)
		.when()
		.delete(Routes.delete_url);
		
		return response;
	}
}
