import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class Post {

  // Test endpoints
  String baseURI = "http://localhost:8080";
  String endpointUser = "/cliente";

  @Test
  // Test description
  @DisplayName("When registering a user, Then the user must be successfully registered")
  public void registerUser() {

    // JSON
    String body = "{\n" +
            " \"nome\": \"Marcos\",\n" +
            " \"idade\": \"34\",\n" +
            " \"id\":\"1\"\n" +
            "}";

    // JSON
    String response = "{\"1\":" +
            "{\"nome\":\"Marcos\"," +
            "\"idade\":34," +
            "\"id\":1," +
            "\"risco\":0}" +
            "}";

    given().contentType(JSON).body(body).

            when().post(baseURI+endpointUser).

            then().statusCode(201).assertThat().body(new IsEqual(response));
  }
}
