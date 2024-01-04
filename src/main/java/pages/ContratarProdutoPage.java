package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContratarProdutoPage {
    protected AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;

    public ContratarProdutoPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Contratar um produto']")
    protected MobileElement contratarProdutoBtn;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='SIMULAR']")
    protected MobileElement simularBtn;



    protected void waitForVisibility(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void clicarcontratarProduto() {
        waitForVisibility(contratarProdutoBtn);
        contratarProdutoBtn.click();
        waitForVisibility(simularBtn);
    }


}
