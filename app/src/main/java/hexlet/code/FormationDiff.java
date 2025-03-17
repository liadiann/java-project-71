package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

public class FormationDiff {

    public static LinkedHashMap<String, InternalRepresentationOfTheDiff> calculate(
            Map<String, Object> parsedFileContent1, Map<String, Object> parsedFileContent2) {
        var diff = new LinkedHashMap<String, InternalRepresentationOfTheDiff>();
        var keys = new TreeSet<>(parsedFileContent1.keySet());
        keys.addAll(parsedFileContent2.keySet());
        keys.forEach(key -> {
            if (!parsedFileContent2.containsKey(key)) {
                diff.put(key, new InternalRepresentationOfTheDiff("deleted",
                        parsedFileContent1.get(key), null));
            } else if (!parsedFileContent1.containsKey(key)) {
                diff.put(key, new InternalRepresentationOfTheDiff("added",
                        parsedFileContent2.get(key), parsedFileContent2.get(key)));
            } else if (parsedFileContent1.get(key) == (parsedFileContent2.get(key))
                    || (parsedFileContent1.get(key) != null && parsedFileContent2.get(key) != null
                    && parsedFileContent1.get(key).equals(parsedFileContent2.get(key)))) {
                diff.put(key, new InternalRepresentationOfTheDiff("unchanged",
                        parsedFileContent1.get(key), parsedFileContent1.get(key)));
            } else {
                diff.put(key, new InternalRepresentationOfTheDiff("changed", parsedFileContent1.get(key),
                        parsedFileContent2.get(key)));
            }
        });
        return diff;
    }
}
