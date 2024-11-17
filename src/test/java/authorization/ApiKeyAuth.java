package authorization;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ApiKeyAuth {

    /*
     * An API key is a unique identifier used to authenticate requests to an API.
     * It acts as a password to allow the server to verify if the requesting user is authorized.
     * The API key is usually sent in the request header or as a query parameter.
     * In these examples, we demonstrate both methods of passing the API key.
     */

    // This test method demonstrates how to send an API key in the headers for authorization
    @Test
    public void apiKeyAuthUsingHeaders() {
        // Setting up the base URI for the API request
        Response response = RestAssured.given()
                .baseUri("https://weather-dummyurl.com")

                // Adding city and API key in the request headers
                .header("city", "Chennai")
                .header("appid", "dummy-api-key-12345") // The 'appid' is the API key sent as a header

                // Specifying the GET request to retrieve weather data
                .when()
                .get("/weather");

        // Printing the response to the console in a readable format
        response.prettyPrint();
    }

    // This test method demonstrates how to send an API key as a query parameter for authorization
    @Test
    public void apiKeyUsingQueryParam() {
        // Setting up the base URI for the API request
        Response response = RestAssured.given()
                .baseUri("https://weather-dummyurl.com")

                // Adding city and API key as query parameters in the request
                .queryParam("city", "Chennai")
                .queryParam("appid", "dummy-api-key-67890") // The 'appid' is the API key sent as a query parameter

                // Specifying the GET request to retrieve weather data
                .when()
                .get("/weather");

        // Printing the response to the console in a readable format
        response.prettyPrint();
    }

    /*
     * Note: Since I used a dummy URL, the following outputs are simulated to show possible responses.
     *
     * Console Output Using prettyPrint():
     * {
     *     "city": "Chennai",
     *     "temperature": {
     *         "current": 30,
     *         "feels_like": 32,
     *         "min": 28,
     *         "max": 34
     *     },
     *     "weather": [
     *         {
     *             "description": "clear sky",
     *             "icon": "01d"
     *         }
     *     ],
     *     "humidity": 70,
     *     "wind": {
     *         "speed": 5,
     *         "direction": "NE"
     *     },
     *     "pressure": 1015,
     *     "visibility": 10000,
     *     "sunrise": "06:05 AM",
     *     "sunset": "06:40 PM"
     * }
     *
     * If the Request Fails:
     * {
     *     "error": "Invalid API key"
     * }
     * or
     * {
     *     "message": "Unauthorized",
     *     "code": 401
     * }
     *
     * Conclusion:
     * - The 'prettyPrint()' method displays the JSON response in a readable format.
     * - The output depends on the response structure from the real API, showing full weather details if successful.
     * - If the request fails due to an invalid or missing API key, an error response will be printed.
     */
}
