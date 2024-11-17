package jsonAnnotation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@JsonProperty helps in specifying custom names for fields during serialization and deserialization.
//It can also be used to control the order of properties in the JSON output.
@JsonPropertyOrder({"id", "name", "email"})
//@JsonPropertyOrder(alphabetic = true)
public class JsonPropertyAnnotation {
    private String name;
    private String email;
    private int id;

    public static void main(String[] args) throws JsonProcessingException {
        JsonPropertyAnnotation jsonPropertyOrderPojo = new JsonPropertyAnnotation();
        jsonPropertyOrderPojo.setName("Luke");
        jsonPropertyOrderPojo.setEmail("luke@stars-hollow.com");
        jsonPropertyOrderPojo.setId(1);

        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonPropertyOrderPojo);
        System.out.println(string);
    }
}
