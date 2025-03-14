package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static String expectedStylish;
    private static String expectedPlain;

    @BeforeAll
    public static void beforeAll() throws Exception {
        expectedStylish = readFile("resultStylish");
        expectedPlain = readFile("resultPlain");
    }

    private static String readFile(String filename) throws Exception {
        var path = Paths.get("src", "test", "resources", filename).toAbsolutePath().normalize();
        return Files.readString(path).trim();
    }

    @Test
    public void testCompareJson() throws Exception {
        var filename1 = "file1.json";
        var filename2 = "file2.json";
        var actual = Differ.generate(filename1, filename2);
        assertEquals(expectedStylish, actual);
        actual = Differ.generate(filename1, filename2, "plain");
        assertEquals(expectedPlain, actual);
    }

    @Test
    public void testCompareYml() throws Exception {
        var filename1 = "file1.yaml";
        var filename2 = "file2.yaml";
        var actual = Differ.generate(filename1, filename2, "stylish");
        assertEquals(expectedStylish, actual);
        actual = Differ.generate(filename1, filename2, "plain");
        assertEquals(expectedPlain, actual);
    }
}
