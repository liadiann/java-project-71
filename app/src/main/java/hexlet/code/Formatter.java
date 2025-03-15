package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;
import java.util.Map;

public class Formatter {
    public static String formatIt(String formatName, Map<String, ValueForMap> map) throws Exception {
        return switch (formatName) {
            case "stylish" -> StylishFormatter.formatIt(map);
            case "plain" -> PlainFormatter.formatIt(map);
            case "json" -> JsonFormatter.formatIt(map);
            default -> throw new Exception("wrong format");
        };
    }
}
