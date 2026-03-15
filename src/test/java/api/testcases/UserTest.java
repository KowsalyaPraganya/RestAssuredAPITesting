package api.testcases;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endPoints.UserEndPoints_old;
import api.payload.UserPayload;
import io.restassured.response.Response;

public class UserTest {

    Faker faker;
    UserPayload userPayloadObj;
    public static Logger logger;

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
        
        //Obtain logger
        logger = LogManager.getLogger("RestAssuredAPITesting");

    }
    
    @Test(priority =1)
    public void testCreateUser() {
       Response response = UserEndPoints_old.createUser(userPayloadObj);
       response.then().log().all();
       Assert.assertEquals(response.getStatusCode(), 200);
       
       //log
       logger.info("Create User Executed");
    }
    
    @Test(priority =2)
    public void testGetUser() {
       Response response = UserEndPoints_old.GetUser(userPayloadObj.getUsername());
       response.then().log().all();
       Assert.assertEquals(response.getStatusCode(), 200);
       
     //log
       logger.info("Get User Executed");
       
    }
    
    @Test(priority =3)
    public void testUpdateUser() {
    	
      // userPayloadObj.setFirstName("Kowsalya");
    	   userPayloadObj.setFirstName(faker.name().firstName());
       Response response = UserEndPoints_old.UpdateUser(userPayloadObj.getUsername(), userPayloadObj);
       
       //log response
       response.then().log().all();
       
       //Validation
       Assert.assertEquals(response.getStatusCode(), 200);
       
       //Read User data to check first name is updated or not
       System.out.println("Updated User Data");
       Response response1 = UserEndPoints_old.GetUser(userPayloadObj.getUsername());
       response1.then().log().all();
       
     //log
       logger.info("Update User Executed");
       
    }
    
    @Test(priority =4)
    public void testDeleteUser() {
       Response response = UserEndPoints_old.DeleteUser(userPayloadObj.getUsername());
       response.then().log().all();
       System.out.println("Delete Status code "+response.getStatusCode() +" Delete Status message "+response.getStatusLine());
       Assert.assertEquals(response.getStatusCode(), 200);
       
     //log
       logger.info("Delete User Executed");
       
    }
}