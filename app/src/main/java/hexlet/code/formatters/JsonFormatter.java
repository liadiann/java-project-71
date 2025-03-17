package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import hexlet.code.InternalRepresentationOfTheDiff;
import java.util.Map;

public class JsonFormatter {

    public static String formatIt(Map<String, InternalRepresentationOfTheDiff> diff) throws Exception {
        var objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper.writeValueAsString(diff);
    }

}
