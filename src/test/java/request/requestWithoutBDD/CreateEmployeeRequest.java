package request.requestWithoutBDD;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CreateEmployeeRequest {
    @Test
    public void createAnEmployee() {
        RestAssured.baseURI = "https://dummyapi.com";
        RequestSpecification requestSpecification = RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{ \"first_name\": \"Yogesh\", \"last_name\": \"Pandian\", \"email\": \"yogesh@atos-syntel.com\" }");

        // Send POST request to create an employee for company Atos Syntel
        Response response = requestSpecification.request(Method.POST, "/employees");

        // Print response and status line
        String prettyString = response.asPrettyString();
        System.out.println(prettyString);
        String statusLine = response.getStatusLine();
        System.out.println(statusLine);

        // Dummy output:
        // {
        //     "id": 3,
        //     "first_name": "Yogesh",
        //     "last_name": "Pandian",
        //     "email": "yogesh@atos-syntel.com"
        // }
        // HTTP/1.1 201 Created
    }
}
