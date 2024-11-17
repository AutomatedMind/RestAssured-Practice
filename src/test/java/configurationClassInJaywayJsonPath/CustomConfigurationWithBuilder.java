package configurationClassInJaywayJsonPath;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;


public class CustomConfigurationWithBuilder  {
    String jsonFile = "{\n" +
            "  \"bookstore\": {\n" +
            "    \"name\": \"Book Truck\",\n" +
            "    \"inventory\": [\n" +
            "      {\n" +
            "        \"bookId\": 1,\n" +
            "        \"title\": \"You are my best friend\",\n" +
            "        \"genre\": \"Romance\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"bookId\": 2,\n" +
            "        \"title\": \"Her Last Wish\",\n" +
            "        \"author\": \"Ajay K Pandey\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";
    public void useCustomConfigurationWithBuilder() {
        Configuration customConfig = Configuration.builder()
                .options(Option.DEFAULT_PATH_LEAF_TO_NULL)  // Option to return "null" for non-existent fields
                .build();

        // Querying a non-existent field 'asd' in the first inventory item using custom configuration
        String nonExistentField = JsonPath.using(customConfig).parse(jsonFile).read("$.bookstore.inventory[0].asd");

        // This should print "null" because 'asd' does not exist in the JSON
        System.out.println("Value for non-existent field (using custom config): " + nonExistentField);
    }


}
