package veremei.com.json;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Json {
    private final String name;
    private final String type;
    private final String[] functions;

    @JsonCreator
    public Json(@JsonProperty("name") String name,
                @JsonProperty("type") String type,
                @JsonProperty("functions") String[] functions) {
        this.name = name;
        this.type = type;
        this.functions = functions;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String[] getFunctions() {
        return functions;
    }
}