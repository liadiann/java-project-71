package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    private static String readFile(String filename) throws Exception {
        var path = Paths.get("src", "test", "resources", filename).toAbsolutePath().normalize();
        return Files.readString(path).trim();
    }

    public static Map<String, Object> parse(String filename, String format) throws Exception {
        ObjectMapper objectMapper;
        switch (format) {
            case "yaml":
            case "yml":
                objectMapper = new YAMLMapper();
                break;
            default:
                objectMapper = new ObjectMapper();
        }
        var str = readFile(filename);
        return objectMapper.readValue(str, new TypeReference<>() {
        });
    }

    public static String buildString(Map<String, Object> map) throws Exception {
        var objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper.writeValueAsString(map).replace(",", "")
                .replace("\"", "").replace(" :", ":");
    }
}
