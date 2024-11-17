package request.requestWithBDD;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateEmployeeBDD {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://dummyapi.com"; // Dummy base URL
    }

    @Test
    public void createAllEmployeeBDD() {
        RestAssured
                .given()
                .header("Content-Type", "application/json") // Define Content-Type as JSON
                .body("{\n" + // Provide the JSON body
                        "    \"first_name\": \"Yogesh\",\n" +
                        "    \"last_name\": \"Pandian\",\n" +
                        "    \"email\": \"yogesh@atos.com\",\n" +
                        "    \"company\": \"Atos Syntel\"\n" + // Company name "Atos Syntel"
                        "}")
                .when()
                .post("/employees") // Send POST request to create the employee
                .prettyPrint(); // Print the response

        // Note: Since I used a dummy URL, the following outputs are simulated to show possible responses.
        /*
        {
            "id": 102,
            "first_name": "Yogesh",
            "last_name": "Pandian",
            "email": "yogesh@atos.com",
            "company": "Atos Syntel"
        }
        */
    }
}
