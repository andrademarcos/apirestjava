import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class Delete {

    // Test endpoints
    String baseURI = "http://localhost:8080";
    String endpointUser = "/cliente";

  @Test
  @DisplayName("When deleting a user, Then the user must be successfully deleted")
  public void deleteUser() {

    String idToDelete = "/1";

    // JSON
    String body = "{\n" +
            " \"nome\": \"Marcos\",\n" +
            " \"idade\": \"34\",\n" +
            " \"id\":\"1\"\n" +
            "}";

    String response = "CLIENTE REMOVIDO: { NOME: Marcos, IDADE: 34, ID: 1 }";

    given().contentType(JSON).body(body).

    when().post(baseURI +endpointUser);


    given().contentType(JSON).

    when().delete(baseURI+endpointUser+idToDelete).

    then().statusCode(200).assertThat().body(new IsEqual(response));

  }
}
