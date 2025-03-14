package hexlet.code;

public class Differ {

    public static String generate(String filepath1, String filepath2, String formatter) throws Exception {
        var format = filepath1.split("\\.")[1];
        var map1 = Parser.parse(filepath1, format);
        var map2 = Parser.parse(filepath2, format);
        var sortedMap = FormationDiff.calculateDiff(map1, map2);
        return Formatter.formatIt(formatter, sortedMap);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
