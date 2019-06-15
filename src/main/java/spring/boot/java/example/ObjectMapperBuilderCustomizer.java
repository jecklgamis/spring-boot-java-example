package spring.boot.java.example;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class ObjectMapperBuilderCustomizer implements Jackson2ObjectMapperBuilderCustomizer {

    public void customize(Jackson2ObjectMapperBuilder builder) {
        builder.modules(new JavaTimeModule());
    }
}
