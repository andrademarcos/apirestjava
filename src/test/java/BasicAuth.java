import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BasicAuth {

  @Test
  @DisplayName("When the user enters the correct username and password, Then will be successfully logged in")
  public void basicAuth(){

    String baseURI = "http://localhost:8080";
    String endpointUserRisk = "/endpoint";
    String userId = "/1";

    given().auth().preemptive().basic("username", "password").

    when().get(baseURI+endpointUserRisk+userId).

    // Status 200 - OK
    then().statusCode(200);
  }

  @Test
  @DisplayName("When the user enters the incorrect username and password, Then will not be able to log in")
  public void basicAuthUnauthorized(){

    String baseURI = "http://localhost:8080";
    String endpointUserRisk = "/endpoint";
    String userId = "/1";

    given().auth().preemptive().basic("username", "wrongPassword").

    when().get(baseURI+endpointUserRisk+userId).

    // Status 401 - Unauthorized
    then().statusCode(401);
  }

}
