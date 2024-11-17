package request.requestWithoutBDD;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class UpdateEmployeeRequest {
    @Test
    public void updateAnEmployee() {
        RestAssured.baseURI = "https://dummyapi.com";
        RequestSpecification requestSpecification = RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{ \"first_name\": \"Yogesh\", \"last_name\": \"Pandian\", \"email\": \"yogi@tcs.com\" }");

        // Send PUT request to update employee details for company TCS
        Response response = requestSpecification.request(Method.PUT, "/employees/2");

        // Print response and status line
        String prettyString = response.asPrettyString();
        System.out.println(prettyString);
        String statusLine = response.getStatusLine();
        System.out.println(statusLine);

        // Dummy output:
        // {
        //     "id": 2,
        //     "first_name": "Yogesh",
        //     "last_name": "Pandian",
        //     "email": "yogi@tcs.com"
        // }
        // HTTP/1.1 200 OK
    }
}
