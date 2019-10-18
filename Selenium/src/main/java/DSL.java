import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	public void escreve(By by, String texto) {
		driver.findElement(by).sendKeys(texto);
	}

	public void clica(By by) {
		driver.findElement(by).click();
	}
	
	public void clicaDuasVezes(By by) {
		driver.findElement(by).click();
	}
	
	public void selecionarCombo(By by, String options) {
		Select combo = new Select (driver.findElement(by));
		combo.selectByVisibleText(options);
		
	}
	
	public String retornaTexto(By by) {
		return driver.findElement(by).getText();
	}
	
	public void clickOnButtonOnSameLineLabel(String label, By button, By elementToSearch) {
		driver.findElement(elementToSearch).findElements(button).get(retornaIdxlinha(label, elementToSearch) - 1).click();
	}
	
	private int retornaIdxlinha (String nomeLabel, By tabela) {
		int indexLinha = 0;
		List<WebElement> labels = driver.findElement(tabela).findElements(By.xpath(".//td/label"));
		for (WebElement label : labels) {
			indexLinha ++;
			if(label.getText().compareTo(nomeLabel.trim()) == 0)
				return indexLinha;
		}
		return -1;
	}
}
