package hexlet.code;

import lombok.Getter;
import lombok.AllArgsConstructor;
@Getter
@AllArgsConstructor
public class ValueForMap {

    private final String condition;
    private final Object oldValue;
    private final Object newValue;

}
