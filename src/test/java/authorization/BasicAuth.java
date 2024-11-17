package authorization;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class BasicAuth {

    /*
     * Basic Authentication is a simple authentication method where the client sends the username and password.
     * The server then verifies the credentials and grants access if the credentials are correct.
     * In this example, we are using RestAssured to perform a Basic Authentication request.
     */

    // This test demonstrates how to use Basic Authentication with RestAssured
    @Test
    public void basicAuth() {
        // Perform a GET request with Basic Authentication (username and password)
        Response response = RestAssured.given()
                .auth()
                .basic("postman", "password") // Providing the username and password for authentication
                .baseUri("https://postman-echo.com") // Base URI for the API request

                // Specifying the endpoint to access
                .when()
                .get("/basic-auth"); // This endpoint requires basic authentication

        // Print the response in a readable format
        response.prettyPrint();

        // Validate the status code and response body to ensure authentication was successful
        response.then().statusCode(200) // Expecting HTTP 200 OK status
                .body("authenticated", equalTo(true)); // Checking if the "authenticated" field is true
    }

}
