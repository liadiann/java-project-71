package hexlet.code.Formatter;

import java.util.Map;

public class StylishFormatter {

    public static String formatIt(Map<String, Object> map) {
        var res = new StringBuilder("{\n");
        map.forEach((k, v) -> {
            res.append(" ".repeat(2));
            res.append(k);
            res.append(": ");
            res.append(v);
            res.append("\n");
        });
        res.append("}");
        return res.toString();
    }
}
