package jsonSchema;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class JsonSchemaValidationWithHamcrest {

    @Test
    public void validateJsonResponse() throws IOException {
        String baseUrl = "http://dummy-url";

        // Send a GET request to fetch coffee varieties (simulated)
        String response = RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .when()
                .get("/coffee-varieties")
                .thenReturn()
                .asString();  // Get response as a String

        // Step 1: Validate the response schema
        File responseSchema = new File("src/test/resources/responseSchema.json");
        RestAssured
                .given()
                .body(response)  // Use the raw response here
                .then()
                .body(JsonSchemaValidator.matchesJsonSchema(responseSchema)); // Validate against schema

        // Step 2: Validate specific values in the response using Hamcrest matchers
        MatcherAssert.assertThat(response, Matchers.containsString("FilterCoffee")); // Check if "FilterCoffee" is mentioned
        MatcherAssert.assertThat(response, Matchers.containsString("Cappuccino")); // Check if "Cappuccino" is listed
        MatcherAssert.assertThat(response, Matchers.containsString("Espresso")); // Check if "Espresso" is listed

        // Optional: Validate the presence of certain fields with specific values (using Hamcrest)
        // Example: Check if response contains "name" as "FilterCoffee", "origin" as "India", etc.
        MatcherAssert.assertThat(response, Matchers.containsString("\"name\":\"FilterCoffee\""));
        MatcherAssert.assertThat(response, Matchers.containsString("\"origin\":\"India\""));
        MatcherAssert.assertThat(response, Matchers.containsString("\"strength\":\"Strong\""));
        MatcherAssert.assertThat(response, Matchers.containsString("\"flavor\":\"Bold\""));

        MatcherAssert.assertThat(response, Matchers.containsString("\"name\":\"Cappuccino\""));
        MatcherAssert.assertThat(response, Matchers.containsString("\"origin\":\"Italy\""));
        MatcherAssert.assertThat(response, Matchers.containsString("\"strength\":\"Medium\""));
        MatcherAssert.assertThat(response, Matchers.containsString("\"flavor\":\"Creamy\""));

        MatcherAssert.assertThat(response, Matchers.containsString("\"name\":\"Espresso\""));
        MatcherAssert.assertThat(response, Matchers.containsString("\"origin\":\"Italy\""));
        MatcherAssert.assertThat(response, Matchers.containsString("\"strength\":\"Strong\""));
        MatcherAssert.assertThat(response, Matchers.containsString("\"flavor\":\"Bold\""));

        // Step 3: Validate more complex conditions if needed
        // For example, check if the strength is either "Strong" or "Medium" using Hamcrest
        MatcherAssert.assertThat(response, Matchers.anyOf(
                Matchers.containsString("\"strength\":\"Strong\""),
                Matchers.containsString("\"strength\":\"Medium\"")
        ));
    }
}
