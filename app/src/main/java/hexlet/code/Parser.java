package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String fileContent, String format) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        if (format.equals("yaml") || format.equals("yml")) {
            objectMapper = new YAMLMapper();
        }
        return objectMapper.readValue(fileContent, new TypeReference<>() {
        });
    }
}
