package tests;

import boredapi.BoredResponseHandler;
import io.restassured.response.Response;
import listener.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SuppressWarnings("all")
public class BoredTests extends BaseClass {

    BoredResponseHandler boredResponseHandler;

    @BeforeMethod
    public void setUpBoredTests() {
        boredResponseHandler = new BoredResponseHandler();
    }

    @Test(description = "Get random actyvity. Validate response body contane activity description")
    public void boredRandomActivity() {
        Response getRandomActivity = boredResponseHandler.getRandomActivity();
        String activity = getRandomActivity.jsonPath().getString("activity");
        Assert.assertNotNull(activity);
        Log.info("Random activity is " + activity);
    }

    @Test(description = "Get actyvity by type and for specific ammount of participants. Validate response body contane correct activity type and participants number")
    public void getSpecificActivity() {
        Response getRandomActivity = boredResponseHandler.getActivityByTypeAndParticipants("recreational", 4);
        String activity = getRandomActivity.jsonPath().getString("activity");
        String type = getRandomActivity.jsonPath().getString("type");
        Integer participants = getRandomActivity.jsonPath().getInt("participants");
        Assert.assertEquals(type, "recreational");
        Assert.assertEquals(participants, 4);
        Log.info("Activity for you is " + activity);
    }
}
