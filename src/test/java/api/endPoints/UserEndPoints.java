package api.endPoints;

import java.util.ResourceBundle;

import api.payload.UserPayload;
import api.utilities.ReadConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static ResourceBundle resourceBundle = ResourceBundle.getBundle("Routes");
	public static Response createUser(UserPayload payload) {
		String post_url = resourceBundle.getString("post_url");
		Response response = RestAssured.given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		.when()
		.post(post_url);
		return response;
	}

	public static Response GetUser(String UserName) {
		String get_url = resourceBundle.getString("get_url");
		Response response = RestAssured.given()
		.accept(ContentType.JSON)
		.pathParam("username", UserName)
		.when()
		.get(get_url);
		return response;
	}
	
	public static Response UpdateUser(String UserName, UserPayload payload) {
		String put_url = resourceBundle.getString("put_url");
		Response response = RestAssured.given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON) 
		.pathParam("username", UserName)
		.body(payload)
		.when()
		.put(put_url);
		return response;
	}
	
	public static Response DeleteUser(String UserName) {
		String delete_url = resourceBundle.getString("delete_url");
		Response response = RestAssured.given()
		.pathParam("username", UserName)
		.when()
		.delete(delete_url);
		
		return response;
	}
}
