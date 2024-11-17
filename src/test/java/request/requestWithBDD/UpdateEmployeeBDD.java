package request.requestWithBDD;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UpdateEmployeeBDD {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://dummyapi.com"; // Dummy base URL
    }

    @Test
    public void updateAnEmployeeBDD() {
        RestAssured
                .given()
                .header("Content-Type", "application/json") // Define Content-Type as JSON
                .body("{\n" + // Provide updated JSON body
                        "    \"first_name\": \"Yogesh\",\n" +
                        "    \"last_name\": \"Pandian\",\n" +
                        "    \"email\": \"yogi@tcs.com\",\n" + // Updated company name "TCS"
                        "    \"company\": \"TCS\"\n" +
                        "}")
                .when()
                .put("/employees/4") // Send PUT request to update employee with ID 4
                .prettyPrint(); // Print the response

        // Note: Since I used a dummy URL, the following outputs are simulated to show possible responses.
        /*
        {
            "id": 1002,
            "first_name": "Yogesh",
            "last_name": "pandian",
            "email": "yogi@tcs.com",
            "company": "TCS"
        }
        */
    }
}
