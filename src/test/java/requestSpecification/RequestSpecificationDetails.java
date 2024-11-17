package requestSpecification;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RequestSpecificationDetails {
    /**
     * This class demonstrates how to create and inspect a RequestSpecification using RestAssured.
     * It covers setting up the request details, sending a POST request, and querying the properties
     * of the request specification.
     */
    public static void main(String[] args) {
        // Input JSON file for the request body
        File inputRequestJson = new File("src/test/resources/inputRequest.json");

        // Creating the RequestSpecification object with proper details
        RequestSpecification requestSpecification = RestAssured
                .given()
                .baseUri("http://dummy-url.com")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer your_token_here") // Add authorization header if needed
                .queryParam("source", "illustrationApp") // Adding a sample query parameter
                .cookie("session_id", "abcd1234") // Adding a sample cookie
                .body(inputRequestJson) // Adding the body content as a String
                .log().all(); // Logs all request details

        // Calling the method to handle the POST request and print the response
        PostCandidateIllustration(requestSpecification);

        // Calling the method to get request specification properties
        getRequestSpecificationProperties(requestSpecification);
    }

    public static void PostCandidateIllustration(RequestSpecification requestSpecification) {
        Response response = requestSpecification.when().post("/candidate");

        // Printing the response for verification
        System.out.println("Response:");
        System.out.println(response.asPrettyString());
    }

    public static void getRequestSpecificationProperties(RequestSpecification requestSpecification) {
        // Using SpecificationQuerier to query the properties of the RequestSpecification.
        // This helps in retrieving and inspecting the details of the request after it is set up.
        QueryableRequestSpecification queryableRequest = SpecificationQuerier.query(requestSpecification);

        System.out.println("\nQueried Request Specification Properties:");
        System.out.println("Base URI: " + queryableRequest.getBaseUri());
        System.out.println("Headers: " + queryableRequest.getHeaders());
        System.out.println("Cookies: " + queryableRequest.getCookies());
        System.out.println("Query Params: " + queryableRequest.getQueryParams());
        System.out.println("Body: " + queryableRequest.getBody());
    }

}
