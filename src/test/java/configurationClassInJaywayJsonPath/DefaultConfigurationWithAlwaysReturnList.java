package configurationClassInJaywayJsonPath;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

import java.util.List;

public class DefaultConfigurationWithAlwaysReturnList  {
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
    public void useDefaultConfigurationWithAlwaysReturnList() {
        Configuration defaultConfig = Configuration.defaultConfiguration()
                .addOptions(Option.ALWAYS_RETURN_LIST);  // Option to always return results as a List

        // Querying the author of the second book, which will always be returned as a List
        List<String> authorList = JsonPath.using(defaultConfig).parse(jsonFile).read("$.bookstore.inventory[1].author");

        // Printing each author found in the list (in this case, only one author)
        for (String author : authorList) {
            System.out.println("Author: " + author);
        }
    }

}
