package steps;

import demo.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.Duration;

public class RegisterSteps {

    WebDriver driver;
    RegisterPage registerPage;

    @Before("@Register")
    public void abrirBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //espera do elemento
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15)); //espera do carregamento da página
    }
    @After("@Register")
    public void fecharBrowser(){
        driver.quit();
    }

    @AfterStep("@Register")
    public void print(){
        TakesScreenshot screenshot = ((TakesScreenshot) driver); // Convertendo o driver em TakesScreenshot
        byte[] printBytes = screenshot.getScreenshotAs(OutputType.BYTES);
        InputStream printStream = new ByteArrayInputStream(printBytes);
        Allure.addAttachment("Register",printStream);
    }

    @Dado("que eu acesso o site Register")
    public void queEuAcessoOSiteRegister() {
        driver.get("https://demo.automationtesting.in/Register.html");
        registerPage = new RegisterPage(driver);
    }

    @Quando("preencho o campo nome com valor {string}")
    public void preenchoOCampoNomeComValor(String nome) {
        registerPage.preencherNome(nome);
    }

    @E("o campo sobrenome com valor {string}")
    public void oCampoSobrenomeComValor(String sobrenome) {
        registerPage.preencherSobrenome(sobrenome);
    }

    @E("o endereço com o valor {string}")
    public void oEnderecoComOValor(String end) {
        registerPage.preencherEndereco(end);
    }

    @E("o email com o valor {string}")
    public void oEmailComOValor(String email) {
        registerPage.preencherEmail(email);
    }

    @E("o telefone com o valor {string}")
    public void oTelefoneComOValor(String tel) {
        registerPage.preencherTelefone(tel);
    }

    @E("clico na opção de sexo feminino")
    public void clicoNaOpcaoDeSexoFeminino() {
        registerPage.selecionarSexo();
    }

    @E("seleciono a segunda checkbox de hobbies")
    public void selecionoASegundaCheckboxDeHobbies() {
        registerPage.selecionarHobbies();
    }

    @E("seleciono {string} dentro do dropdown de skills")
    public void selecionoDentroDoDropdownDeSkills(String skill) {
        registerPage.selecionarSkills(skill);
    }

    @E("seleciono um país da lista")
    public void selecionoUmPaisDaLista() {
        registerPage.selecionarPais();
    }

    @E("seleciono o ano {string}, o mês {string} e o dia {string}")
    public void selecionoOAnoOMesEODia(String ano, String mes, String dia) {
        registerPage.selecionarAno(ano);
        registerPage.selecionarMes(mes);
        registerPage.selecionarDia(dia);
    }
}
