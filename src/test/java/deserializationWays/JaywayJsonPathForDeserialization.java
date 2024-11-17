package deserializationWays;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import java.util.Map;

public class JaywayJsonPathForDeserialization {

    // JSON data representing a Marvel Character
    static String jsonValue = "{\n" +
            "  \"name\" : \"Peter Parker\",\n" +
            "  \"alias\" : \"Spider-Man\",\n" +
            "  \"superpower\" : \"Spider-Sense\",\n" +
            "  \"skills\" : [ \"Web-Slinging\", \"Martial Arts\", \"Wall-Crawling\" ]\n" +
            "}";

    public static void main(String[] args) {
        usingJaywayJsonPathForDeserialization();
    }

    public static void usingJaywayJsonPathForDeserialization() {
        System.out.println("Deserialization using Jayway JSONPath");
        // Configuring JSONPath to use JacksonMappingProvider for deserialization
        JacksonMappingProvider jacksonMappingProvider = new JacksonMappingProvider();
        Configuration mappingConfiguration = Configuration
                .builder()
                .mappingProvider(jacksonMappingProvider)
                .build();
        // Parsing the JSON and converting it to a Map
        Map<String, Object> marvelCharacter = JsonPath.using(mappingConfiguration)
                .parse(jsonValue)
                .read("$");
        // Printing each field
        System.out.println("Name: " + marvelCharacter.get("name"));
        System.out.println("Alias: " + marvelCharacter.get("alias"));
        System.out.println("Superpower: " + marvelCharacter.get("superpower"));
        System.out.println("Skills: " + marvelCharacter.get("skills"));
    }
}
