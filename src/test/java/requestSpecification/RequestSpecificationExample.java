package requestSpecification;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RequestSpecificationExample {
    RequestSpecification reqSpec;

    // This method sets up the RequestSpecification with base URI, headers, and body for reuse
    @BeforeSuite
    public void setRequestSpecification(){
        reqSpec = RestAssured.given()  // 'given()' initiates request setup
                .baseUri("https://tamil-movie-api.com")  // Base URL for the Tamil movie API
                .header("Content-Type", "application/json")  // Set content type to JSON
                .body("{ \"movieTitle\" : \"Amaran\", \"releaseYear\" : 2024, \"actor\" : \"SK\", \"boxOfficeCollection\": 50000000, \"ottAvailable\": true }")
                .basePath("/movies");
        RestAssured.requestSpecification = reqSpec;  // Set global request specification
    }

    @Test
    public void getAll2024TamilMovies(){
        String response = RestAssured.given()
                .spec(reqSpec)  // Use predefined RequestSpecification
                .when()
                .get()  // Send GET request to retrieve all 2024 Tamil movies
                .then()
                .extract()
                .asString();  // Capture the response as a string
        System.out.println(response);

        // Simulated Output:
        // [
        //     { "id": 1, "movieTitle": "Amaran", "releaseYear": 2024, "actor": "SK", "boxOfficeCollection": 50000000, "ottAvailable": true },
        //     { "id": 2, "movieTitle": "BB", "releaseYear": 2024, "actor": "Kavin", "boxOfficeCollection": 75000000, "ottAvailable": true },
        //     { "id": 3, "movieTitle": "Lucky", "releaseYear": 2024, "actor": "DQ", "boxOfficeCollection": 40000000, "ottAvailable": false }
        // ]
    }

    @Test
    public void getSpecificMovie(){
        String response = RestAssured.given()
                //.spec(reqSpec)  // Optional since reqSpec is already globally set
                .when()
                .get("/3")  // Send GET request to retrieve movie with ID 3
                .then()
                .extract()
                .asString();  // Capture the response as a string
        System.out.println(response);

        // Simulated Output:
        // { "id": 3, "movieTitle": "Lucky", "releaseYear": 2024, "actor": "DQ", "boxOfficeCollection": 40000000, "ottAvailable": false }
    }

    @Test
    public void createMovie(){
        String response = RestAssured.given()
                .spec(reqSpec)  // Use predefined RequestSpecification
                .when()
                .post()  // Send POST request to create a new Tamil movie
                .then()
                .extract()
                .asString();  // Capture the response as a string
        System.out.println(response);

        // Simulated Output:
        // { "id": 4, "movieTitle": "Kanguva", "releaseYear": 2024, "actor": "Suriya", "boxOfficeCollection": 60000000, "ottAvailable": true }
    }

    @Test
    public void updateBoxOfficeCollection(){
        String response = RestAssured.given()
                .spec(reqSpec)  // Use predefined RequestSpecification
                .body("{\"boxOfficeCollection\": 30000000}")  // Update box office collection
                .when()
                .put("/2")  // Send PUT request to update movie with ID 2
                .then()
                .extract()
                .asString();  // Capture the response as a string
        System.out.println(response);

        // Simulated Output:
        // { "id": 2, "movieTitle": "BB", "releaseYear": 2024, "actor": "Kavin", "boxOfficeCollection": 30000000, "ottAvailable": true }
    }

    @Test
    public void deleteMovieFromOTT(){
        RequestSpecification explicitReq = RestAssured.given()  // Define a new RequestSpecification just for this request
                .baseUri("https://tamil-movie-api.com")
                .basePath("/movies");  // Endpoint for movie operations
        String response = RestAssured.given()
                .spec(explicitReq)
                .when()
                .delete("/5")  // Send DELETE request to remove movie with ID 5 from OTT platform
                .then()
                .extract()
                .asString();  // Capture the response as a string
        System.out.println(response);

        // Simulated Output:
        // { "message": "Movie with ID 5 removed from OTT platform successfully" }
    }
}
