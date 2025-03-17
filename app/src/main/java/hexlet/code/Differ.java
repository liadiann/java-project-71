package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Differ {

    private static String readFile(String filename) throws Exception {
        if (Paths.get(filename).isAbsolute()) {
            return Files.readString(Paths.get(filename).normalize()).trim();
        }
        var path = Paths.get("src", "test", "resources", "fixtures", filename).toAbsolutePath().normalize();
        return Files.readString(path).trim();
    }

    public static String generate(String filepath1, String filepath2, String formatter) throws Exception {
        var format = filepath1.split("\\.")[1];
        var fileContent1 = readFile(filepath1);
        var fileContent2 = readFile(filepath2);
        var parsedFileContest1 = Parser.parse(fileContent1, format);
        var parsedFileContest2 = Parser.parse(fileContent2, format);
        var diff = FormationDiff.calculate(parsedFileContest1, parsedFileContest2);
        return Formatter.formatIt(formatter, diff);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
