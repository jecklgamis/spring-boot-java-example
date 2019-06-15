package spring.boot.java.example;

import org.eclipse.jetty.server.NetworkTrafficServerConnector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExampleApp {

    public static void main(String args[]) {
        SpringApplication.run(ExampleApp.class, args);
    }

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory(@Value("${server.http.port}") int httpPort) {
        final JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.addServerCustomizers(server -> {
            final NetworkTrafficServerConnector connector = new NetworkTrafficServerConnector(server);
            connector.setPort(httpPort);
            server.addConnector(connector);
        });
        return factory;
    }

}

