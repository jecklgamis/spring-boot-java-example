package spring.boot.java.example;


import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbeControllerTest extends BaseAppTest {

    @Test
    public void testLivenessProbe() {
        var response = restTemplate.getForObject(format("http://127.0.0.1:%d/probe/live", port), Map.class);
        assertEquals("I'm alive!", response.get("message"));
    }

    @Test
    public void testReadinessProbe() {
        var response = restTemplate.getForObject(format("http://127.0.0.1:%d/probe/ready", port), Map.class);
        assertEquals("I'm ready!", response.get("message"));
    }

}
