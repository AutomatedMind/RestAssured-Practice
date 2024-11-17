package configurationClassInJaywayJsonPath;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

public class DefaultConfigurationWithDefaultPathLeafToNull  {
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
    public void useDefaultConfigurationWithDefaultPathLeafToNull() {
        Configuration defaultConfig = Configuration.defaultConfiguration()
                .addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);  // Option to return "null" for non-existent fields

        // Querying a non-existent field 'asd' in the first inventory item
        String nonExistentField = JsonPath.using(defaultConfig).parse(jsonFile).read("$.bookstore.inventory[0].asd");

        // This should print "null" as 'asd' does not exist in the JSON
        System.out.println("Value for non-existent field: " + nonExistentField);
    }

}
