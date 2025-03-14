package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    private static String readFile(String filename) throws Exception {
        if (Paths.get(filename).isAbsolute()) {
            return Files.readString(Paths.get(filename).normalize()).trim();
        }
        var path = Paths.get("src", "test", "resources", "fixtures", filename).toAbsolutePath().normalize();
        return Files.readString(path).trim();
    }

    public static Map<String, Object> parse(String filename, String format) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        if (format.equals("yaml") || format.equals("yml")) {
            objectMapper = new YAMLMapper();
        }
        var str = readFile(filename);
        return objectMapper.readValue(str, new TypeReference<>() {
        });
    }
}
