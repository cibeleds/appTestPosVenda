package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static AppiumDriver<MobileElement> driver;
    private static ConfigReader configReader = new ConfigReader();

    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    private static void initializeDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("deviceName", "com.raizenpower.app.MainActivity");
        capabilities.setCapability("appium:app", configReader.getPathApp());

        try {
            // Inicializa o driver baseado nas capacidades fornecidas
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha ao inicializar o driver do Appium");
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
