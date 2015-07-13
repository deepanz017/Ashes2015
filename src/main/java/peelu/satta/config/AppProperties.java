package peelu.satta.config;



import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;


public class AppProperties {
    private final static String DEFAULT_APPLICATION_PROPERTIES_FILE = "ashes2015.properties";
    private final static String APPLICATION_NAME = "app.name";
    private final static String DATABASE_USER_NAME = "database.username";
    private final static String DATABASE_HOST = "database.host";
    private final static String DATABASE_DRIVER = "database.driver";
    private final static String DATABASE_PASSWORD = "database.password";

    private Properties properties = new Properties();
    String environment;

    public AppProperties(String environment) throws IOException {
        this.environment = environment;
        loadApplicationCofiguration(Arrays.asList(DEFAULT_APPLICATION_PROPERTIES_FILE));
    }

    void loadApplicationCofiguration(List<String> fileNames) throws IOException {
        for (String fileName : fileNames) {
            String[] pathParts = {"/props", environment, fileName};
            String filePath = StringUtils.join(pathParts, "/");
            InputStream configStream = this.getClass().getResourceAsStream(filePath);
            properties.load(configStream);
        }
    }

    public String getApplicationName() {
        return properties.getProperty(APPLICATION_NAME, "Ashes2015");
    }

    public String getDatabaseUserName(){ return properties.getProperty(DATABASE_USER_NAME, "peelu");}

    public String getDatabaseHost(){ return properties.getProperty(DATABASE_HOST);}

    public String getDatabaseDriver() { return properties.getProperty(DATABASE_DRIVER);}

    public String getDatabasePassword() { return properties.getProperty(DATABASE_PASSWORD);}


}
