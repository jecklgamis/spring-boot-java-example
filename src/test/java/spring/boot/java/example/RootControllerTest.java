package spring.boot.java.example;


import org.junit.jupiter.api.Test;

import java.util.Map;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RootControllerTest extends BaseAppTest {

    @Test
    public void testRootEndPoint() {
        var response = restTemplate.getForObject(format("http://127.0.0.1:%d/", port), Map.class);
        assertEquals("It works on my machine!", response.get("message"));
    }

}
