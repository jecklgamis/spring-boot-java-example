package spring.boot.java.example;


import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BuildInfoControllerTest extends BaseAppTest {

    @Test
    public void testBuildInfo() {
        var response = restTemplate.getForObject(format("http://127.0.0.1:%d/buildInfo", port), Map.class);
        assertNotNull(response.get("version"));
        assertNotNull(response.get("branch"));
        assertNotNull(response.get("build-time"));
    }

}
