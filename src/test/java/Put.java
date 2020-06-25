import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class Put {

  // Test endpoints
  String baseURI = "http://localhost:8080";
  String endpointUser = "/cliente";
  String endpointDeleteAll = "/apagaTodos";

  @Test
  // Test description
  @DisplayName("When updating a user, Then the user must be updated successfully")
  public void updateUser() {

    // JSON
    String body = "{\n" +
            " \"nome\": \"Marcos\",\n" +
            " \"idade\": \"34\",\n" +
            " \"id\":\"1\"\n" +
            "}";

    // JSON
    String bodyUpdated = "{\n" +
            " \"nome\": \"Marcos Andrade\",\n" +
            " \"idade\": \"35\",\n" +
            " \"id\":\"1\"\n" +
            "}";

    // JSON
    String response = "{\"1\":" +
            "{\"nome\":\"Marcos Andrade\"," +
            "\"idade\":35," +
            "\"id\":1," +
            "\"risco\":0}" +
            "}";

    given().contentType(JSON).body(body).

    when().post(baseURI+endpointUser);


    given().contentType(JSON).body(bodyUpdated).

    when().put(baseURI+endpointUser).

    then().statusCode(200).assertThat().body(new IsEqual(response));


    deleteAllUsers();
  }

  public void deleteAllUsers(){

    String response = "{}";


    given().contentType(JSON).

    when().delete(baseURI+endpointUser+endpointDeleteAll).

    then().statusCode(200).assertThat().body(new IsEqual(response));

  }
}
