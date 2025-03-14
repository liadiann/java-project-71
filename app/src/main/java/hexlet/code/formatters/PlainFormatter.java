package hexlet.code.formatters;

import hexlet.code.ValueForMap;
import java.util.List;
import java.util.Map;

public class PlainFormatter {

    private static final String PROPERTY = "Property ";
    private static final String COMPLEX_VALUE = "[complex value]";
    private static final String WAS_UPDATED = "was updated. ";
    private static final String WAS_ADDED = "was added with value: ";
    private static final String WAS_DELETED = "was removed";

    public static String formatIt(Map<String, ValueForMap> map) {
        var res = new StringBuilder();
        map.forEach((k, v) -> {
            var condition = v.getCondition();
            if (!condition.equals("unchanged")) {
                res.append(PROPERTY).append("'").append(k).append("' ");
            }
            switch (condition) {
                case "deleted":
                    res.append(WAS_DELETED).append("\n");
                    break;
                case "changed":
                    appendUpdate(res, v.getOldValue(), v.getNewValue());
                    break;
                case "added":
                    var value = checkTheComplexity(v.getOldValue()) ? COMPLEX_VALUE : "'" + v.getOldValue() + "'";
                    res.append(WAS_ADDED).append(value).append("\n");
                    break;
                default:
            }
        });
        return res.toString().trim();
    }

    private static boolean checkTheComplexity(Object value) {
        return value instanceof List || value instanceof Integer[]
                || value instanceof String[] || value instanceof Map;
    }

    private static String createStringValue(Object value) {
        if (checkTheComplexity(value)) {
            value = COMPLEX_VALUE;
        } else if (value instanceof String) {
            value = "'" + value + "'";
        }
        return "" + value;
    }

    private static void appendUpdate(StringBuilder str, Object oldValue, Object newValue) {
        oldValue = createStringValue(oldValue);
        newValue = createStringValue(newValue);
        str.append(WAS_UPDATED).append("From ").append(oldValue).append(" to ").append(newValue).append("\n");
    }
}
