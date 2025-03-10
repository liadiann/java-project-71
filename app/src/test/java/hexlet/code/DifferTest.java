package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static String readFile(String filename) throws Exception {
        var path = Paths.get("src", "test", "resources", filename).toAbsolutePath().normalize();
        return Files.readString(path).trim();
    }

    @Test
    public void testCompare() throws Exception {
        var filename1 = "file1.json";
        var filename2 = "file2.json";
        var actual = Differ.generate(filename1, filename2);
        var expected = readFile("result");
        assertEquals(expected, actual);
    }

}
