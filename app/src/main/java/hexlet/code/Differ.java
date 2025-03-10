package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Differ {

    private static String readFile(String filename) throws Exception {
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
        var sortedMap1 = new TreeMap<>(mapJson1);

        var json2 = readFile(filepath2);
        var mapJson2 = parse(json2);
        var sortedMap2 = new TreeMap<>(mapJson2);

        var keys = new TreeSet<>(sortedMap1.keySet());
        keys.addAll(sortedMap2.keySet());
        var result = new StringBuilder("{\n");
        keys.forEach(key -> {
            if (!sortedMap2.containsKey(key)) {
                var tmp = "  - " + key + ": " + sortedMap1.get(key) + "\n";
                result.append(tmp);
            } else if (!sortedMap1.containsKey(key)) {
                var tmp = "  + " + key + ": " + sortedMap2.get(key) + "\n";
                result.append(tmp);
            } else if (sortedMap1.get(key).equals(sortedMap2.get(key))) {
                var tmp = "    " + key + ": " + sortedMap1.get(key) + "\n";
                result.append(tmp);
            } else {
                var tmp = "  - " + key + ": " + sortedMap1.get(key) + "\n";
                result.append(tmp);
                tmp = "  + " + key + ": " + sortedMap2.get(key) + "\n";
                result.append(tmp);
            }
        });
        result.append("}");
        return result.toString();
    }
}
