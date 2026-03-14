package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endPoints.UserEndPoints;
import api.payload.UserPayload;
import io.restassured.response.Response;

public class UserTest {

    Faker faker;
    UserPayload userPayloadObj;

    @BeforeClass
    public void generateTestData() {
        faker = new Faker();
        userPayloadObj = new UserPayload();
        userPayloadObj.setId(faker.idNumber().hashCode());
        userPayloadObj.setUsername(faker.name().username());
        userPayloadObj.setFirstName(faker.name().firstName());
        userPayloadObj.setLastName(faker.name().lastName());
        userPayloadObj.setEmail(faker.internet().safeEmailAddress());
        userPayloadObj.setPassword(faker.internet().password(5, 10));
        userPayloadObj.setPhone(faker.phoneNumber().cellPhone());
        
        System.out.println("username : "+userPayloadObj.getUsername());
    }
    
    @Test(priority =1, dataProvider = "AllData")
    public void testCreateUser() {
       Response response = UserEndPoints.createUser(userPayloadObj);
       response.then().log().all();
       Assert.assertEquals(response.getStatusCode(), 200);
    }
    
    @Test(priority =2)
    public void testGetUser() {
       Response response = UserEndPoints.GetUser(userPayloadObj.getUsername());
       response.then().log().all();
       Assert.assertEquals(response.getStatusCode(), 200);
       
    }
    
    @Test(priority =3)
    public void testUpdateUser() {
    	
      // userPayloadObj.setFirstName("Kowsalya");
    	   userPayloadObj.setFirstName(faker.name().firstName());
       Response response = UserEndPoints.UpdateUser(userPayloadObj.getUsername(), userPayloadObj);
       
       //log response
       response.then().log().all();
       
       //Validation
       Assert.assertEquals(response.getStatusCode(), 200);
       
       //Read User data to check first name is updated or not
       System.out.println("Updated User Data");
       Response response1 = UserEndPoints.GetUser(userPayloadObj.getUsername());
       response1.then().log().all();
       
    }
    
    @Test(priority =4)
    public void testDeleteUser() {
       Response response = UserEndPoints.DeleteUser(userPayloadObj.getUsername());
       response.then().log().all();
       System.out.println("Delete Status code "+response.getStatusCode() +" Delete Status message "+response.getStatusLine());
       Assert.assertEquals(response.getStatusCode(), 200);
       
    }
}