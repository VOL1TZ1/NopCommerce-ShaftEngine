package Login_Register;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class JsonFileModifier {
    private static File jsonFile;
    private static ObjectNode jsonNode;
    private static ObjectMapper openFile(String filePath) throws IOException {
        // Load the JSON file
        jsonFile = new File(filePath);
        // Read the JSON file into an ObjectNode
        ObjectMapper objectMapper = new ObjectMapper();
        jsonNode = objectMapper.readValue(jsonFile, ObjectNode.class);
        return objectMapper;
    }
    public static void modifyValue(String filePath, String key, String newValue){
        try {
            ObjectMapper mapper = openFile(filePath);
            jsonNode.put(key, newValue);
            // Write the updated JSON back to the file
            mapper.writeValue(jsonFile, jsonNode);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
