package jsonSchema;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

public class JsonSchemaValidation {

    /**
     * In API testing, the request and response will be in JSON format.
     * We usually compare the response against a predefined response schema
     * to ensure that the structure and data types of the response match
     * the expected format.
     * JsonSchemaValidator is a class in RestAssured that provides functionality
     * to validate JSON responses against a defined JSON schema.
     */

    // This test validates the JSON response against a predefined schema
    @Test
    public void validateUsingJsonSchemaInClasspath() {
        // Send a GET request and validate the response schema
        RestAssured
                .given()
                .baseUri("http://dummy-url") // Set the base URI for the API
                .header("Content-Type", "application/json") // Set the content type to JSON
                .when()
                .get("/coffees") // Send a GET request to the coffees endpoint
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responseSchema.json")); // Validate the response against the JSON schema
    }
}
/* Note: Since I used a dummy URL, the following outputs are simulated to show possible responses.
* [
  {
    "id": 1,
    "name": "FilterCoffee",
    "origin": "India",
    "strength": "Strong",
    "flavor": "Bold"
  },
  {
    "id": 2,
    "name": "Cappuccino",
    "origin": "Italy",
    "strength": "Medium",
    "flavor": "Creamy"
  },
  {
    "id": 3,
    "name": "Espresso",
    "origin": "Italy",
    "strength": "Strong",
    "flavor": "Bold"
  }
]

* */