package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.ScreenshotHelper;
import helpers.WebDriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CadastrarContatosTest {

	WebDriver driver;
	
	@Given("Acessar a pagina de autenticacao de usuario")
	public void acessar_a_p_gina_de_autentica_o_de_usu_rio() {
		
		//abrir o navegador do googlechrome
		driver = WebDriverHelper.getInstance();
		
		//acessando a página de autenticação de usuário
		driver.get("http://sergiocontatos-001-site1.ftempurl.com/");
	}

	@Given("Informar o email de acesso {string}")
	public void informar_o_email_de_acesso(String string) {

		//localizar e capturar o campo email
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		element.clear(); //limpar o campo
		element.sendKeys(string); //preencher o campo
	}

	@Given("Informar a senha de acesso {string}")
	public void informar_a_senha_de_acesso(String string) {

		//localizar e capturar o campo senha
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Senha\"]"));
		element.clear(); //limpar o campo
		element.sendKeys(string); //preencher o campo
	}

	@When("Solicitar a realizacao do acesso")
	public void solicitar_a_realiza_o_do_acesso() {

		//localizar e capturar o botão de acesso
		WebElement element = driver.findElement(By.xpath("//*[@id=\"btnAcesso\"]"));
		
		//verificar se o botão está visível e habilitado para clique
		if(element.isDisplayed() && element.isEnabled()) {
			element.click(); //clicando no botão
		}
		else {
			fail("Botão de acesso não habilitado.");
		}
	}

	@Then("Entao sistema autentica o usuario com sucesso")
	public void ent_o_sistema_autentica_o_usu_rio_com_sucesso() {

		//capturar a url obtida após a autenticação
		String urlObtida = driver.getCurrentUrl();
		String urlEsperada = "http://sergiocontatos-001-site1.ftempurl.com/Contatos/Consulta";
		
		//comparando o resultado esperado X resultado obtido
		assertEquals(urlEsperada, urlObtida);
		
		//gerando a evidência
		ScreenshotHelper.print(driver, "Autenticação de usuário com sucesso");
	}

	@Given("Acessar a pagina de cadastro de contatos")
	public void acessar_a_p_gina_de_cadastro_de_contatos() {

		//acessando o endereço da página de cadastro
		driver.get("http://sergiocontatos-001-site1.ftempurl.com/Contatos/Cadastro");
	}

	@Given("Informar o nome do contato {string}")
	public void informar_o_nome_do_contato(String string) {

		//localizar e preencher o campo
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Nome\"]"));
		element.clear(); //limpando o campo
		element.sendKeys(string); //preenchendo o campo
	}

	@Given("Informar a data de nascimento {string}")
	public void informar_a_data_de_nascimento(String string) {

		//localizar e preencher o campo
		WebElement element = driver.findElement(By.xpath("//*[@id=\"DataNascimento\"]"));
		element.clear(); //limpando o campo
		element.sendKeys(string); //preenchendo o campo
	}

	@Given("Informar o telefone {string}")
	public void informar_o_telefone(String string) {

		//localizar e preencher o campo
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Telefone\"]"));
		element.clear(); //limpando o campo
		element.sendKeys(string); //preenchendo o campo
	}

	@Given("Informar o email {string}")
	public void informar_o_email(String string) {

		//localizar e preencher o campo
		WebElement element = driver.findElement(By.xpath("//*[@id=\"Email\"]"));
		element.clear(); //limpando o campo
		element.sendKeys(string); //preenchendo o campo
	}

	@When("Solicitar a realizacao do cadastro")
	public void solicitar_a_realiza_o_do_cadastro() {

		//localizar e clicar no botão de cadastro
		WebElement element = driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]"));
		
		//verificar se o botão está visível e habilitado
		if(element.isDisplayed() && element.isEnabled()) {
			element.click(); //clicando no botão
		}
		else {
			fail("Botão de cadastro não habilitado.");
		}
	}

	@Then("Sistema realiza o cadastro do contato com sucesso")
	public void sistema_realiza_o_cadastro_do_contato_com_sucesso() {

		//localizar e capturar a mensagem
		WebElement element = driver.findElement(By.xpath("//*[@id=\"msgResultado\"]"));
		
		//comparando se a mensagem contem a frase 'cadastrado com sucesso!';
		assertTrue(element.getText().contains("cadastrado com sucesso!"));
		
		//gerando evidência
		ScreenshotHelper.print(driver, "Cadastro de contato com sucesso");
		
		//fechando o navegador
		driver.close();
		driver.quit();
	}
}








