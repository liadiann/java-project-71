package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {

	private static String readFile(String filename) throws Exception {
		var path = Paths.get("src", "test", "resources", "fixtures", filename).toAbsolutePath().normalize();
		return Files.readString(path).trim();
	}

	private static Map<String, Object> parse(String json) throws Exception {
		var objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, new TypeReference<Map<String, Object>>(){});
	}

	public static String generate(String filepath1, String filepath2) throws Exception {
		var json1 = readFile(filepath1);
		var mapJson1 = parse(json1);
		var json2 = readFile(filepath2);
		var mapJson2 = parse(json2);
		return json2;
	}
}
