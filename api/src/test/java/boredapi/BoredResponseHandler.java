package boredapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import listener.Log;
import org.testng.Assert;
import tests.BaseClass;

import static io.restassured.RestAssured.given;

@SuppressWarnings("all")
public class BoredResponseHandler extends BaseClass implements BoredAPIHandler {
    @Override
    public Response getRandomActivity() {
        Log.info("Get random activity");
        Log.info("Endpoint: " + RestAssured.baseURI + BoredAPIHandler.activityResource);
        Response getRandomActivityResponse =
                given()
                        .get(BoredAPIHandler.activityResource)
                        .then()
                        .extract().response();
        try {
            Assert.assertEquals(getRandomActivityResponse.statusCode(), 200);
            Log.info("Random activity retrieved successfully");
            Log.info("Response body: \n" + getRandomActivityResponse.getBody().asString());
            return getRandomActivityResponse;

        } catch (AssertionError e) {
            Log.info("Get random activity failed with status code of: " + getRandomActivityResponse.statusCode());
            Log.info("Response body: \n" + getRandomActivityResponse.getBody().asString());
            Assert.assertEquals(getRandomActivityResponse.statusCode(), 200);
            return getRandomActivityResponse;
        }
    }

    @Override
    public Response getActivityByTypeAndParticipants(String type, int participants) {
        Log.info("Get activity by type aand by quantity of participants");
        Log.info("Endpoint: " + RestAssured.baseURI + BoredAPIHandler.activityResource);
        Response getRandomActivityResponse =
                given()
                        .queryParam("type", type)
                        .queryParam("participants", participants)
                        .get(BoredAPIHandler.activityResource)
                        .then()
                        .extract().response();
        try {
            Assert.assertEquals(getRandomActivityResponse.statusCode(), 200);
            Log.info("Activity for " + participants + " participant(s) and type " + type + " retrieved successfully");
            Log.info("Response body: \n" + getRandomActivityResponse.getBody().asString());
            return getRandomActivityResponse;

        } catch (AssertionError e) {
            Log.info("Get activity by type aand by quantity of participants failed with status code of: " + getRandomActivityResponse.statusCode());
            Log.info("Response body: \n" + getRandomActivityResponse.getBody().asString());
            Assert.assertEquals(getRandomActivityResponse.statusCode(), 200);
            return getRandomActivityResponse;
        }
    }
}
