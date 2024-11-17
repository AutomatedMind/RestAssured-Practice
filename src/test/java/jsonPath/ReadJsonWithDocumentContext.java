package jsonPath;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
// 2. Using Fluent API with DocumentContext
// Approach: The DocumentContext class allows for fluent interaction with the JSON file.
// Advantage: The fluent API makes it easier to chain multiple operations and reuse the DocumentContext for multiple reads without re-parsing.
// Disadvantage: Requires managing the DocumentContext instance.
public class ReadJsonWithDocumentContext {
    // Method 1: Extract all 'famousFor' values (Indefinite path)
    @Test
    public void readAllFamousForWithContext() throws IOException {
        File jsonFile = new File("src/test/resources/placesInTamilNadu.json");

        // Parse the JSON file and create a DocumentContext object
        DocumentContext context = JsonPath.parse(jsonFile);

        // Read data using the context
        List<Object> famousForList = context.read("$..famousFor");
        System.out.println("Famous For in various places:");
        for (Object item : famousForList) {
            System.out.println(item);
        }
    }

    // Method 2: Slice the array to get a range of places (Array slicing)
    @Test
    public void readPlacesWithArraySlicingWithContext() throws IOException {
        File jsonFile = new File("src/test/resources/placesInTamilNadu.json");

        // Parse the JSON file and create a DocumentContext object
        DocumentContext context = JsonPath.parse(jsonFile);

        // Slice the array to get the first 3 places and their names
        List<Object> slicedPlaces = context.read("$.places[0:3].name"); // Getting first 3 places
        System.out.println("First 3 places in Tamil Nadu:");
        for (Object place : slicedPlaces) {
            System.out.println(place);
        }
    }

    // Method 3: Filter places with a population greater than 1,000,000 (Filter expression)
    @Test
    public void readPlacesWithLargePopulationWithContext() throws IOException {
        File jsonFile = new File("src/test/resources/placesInTamilNadu.json");

        // Parse the JSON file and create a DocumentContext object
        DocumentContext context = JsonPath.parse(jsonFile);

        // Filter places with population greater than 1,000,000
        List<Object> largePopulationPlaces = context.read("$.places[?(@.population > 1000000)].name");
        System.out.println("Places in Tamil Nadu with population greater than 1,000,000:");
        for (Object place : largePopulationPlaces) {
            System.out.println(place);
        }
    }

    // Method 4: Use JSONPath function to count the number of places (Count function)
    @Test
    public void countPlacesUsingJsonPathWithContext() throws IOException {
        File jsonFile = new File("src/test/resources/placesInTamilNadu.json");

        // Parse the JSON file and create a DocumentContext object
        DocumentContext context = JsonPath.parse(jsonFile);

        // Count the number of places in Tamil Nadu
        Integer placeCount = context.read("$.places.length()");
        System.out.println("Total number of places in Tamil Nadu: " + placeCount);
    }

}


