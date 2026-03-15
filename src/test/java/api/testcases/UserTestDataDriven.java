package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endPoints.UserEndPoints_old;
import api.payload.UserPayload;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestDataDriven {
  
    
	UserPayload userPayloadObj;

	@BeforeClass
	public void setup() {
	    userPayloadObj = new UserPayload();

	}
    @Test(priority =1, dataProvider = "AllDataPvdr", dataProviderClass = DataProviders.class)
    public void testCreateUser(String userID, String userName, String fName, String lName, String email, String password, String phone) {
       
    	  System.out.println("Data From Excel Sheet : "+userID +" : "+userName);
     
        userPayloadObj.setId(Integer.parseInt(userID));
        userPayloadObj.setUsername(userName);
        userPayloadObj.setFirstName(fName);
        userPayloadObj.setLastName(lName);
        userPayloadObj.setEmail(email);
        userPayloadObj.setPassword(password);
        userPayloadObj.setPhone(phone);   
    	
    	Response response = UserEndPoints_old.createUser(userPayloadObj);
       response.then().log().all();
       Assert.assertEquals(response.getStatusCode(), 200);
    }
    
  @Test(priority =2, dataProvider = "UsernameDataPvdr", dataProviderClass = DataProviders.class)
    public void testGetUser(String userName) {
    	  userPayloadObj.setUsername(userName);
       Response response = UserEndPoints_old.GetUser(userPayloadObj.getUsername());
       response.then().log().all();
       Assert.assertEquals(response.getStatusCode(), 200);
       
    }
    
    @Test(priority =3, dataProvider = "UsernameDataPvdr", dataProviderClass = DataProviders.class)
    public void testUpdateUser(String userName) {
    	
    	  userPayloadObj.setFirstName("Kowslaya");
    	  userPayloadObj.setUsername(userName);
       Response response = UserEndPoints_old.UpdateUser(userPayloadObj.getUsername(), userPayloadObj);
       
       //log response
       response.then().log().all();
       
       //Validation
       Assert.assertEquals(response.getStatusCode(), 200);
       
       //Read User data to check first name is updated or not
       System.out.println("Updated User Data");
       Response response1 = UserEndPoints_old.GetUser(userPayloadObj.getUsername());
       response1.then().log().all();
       
    }
    
    @Test(priority =4, dataProvider = "UsernameDataPvdr",dataProviderClass = DataProviders.class)
    public void testDeleteUser(String userName) {
    	 userPayloadObj.setUsername(userName);
       Response response = UserEndPoints_old.DeleteUser(userPayloadObj.getUsername());
       response.then().log().all();
       System.out.println("Delete Status code "+response.getStatusCode() +" Delete Status message "+response.getStatusLine());
       Assert.assertEquals(response.getStatusCode(), 200);
       
    }
    
}