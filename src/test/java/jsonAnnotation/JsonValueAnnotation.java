package jsonAnnotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonValueAnnotation {
    private String name;
    private String email;
    private int id;

    // Using @JsonValue to indicate that this method's return value will be serialized as the object value
    @com.fasterxml.jackson.annotation.JsonValue
    public String getEmail() {
        return this.email;
    }

    public static void main(String[] args) throws JsonProcessingException {
        JsonValueAnnotation jsonValue = new JsonValueAnnotation();
        jsonValue.setName("rory");
        jsonValue.setEmail("rorygilmore@gmail.com");
        jsonValue.setId(8);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonValue);
        System.out.println(jsonString);
    }
}
