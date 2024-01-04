package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.NoSuchElementException;

public class LoginPage {
    protected AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;

    public LoginPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Esqueci meu e-mail']")
    protected MobileElement esqueciEmailBtn;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='ACESSAR O CHAT']")
    protected MobileElement acessarChatBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FALE CONOSCO']")
    protected MobileElement faleConoscoScreen;

    protected void waitForVisibility(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void acessarChatEsqueciEmail() {
        waitForVisibility(esqueciEmailBtn);
        esqueciEmailBtn.click();
        waitForVisibility(acessarChatBtn);
        acessarChatBtn.click();
        waitForVisibility(faleConoscoScreen);
        driver.navigate().back();
    }


}
