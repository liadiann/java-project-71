package hexlet.code;

import java.util.TreeSet;
import java.util.LinkedHashMap;

public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {
        var format = filepath1.split("\\.")[1];
        var mapJson1 = Parser.parse(filepath1, format);
        var mapJson2 = Parser.parse(filepath2, format);
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
        return Parser.buildString(sortedMap);
    }
}
