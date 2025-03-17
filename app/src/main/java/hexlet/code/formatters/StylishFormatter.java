package hexlet.code.formatters;

import java.util.Map;
import hexlet.code.InternalRepresentationOfTheDiff;

public class StylishFormatter {

    private static String definePrefix(String condition) {
        return switch (condition) {
            case "added" -> "+ ";
            case "deleted" -> "- ";
            case "unchanged" -> "  ";
            default -> "-+";
        };
    }

    public static String formatIt(Map<String, InternalRepresentationOfTheDiff> diff) {
        var res = new StringBuilder("{\n");
        diff.forEach((k, v) -> {
            res.append(" ".repeat(2));
            var condition = definePrefix(v.getCondition());
            if (condition.equals("-+")) {
                res.append("- ").append(k).append(": ").append(v.getOldValue()).append("\n");
                res.append(" ".repeat(2));
                res.append("+ ").append(k).append(": ").append(v.getNewValue()).append("\n");
            } else {
                res.append(condition).append(k).append(": ").append(v.getOldValue()).append("\n");
            }
        });
        res.append("}");
        return res.toString();
    }
}
