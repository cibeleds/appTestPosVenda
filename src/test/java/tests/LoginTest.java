package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.ContratarProdutoPage;
import utils.ConfigReader;
import utils.DynamoDB;

public class LoginTest extends BaseTest {

    private ConfigReader configReader = new ConfigReader();

    @Test
    public void voltarParaHome() {
        BasePage basePage = new BasePage(driver);
        basePage.voltarAppHome();
    }

    @Test
    public void logar() {
        BasePage basePage = new BasePage(driver);
        basePage.logar(configReader.getUsername(), configReader.getPassword());
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
        basePage.preencherEmail(configReader.getEmailInativo());
        basePage.clicarAvancar();
        loginPage.ativarCadastro(configReader.getApelido(), configReader.getPassword());
    }

    @Test
    public void esqueciSenha(){
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        basePage.preencherEmail(configReader.getUsername());
        basePage.clicarAvancar();
        loginPage.alterarSenha(configReader.getPassword());

    }
}
