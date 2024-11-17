package request.requestWithoutBDD;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DeleteEmployeeRequest {
    @Test
    public void deleteAnEmployee() {
        RestAssured.baseURI = "https://dummyapi.com";
        RequestSpecification requestSpecification = RestAssured.given();

        // Send DELETE request to delete an employee for company Accenture
        Response response = requestSpecification.request(Method.DELETE, "/employees/60e3");

        // Print response and status line
        String prettyString = response.asPrettyString();
        System.out.println(prettyString);
        String statusLine = response.getStatusLine();
        System.out.println(statusLine);

        // Dummy output:
        // {
        //     "message": "Employee deleted successfully"
        // }
        // HTTP/1.1 200 OK
    }
}
