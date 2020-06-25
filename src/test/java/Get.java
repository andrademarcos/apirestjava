import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class Get {

  // Test endpoints
  String baseURI = "http://localhost:8080";
  String endpointUser = "/cliente";
  String endpointDeleteAll = "/apagaTodos";

  @Test

  // Test description
  @DisplayName("When you get the user list, Then the list should be empty")
  public void getAllUsers(){
    deleteAllUsers();

    String response = "{}";


    given().contentType(JSON).

    when().get(baseURI).

    then().statusCode(200).assertThat().body(new IsEqual(response));

  }

  public void deleteAllUsers(){

    String response = "{}";


    given().contentType(JSON).

    when().delete(baseURI+endpointUser+endpointDeleteAll).

    then().statusCode(200).assertThat().body(new IsEqual(response));

  }
}
