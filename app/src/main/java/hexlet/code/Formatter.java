package hexlet.code;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;
import java.util.Map;

public class Formatter {
    public static String formatIt(String formatName,
                                  Map<String, InternalRepresentationOfTheDiff> diff) throws Exception {
        return switch (formatName) {
            case "stylish" -> StylishFormatter.formatIt(diff);
            case "plain" -> PlainFormatter.formatIt(diff);
            case "json" -> JsonFormatter.formatIt(diff);
            default -> throw new Exception("wrong format");
        };
    }
}
