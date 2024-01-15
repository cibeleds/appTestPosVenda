package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.ContratarProdutoPage;
import utils.DynamoDB;

public class LoginTest extends BaseTest {

    @Test
    public void voltarParaHome() {
        BasePage basePage = new BasePage(driver);
        basePage.voltarAppHome();
    }

    @Test
    public void logar() {
        BasePage basePage = new BasePage(driver);
        basePage.logar("cibele.silva@terceirizadoraizen.com", "1234@Mudar");
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

    @Test
    public void ativarCadastro(){
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        basePage.preencherEmail("cibeleds@ciandt.com");
        basePage.clicarAvancar();
        loginPage.ativarCadastro("Auto Teste","1234@Mudar");
    }

    @Test
    public void esqueciSenha(){
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        basePage.preencherEmail("cibele.silva@terceirizadoraizen.com");
        basePage.clicarAvancar();
        loginPage.alterarSenha("1234@Mudar");

    }
}
