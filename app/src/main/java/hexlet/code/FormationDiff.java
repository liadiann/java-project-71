package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

public class FormationDiff {

    public static LinkedHashMap<String, ValueForMap> calculateDiff(Map<String, Object> map1, Map<String, Object> map2) {
        var sortedMap = new LinkedHashMap<String, ValueForMap>();
        var keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        keys.forEach(key -> {
            if (!map2.containsKey(key)) {
                sortedMap.put(key, new ValueForMap("deleted", map1.get(key), null));
            } else if (!map1.containsKey(key)) {
                sortedMap.put(key, new ValueForMap("added", map2.get(key), map2.get(key)));
            } else if (map1.get(key) == (map2.get(key)) || (map1.get(key) != null
                    && map2.get(key) != null && map1.get(key).equals(map2.get(key)))) {
                sortedMap.put(key, new ValueForMap("unchanged", map1.get(key), map1.get(key)));
            } else {
                sortedMap.put(key, new ValueForMap("changed", map1.get(key), map2.get(key)));
            }
        });
        return sortedMap;
    }
}
