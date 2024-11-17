package DeserializationWays;

import io.restassured.path.json.JsonPath;
import java.util.Map;

public class RestAssuredJsonPathForDeserialization {

    // JSON data representing a Marvel Character
    static String jsonValue = "{\n" +
            "  \"name\" : \"Peter Parker\",\n" +
            "  \"alias\" : \"Spider-Man\",\n" +
            "  \"superpower\" : \"Spider-Sense\",\n" +
            "  \"skills\" : [ \"Web-Slinging\", \"Martial Arts\", \"Wall-Crawling\" ]\n" +
            "}";

    public static void main(String[] args) {
        usingRestAssuredJsonPathForDeserialization();
    }

    public static void usingRestAssuredJsonPathForDeserialization() {
        System.out.println("Deserialization using RestAssured JSONPath");
        // Parsing the JSON and converting it to a Map using RestAssured
        JsonPath jsonFile = JsonPath.from(jsonValue);
        Map<String, Object> marvelCharacter = jsonFile.get("$");
        // Printing each field
        System.out.println("Name: " + marvelCharacter.get("name"));
        System.out.println("Alias: " + marvelCharacter.get("alias"));
        System.out.println("Superpower: " + marvelCharacter.get("superpower"));
        System.out.println("Skills: " + marvelCharacter.get("skills"));
    }
}
