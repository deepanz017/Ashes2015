package peelu.satta.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import peelu.satta.config.AppProperties;

import java.io.IOException;

@Configuration
@ComponentScan("peelu.satta")
@Import({PersistenceConfiguration.class, WebConfiguration.class})
public class AshesAppConfiguration {
    private static final String DEFAULT_ENV = "uat";
    private static final String ENV_KEY = "env";

    @Bean(name= "applicationProperties")
    AppProperties appProperties() throws IOException {
        return new AppProperties(System.getProperty(ENV_KEY,DEFAULT_ENV));
    }


}
