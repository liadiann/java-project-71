package hexlet.code;

import hexlet.code.Formatter.StylishFormatter;

public class Differ {

    public static String generate(String filepath1, String filepath2, String formatter) throws Exception {
        var format = filepath1.split("\\.")[1];
        var mapJson1 = Parser.parse(filepath1, format);
        var mapJson2 = Parser.parse(filepath2, format);
        var sortedMap = FormationDiff.calculateDiff(mapJson1, mapJson2);
        String res = "";
        if (formatter.equals("stylish")) {
            res = StylishFormatter.formatIt(sortedMap);
        }
        return res;
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
