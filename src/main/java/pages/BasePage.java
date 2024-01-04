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

public class BasePage {
    protected AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Fazer login']")
    protected MobileElement botaoFazerLogin;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='button back']")
    protected MobileElement voltarBtn;

    @AndroidFindBy(className = "android.widget.EditText")
    protected MobileElement emailInput;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Avançar']")
    protected MobileElement avancarLoginbtn;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='pos-gd-bt-login-input-senha']")
    protected MobileElement senhaInput;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='ENTRAR']")
    protected MobileElement entrarBtn;

    @AndroidFindBy(xpath ="//android.view.View[@text='Boas-vindas!']")
    protected MobileElement home;

    protected void waitForVisibility(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clicarFazerLogin(){
        waitForVisibility(botaoFazerLogin);
        botaoFazerLogin.click();
    }
    public void voltarAppHome() {
        clicarFazerLogin();
        voltarBtn.click();
        waitForVisibility(botaoFazerLogin);
    }

    public void logar(String emailLogin, String senha) {
        clicarFazerLogin();
        waitForVisibility(emailInput);
        emailInput.sendKeys(emailLogin);
        avancarLoginbtn.click();
        senhaInput.sendKeys(senha);
        entrarBtn.click();
    }

    public void validaTelaInicial() {
        try {
            waitForVisibility(home);
            Assert.assertTrue(home.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Elemento 'Boas-vindas!' não está presente na página.");
        }
    }
}
