package Practice;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class getRequest {
	public static void main(String[] args) {
		
		//1.	How do you send a GET request and validate the status code using Rest Assured?
		//Approach 1 : without BDD Style
		
		Response response  = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");
		System.out.println(response.asString());
		System.out.println(response.statusCode());
		System.out.println(response.contentType());
		System.out.println(response.headers());
		if(response.statusCode() == 200)
		{
			System.out.println("Status code is 200 and success");
		}
		else
		{
			System.out.println("Status code is not 200 and success");
		}
		
		
		getDetails();
	}
	
	//Approach 2 : With BDD Style. Here caller is mainmethod
	public static void getDetails(){
		RestAssured.given()
		.when()
		.get("https://jsonplaceholder.typicode.com/posts/1")
		.then()
		.statusCode(200);
	}
	
	//Approach 3 : With BDD Style. Here TestNG Annotation used, No main method
	@Test
	public static void getDeta(){
		System.out.println();
		Response response = RestAssured.given()
		.when()
		.get("https://jsonplaceholder.typicode.com/posts/1")
		.then()
		 .assertThat()
	     .statusCode(200)
	     .body("userId", Matchers.equalTo(1))
	     .body("userId", Matchers.greaterThan(0))
	     .header("Content-Type", Matchers.equalTo("application/json; charset=utf-8"))
	     .extract().response();
		
		System.out.println(response.asString());
	}
	
}
