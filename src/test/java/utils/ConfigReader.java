package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final String CONFIG_FILE = "config.properties";
    private Properties properties;

    public ConfigReader() {
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            properties = new Properties();
            if (input == null) {
                System.out.println("Desculpe, o arquivo de configuração '" + CONFIG_FILE + "' não foi encontrado.");
                return;
            }
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getApelido() {
        return properties.getProperty("apelido");
    }

    public String getEmailInativo() {
        return properties.getProperty("emailInativo");
    }

    public String getPathApp() {
        return properties.getProperty("pathApp");
    }

}
