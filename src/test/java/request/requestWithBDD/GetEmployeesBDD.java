package request.requestWithBDD;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GetEmployeesBDD {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://dummyapi.com";
    }

    @Test
    public void getAllEmployeesBDD() {
        RestAssured
                .given()
                .queryParam("company", "Cognizant") // Add company name as query parameter
                .when()
                .get("/employees") // Send GET request to fetch all employees
                .prettyPrint(); // Print the response in a pretty format

        // Note: Since I used a dummy URL, the following outputs are simulated to show possible responses.
        /*
        [
            {
                "id": 1,
                "first_name": "Yogesh",
                "last_name": "Pandian",
                "email": "yogeshpandian@cognizant.com",
                "company": "Cognizant"
            },
            {
                "id": 2,
                "first_name": "Siva",
                "last_name": "Ranjani",
                "email": "sivaranjani@cognizant.com",
                "company": "Cognizant"
            }
        ]
        */
    }
}
