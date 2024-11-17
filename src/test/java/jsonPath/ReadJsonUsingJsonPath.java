package jsonPath;

import com.jayway.jsonpath.JsonPath;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

// 1. Using JsonPath.read() Method
// Approach: This is the simplest method where you directly use the JsonPath.read() method to parse the JSON file
// and extract the desired information using a provided JsonPath expression.
// Advantage: Easy and straightforward for one-off reads.
// Disadvantage: If you need to read multiple values, you will parse the JSON file every time, which can be inefficient.

public class ReadJsonUsingJsonPath {
    // Method 1: Extract all population values (Indefinite path)
    @Test
    public void readAllPopulations() throws IOException {
        File jsonFile = new File("src/test/resources/placesInTamilNadu.json");
        List<Object> populationList = JsonPath.read(jsonFile, "$..population");
        System.out.println("Populations in various places:");
        for (Object population : populationList) {
            System.out.println(population);
        }
    }

    // Method 2: Extract the names of all places (Indefinite path)
    @Test
    public void readAllPlaceNames() throws IOException {
        File jsonFile = new File("src/test/resources/placesInTamilNadu.json");
        List<Object> nameList = JsonPath.read(jsonFile, "$..name");
        System.out.println("Names of places in Tamil Nadu:");
        for (Object name : nameList) {
            System.out.println(name);
        }
    }

    // Method 3: Extract specific place details using a direct path
    @Test
    public void readDetailsOfFirstPlace() throws IOException {
        File jsonFile = new File("src/test/resources/placesInTamilNadu.json");
        Object firstPlaceDetails = JsonPath.read(jsonFile, "$.places[0]");
        System.out.println("Details of the first place:");
        System.out.println(firstPlaceDetails);
    }

    // Method 4: Extract places where population is greater than a specified number (Filter expression)
    @Test
    public void readPlacesWithLargePopulation() throws IOException {
        File jsonFile = new File("src/test/resources/placesInTamilNadu.json");
        List<Object> largePopulationPlaces = JsonPath.read(jsonFile, "$.places[?(@.population > 500000)].name");
        System.out.println("Places in Tamil Nadu with population greater than 500,000:");
        for (Object place : largePopulationPlaces) {
            System.out.println(place);
        }
    }
}

