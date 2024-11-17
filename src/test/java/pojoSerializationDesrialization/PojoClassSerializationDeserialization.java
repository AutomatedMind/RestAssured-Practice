package pojoSerializationDesrialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

// Class demonstrating POJO usage for serialization and deserialization
public class PojoClassSerializationDeserialization {
    // Fields representing details of troops
    private String troopName;
    private String leaderName;
    private String motto;
    private List<String> skills; // List of skills or attributes of the troop

    // Getters and setters
    public String getTroopName() {
        return troopName;
    }

    public void setTroopName(String troopName) {
        this.troopName = troopName;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public static void main(String[] args) throws JsonProcessingException {
        // Creating an instance of the POJO and setting properties for Stark troops
        PojoClassSerializationDeserialization starkTroops = new PojoClassSerializationDeserialization();
        starkTroops.setTroopName("Stark Troops");
        starkTroops.setLeaderName("Jon Snow");
        starkTroops.setMotto("Winter is coming");
        starkTroops.setSkills(Arrays.asList("Swordsmanship", "Leadership", "Loyalty"));

        // Displaying the POJO details before serialization
        System.out.println("Before Serialization (Object format):");
        System.out.println("Troop Name: " + starkTroops.getTroopName());
        System.out.println("Leader Name: " + starkTroops.getLeaderName());
        System.out.println("Motto: " + starkTroops.getMotto());
        System.out.println("Skills: " + starkTroops.getSkills());

        // Serializing the POJO to JSON format
        System.out.println("\nAfter Serialization (JSON format):");
        ObjectMapper objectMapper = new ObjectMapper();
        String troopsJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(starkTroops);
        System.out.println(troopsJson);

        // Deserializing the JSON back into a POJO
        System.out.println("\nAfter Deserialization (Back to Object format):");
        PojoClassSerializationDeserialization deserializedTroops = objectMapper.readValue(troopsJson, PojoClassSerializationDeserialization.class);
        System.out.println("Troop Name: " + deserializedTroops.getTroopName());
        System.out.println("Leader Name: " + deserializedTroops.getLeaderName());
        System.out.println("Motto: " + deserializedTroops.getMotto());
        System.out.println("Skills: " + deserializedTroops.getSkills());
    }
}
