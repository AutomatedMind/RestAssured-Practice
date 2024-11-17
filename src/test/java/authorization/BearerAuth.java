package authorization;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class BearerAuth {

    /*
     * Bearer Authentication (or Token Authentication) is a security mechanism where a bearer token is
     * included in the request header to authenticate the user. The server verifies the token and grants
     * access to the API if the token is valid.
     * In this example, we are sending a PUT request with a Bearer token to update user data.
     */

    @Test
    public void putWithBearerToken() {
        // JSON body for updating the resource
        String requestBody = "{ \"name\": \"John\", \"job\": \"Senior Developer\" }";

        // Sending the PUT request with Bearer Token Authentication
        Response response = RestAssured.given()
                .baseUri("https://api.example.com") // Base URI for the API request
                .header("authorization", "Bearer YOUR_BEARER_TOKEN_HERE") // Include the Bearer token in the Authorization header
                .header("Content-Type", "application/json") // Specify that the request body is in JSON format
                .body(requestBody) // Attach the request body containing the updated user data
                .when()
                .put("/users/123"); // PUT request to update user with ID 123

        // Print the response from the server
        response.prettyPrint();
    }

    /*
     * Note: Since I used a dummy URL, the following outputs are simulated to show possible responses.
     *
     * Console Output Using prettyPrint():
     * {
     *     "name": "John",
     *     "job": "Senior Developer",
     *     "updatedAt": "2024-11-15T15:10:00.000Z"
     * }
     *
     * If the Bearer Token is Invalid or Missing:
     * {
     *     "error": "Unauthorized",
     *     "message": "Invalid token or missing authorization header"
     * }
     *
     * Conclusion:
     * - The 'prettyPrint()' method displays the JSON response in a readable format.
     * - The output depends on the server's response, showing the updated user details if the Bearer token is valid.
     * - If the Bearer token is invalid or missing, an "Unauthorized" message will be returned.
     */
}
