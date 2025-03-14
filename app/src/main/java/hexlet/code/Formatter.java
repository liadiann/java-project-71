package hexlet.code;

import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;
import java.util.Map;

public class Formatter {
    public static String formatIt(String formatName, Map<String, ValueForMap> map) {
        return switch (formatName) {
            case "stylish" -> StylishFormatter.formatIt(map);
            case "plain" -> PlainFormatter.formatIt(map);
            default -> "error";
        };
    }
}
