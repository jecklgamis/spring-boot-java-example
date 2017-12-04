package springboot.java.example;

import org.eclipse.jetty.server.NetworkTrafficServerConnector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExampleApp {
    public static void main(String args[]) {

        SpringApplication.run(ExampleApp.class, args);
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory();
        factory.addServerCustomizers(server -> {
            final NetworkTrafficServerConnector connector = new NetworkTrafficServerConnector(server);
            connector.setPort(8080);
            server.addConnector(connector);
        });
        return factory;
    }

}

