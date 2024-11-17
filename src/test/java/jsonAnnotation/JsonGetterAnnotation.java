package jsonAnnotation;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonGetterAnnotation {

    private String firstName;
    private String lastName;

    // @JsonGetter annotation is used to customize the name of the getter method (Key) in the JSON output
    @JsonGetter("first_name_in_json")
    public String getFirstName() {
        return firstName;
    }

    @JsonGetter("last_name_in_json")
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static void main(String[] args) throws JsonProcessingException {
        JsonGetterAnnotation jsonGetterPojo = new JsonGetterAnnotation();
        jsonGetterPojo.setFirstName("Lorelai");
        jsonGetterPojo.setLastName("Gilmore");

        // Creating an ObjectMapper instance to handle serialization and deserialization
        ObjectMapper objectMapper = new ObjectMapper();

        // Serializing the object to JSON and customizing the key names using @JsonGetter
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonGetterPojo);
        System.out.println("Serialized JSON:");
        System.out.println(jsonString);

        // Deserialization of the JSON back into the object
        JsonGetterAnnotation deserializedPojo = objectMapper.readValue(jsonString, JsonGetterAnnotation.class);
        System.out.println("\nDeserialized Object:");
        System.out.println("First Name: " + deserializedPojo.getFirstName());
        System.out.println("Last Name: " + deserializedPojo.getLastName());
    }
}
