package request.requestWithBDD;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteEmployeeBDD {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://dummyapi.com"; // Dummy base URL
    }

    @Test
    public void deleteAnEmployee() {
        Response response = RestAssured
                .given()
                .queryParam("company", "Accenture") // Add company name as query parameter
                .when()
                .delete("/employees/8"); // Send DELETE request to delete employee with ID 4
        response.then()
                .statusCode(200); // Assert that the status code is 200

        // Note: Since I used a dummy URL, the following outputs are simulated to show possible responses.
        /*
        {
            "message": "Employee with ID 8 deleted successfully"
        }
        */
    }
}
