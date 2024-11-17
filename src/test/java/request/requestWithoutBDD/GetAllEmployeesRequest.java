package request.requestWithoutBDD;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetAllEmployeesRequest {
    @Test
    public void getAllEmployees() {
        RestAssured.baseURI = "https://dummyapi.com";
        RequestSpecification requestSpecification = RestAssured.given();

        // Send GET request to fetch all employees for company Cognizant
        Response response = requestSpecification.request(Method.GET, "employees");

        // Print response and status line
        String prettyString = response.asPrettyString();
        System.out.println(prettyString);
        String statusLine = response.getStatusLine();
        System.out.println(statusLine);

        // Dummy output:
        // {
        //     "employees": [
        //         {"id": 1, "first_name": "Yogesh", "last_name": "Pandian", "email": "yogeshpandian@cognizant.com"},
        //         {"id": 2, "first_name": "Siva", "last_name": "Ranjani", "email": "sivaranjani@cognizant.com"}
        //     ]
        // }
        // HTTP/1.1 200 OK
    }
}
