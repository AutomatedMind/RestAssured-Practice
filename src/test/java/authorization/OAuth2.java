package authorization;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class OAuth2 {

    /*
     * OAuth 2.0 is an authorization framework that allows third-party applications
     * to obtain limited access to a user's resources on an HTTP service,
     * such as a web application or an API.
     * In this example, we are using OAuth 2.0 to delete a user resource.
     */

    @Test
    public void deleteWithOAuth2() {
        // Sending the DELETE request with OAuth2 authentication
        Response response = RestAssured.given()
                .baseUri("https://api.example.com") // Base URI for the API request
                .auth()
                .oauth2("35s1d31sdf3s1d") // OAuth2 token for authentication
                .when()
                .delete("/users/123"); // DELETE request to remove the user with ID 123

        // Print the response from the server
        response.prettyPrint();
    }
}

/*
 * API Key: Like a house key that opens your home without needing identification.
 * Bearer Token: Like a ticket to a concert that allows access to specific areas.
 * OAuth 2.0: Like a VIP pass that grants access after verifying your identity and permissions.
 */



/*
 * API Key:
 * An API Key is like a password but simpler. You send it either in the header or as a query parameter in every request,
 * and the server uses this key to verify if you have access to the API.
 *
 * Example:
 * Response response = RestAssured.given()
 *        .header("appid", "YOUR_API_KEY_HERE")
 *        .get("/weather");
 *
 * The API key is used to identify the client. It’s simple but not very secure because it’s static and can be exposed.
 */

/*
 * Basic Auth:
 * Basic Auth involves sending a username and password encoded in Base64 in every request.
 * The server checks these credentials to grant access.
 * It's called "Basic" because there's no advanced encryption—just the username and password.
 *
 * Example:
 * Response response = RestAssured.given()
 *        .auth()
 *        .basic("username", "password")
 *        .get("/basic-auth");
 *
 * Basic Auth is generally used for internal or less critical APIs, and
 * since it's plain text (encoded but not encrypted), it's not the most secure option.
 */

/*
 * Bearer Token:
 * A Bearer Token is more secure than Basic Auth.
 * The server issues a token to the client after a successful login or authentication,
 * and that token is included in the Authorization header for every API request.
 *
 * Example:
 * Response response = RestAssured.given()
 *        .header("Authorization", "Bearer YOUR_TOKEN_HERE")
 *        .put("/users/123");
 *
 * The token is short-lived, making it safer than a static key or password.
 * You don’t need to keep sending the username and password; just the token.
 */

/*
 * OAuth2:
 * OAuth2 is the most complex but also the most secure.
 * It involves a multi-step process where a client first authenticates with an authorization server to get an access token.
 * That token is then used to make API requests.
 *
 * Example:
 * Response response = RestAssured.given()
 *        .auth()
 *        .oauth2("YOUR_OAUTH2_TOKEN")
 *        .delete("/users/123");
 *
 * OAuth2 is great because the tokens are temporary and can be refreshed, providing an extra layer of security.
 */


