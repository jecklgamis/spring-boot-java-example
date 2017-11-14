package springboot.java.example;

import com.fasterxml.jackson.datatype.joda.JodaModule;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapperBuilderCustomizer implements Jackson2ObjectMapperBuilderCustomizer {

    public void customize(Jackson2ObjectMapperBuilder builder) {
        builder.modules(new JodaModule());
    }
}
