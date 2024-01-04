package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.*;
import utils.DriverManager;

public class BaseTest {
    protected AppiumDriver<MobileElement> driver;

    @BeforeMethod
    public void setUp() {
        // Inicializa o driver utilizando o DriverManager
        driver = DriverManager.getDriver();
    }

//    @AfterMethod
//    public void tearDown() {
//        // Encerra o driver utilizando o DriverManager
//        DriverManager.quitDriver();
//    }
}
