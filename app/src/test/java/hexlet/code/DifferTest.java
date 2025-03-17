package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class DifferTest {

    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJson;

    @BeforeAll
    public static void beforeAll() throws Exception {
        expectedStylish = readFile("resultStylish");
        expectedPlain = readFile("resultPlain");
        expectedJson = readFile("resultJson");
    }

    private static String readFile(String filename) throws Exception {
        if (Paths.get(filename).isAbsolute()) {
            return Files.readString(Paths.get(filename).normalize()).trim();
        }
        var path = Paths.get("src", "test", "resources", "fixtures", filename).toAbsolutePath().normalize();
        return Files.readString(path).trim();
    }
    @ParameterizedTest
    @CsvSource(value = {"file1.json, file2.json", "file1.yaml, file2.yaml"})
    public void testCompareJson(String filename1, String filename2) throws Exception {
        var actual = Differ.generate(filename1, filename2);
        assertEquals(expectedStylish, actual);
        actual = Differ.generate(filename1, filename2, "stylish");
        assertEquals(expectedStylish, actual);
        actual = Differ.generate(filename1, filename2, "plain");
        assertEquals(expectedPlain, actual);
        actual = Differ.generate(filename1, filename2, "json");
        assertEquals(expectedJson, actual);
    }
}
