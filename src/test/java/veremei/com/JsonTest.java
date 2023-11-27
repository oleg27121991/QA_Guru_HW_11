package veremei.com;

import com.fasterxml.jackson.databind.ObjectMapper;
import veremei.com.json.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonTest {
    ClassLoader cl = JsonTest.class.getClassLoader();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("Проверка содержимого Json ответа")
    void checkJsonAnswerTest() throws Exception {

        try (
                InputStream resource = cl.getResourceAsStream("JsonTest.json")
        ) {
            assert resource != null;
            try (InputStreamReader reader = new InputStreamReader(resource)
            ) {
                Json json = objectMapper.readValue(reader, Json.class);
                assertThat(json.getName()).isEqualTo("Smart Home Assistant");
                assertThat(json.getType()).isEqualTo("device");
                assertThat(json.getFunctions()).contains("Voice control",
                            "Environmental monitoring",
                            "Home automation",
                            "Integration with smart devices");

            }
        }
    }
}
