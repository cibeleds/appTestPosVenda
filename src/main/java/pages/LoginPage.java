package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Acessar Chat']")
    protected MobileElement acessarChatBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FALE CONOSCO']")
    protected MobileElement faleConoscoScreen;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='pos-gd-bt-cadastro-input-apelido']")
    protected MobileElement inputApelido;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='pos-gd-bt-cadastro-input-senha']")
    protected MobileElement inputSenha;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='pos-gd-bt-cadastro-input-confirmar-senha']")
    protected MobileElement inputConfirmarSenha;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=''][4]")
    protected MobileElement checkPoliticaPriv;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Ativar Cadastro']")
    protected MobileElement ativarCadastroBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Validar Código']")
    protected MobileElement validarCodigoBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Esqueci minha senha']")
    protected MobileElement esqueciSenhaBtn;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='pos-gd-bt-forgot-input-email']")
    protected MobileElement inputEsqueciSenhaEmail;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Enviar']")
    protected MobileElement enviarBtn;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='pos-gd-bt-reset-senha-input-nova-senha']")
    protected MobileElement inputNovaSenha;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='pos-gd-bt-reset-senha-input-nova-senha-confirmar']")
    protected MobileElement inputConfirmaSenha;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Alterar Senha']")
    protected MobileElement alterarSenhaBtn;

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

    public void ativarCadastro(String apelido, String senha){
        waitForVisibility(inputApelido);
        inputConfirmarSenha.click();
        inputApelido.sendKeys(apelido);
        inputSenha.sendKeys(senha);
        inputConfirmarSenha.sendKeys(senha);
        driver.hideKeyboard();
        checkPoliticaPriv.click();
        ativarCadastroBtn.click();
        waitForVisibility(validarCodigoBtn);
    }

    public void alterarSenha(String novaSenha){
        waitForVisibility(esqueciSenhaBtn);
        esqueciSenhaBtn.click();
        waitForVisibility(enviarBtn);
        enviarBtn.click();
        inputNovaSenha.sendKeys(novaSenha);
        inputConfirmaSenha.sendKeys(novaSenha);
        alterarSenhaBtn.click();
        waitForVisibility(validarCodigoBtn);
    }


}
