package tests;

import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.ContratarProdutoPage;

public class LoginTest extends BaseTest {

    @Test
    public void voltarParaHome() {
        BasePage basePage = new BasePage(driver);
        basePage.voltarAppHome();
    }

    @Test
    public void logar() {
        BasePage basePage = new BasePage(driver);
        basePage.logar("cibeleds@ciandt.com", "1234@Mudar");
        basePage.validaTelaInicial();

    }
    @Test
    public void acessarChatEsqueciEmail(){
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        basePage.clicarFazerLogin();
        loginPage.acessarChatEsqueciEmail();
    }
    @Test
    public void redirectContratarProduto(){
        ContratarProdutoPage contratarProdutoPage = new ContratarProdutoPage(driver);
        contratarProdutoPage.clicarcontratarProduto();

    }
}
