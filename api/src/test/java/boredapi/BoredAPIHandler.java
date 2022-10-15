package boredapi;

import io.restassured.response.Response;

public interface BoredAPIHandler {
    String activityResource = "/activity";

    Response getRandomActivity();
    Response getActivityByTypeAndParticipants(String type, int participants);
}
