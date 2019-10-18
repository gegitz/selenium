import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCampoTreinamento {

	WebDriver driver;
	DSL dsl; 


	@Before
	public  void inicializa() {
		driver = new DriverManager().FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@Test
	public void cadastro() {
		dsl.escreve(By.id("elementosForm:nome"), "Nome tosco");

		dsl.escreve(By.id("elementosForm:sobrenome"), "Sobrenome tosco");

		dsl.clica(By.id("elementosForm:sexo:0"));

		dsl.clica(By.id("elementosForm:comidaFavorita:2"));

		dsl.selecionarCombo(By.id("elementosForm:escolaridade"), "Mestrado");

		dsl.selecionarCombo(By.id("elementosForm:esportes"), "Natacao");
		
		dsl.clica(By.id("elementosForm:cadastrar"));

		Assert.assertEquals(dsl.retornaTexto(By.id("descNome")), "Nome: Nome tosco");

		Assert.assertEquals(dsl.retornaTexto(By.id("descSobrenome")), "Sobrenome: Sobrenome tosco");

		Assert.assertEquals(dsl.retornaTexto(By.id("descSexo")), "Sexo: Masculino");

		Assert.assertEquals(dsl.retornaTexto(By.id("descComida")), "Comida: Pizza");

		Assert.assertEquals(dsl.retornaTexto(By.id("descEscolaridade")), "Escolaridade: mestrado");

		Assert.assertEquals(dsl.retornaTexto(By.id("descEsportes")), "Esportes: Natacao");

		Assert.assertEquals(dsl.retornaTexto(By.id("descSugestoes")), "Sugestoes:");

		termina();

	}
	
	
	@Test
	public void interageComIframe() {		
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		assertEquals(alertMsg, "Frame OK!");
		alert.accept();
		driver.switchTo().defaultContent();
		dsl.escreve(By.id("elementosForm:nome"),alertMsg);
		termina();
	}

	@After
	public void termina() {
		driver.quit();
	}
}
