
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITestAutomation {

    public static void main(String[] args) {

    }

    @Test
    public static void Test_Api (){

        // Set the base URI for RestAssured
        RestAssured.baseURI = "https://alexwohlbruck.github.io";

        // Perform the GET request to fetch a random cat fact
        Response response = given()
                .when()
                .get("/cat-facts/")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Step 3: Check if the response body is empty
        String responseBody = response.getBody().asString();
        assert responseBody != null && !responseBody.isEmpty() : "Test Failed: The response body is empty!";

    }

}

