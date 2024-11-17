package deserializationWays;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;

public class ObjectMapperForDeserialization {

    // JSON data representing a Marvel Character
    static String jsonValue = "{\n" +
            "  \"name\" : \"Peter Parker\",\n" +
            "  \"alias\" : \"Spider-Man\",\n" +
            "  \"superpower\" : \"Spider-Sense\",\n" +
            "  \"skills\" : [ \"Web-Slinging\", \"Martial Arts\", \"Wall-Crawling\" ]\n" +
            "}";

    public static void main(String[] args) throws IOException {
        usingObjectMapperForDeserialization();
    }

    public static void usingObjectMapperForDeserialization() throws IOException {
        System.out.println("Deserialization using Object Mapper");
        ObjectMapper objectMapper = new ObjectMapper();
        // Reading JSON and converting it to a Map
        Map<String, Object> marvelCharacter = objectMapper.readValue(jsonValue, Map.class);
        // Printing each field
        System.out.println("Name: " + marvelCharacter.get("name"));
        System.out.println("Alias: " + marvelCharacter.get("alias"));
        System.out.println("Superpower: " + marvelCharacter.get("superpower"));
        System.out.println("Skills: " + marvelCharacter.get("skills"));
    }
}
