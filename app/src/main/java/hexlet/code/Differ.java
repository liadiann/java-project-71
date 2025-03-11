package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeSet;
import java.util.Map;
import java.util.LinkedHashMap;

public class Differ {

    public static String readFile(String filename) throws Exception {
        var path = Paths.get("src", "test", "resources", filename).toAbsolutePath().normalize();
        return Files.readString(path).trim();
    }

    private static Map<String, Object> parse(String json) throws Exception {
        var objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, new TypeReference<>() { });
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        var json1 = readFile(filepath1);
        var mapJson1 = parse(json1);
        var json2 = readFile(filepath2);
        var mapJson2 = parse(json2);
        var sortedMap = new LinkedHashMap<String, Object>();
        var keys = new TreeSet<>(mapJson1.keySet());
        keys.addAll(mapJson2.keySet());
        keys.forEach(key -> {
            if (!mapJson2.containsKey(key)) {
                sortedMap.put("- " + key, mapJson1.get(key));
            } else if (!mapJson1.containsKey(key)) {
                sortedMap.put("+ " + key, mapJson2.get(key));
            } else if (mapJson1.get(key).equals(mapJson2.get(key))) {
                sortedMap.put("  " + key, mapJson1.get(key));
            } else {
                sortedMap.put("- " + key, mapJson1.get(key));
                sortedMap.put("+ " + key, mapJson2.get(key));
            }
        });
        var objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper.writeValueAsString(sortedMap).replace(",", "")
                .replace("\"", "").replace(" :", ":");
    }
}
