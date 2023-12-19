package spring.boot.java.example.controller;

import com.google.common.collect.ImmutableMap;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RootController {
    @Value("${application.name}")
    private String appName;

    @RequestMapping(path = {"/"}, method = {GET}, produces = {"application/json"})
    @Timed
    public Map<Object, Object> root() {
        return ImmutableMap.builder()
                .put("name", appName)
                .put("message", "It works on my machine!")
                .build();
    }
}
