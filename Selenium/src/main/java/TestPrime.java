import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPrime {

	WebDriver driver;
	DSL dsl; 


	@Before
	public  void inicializa() {
		driver = new DriverManager().FirefoxDriver();
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl = new DSL(driver);
	}
	
	@Test
	public void comboTest() {
		String option = "PS4";
		String label = "Basic:";
		By button = By.xpath(".//span[contains(@class, 'ui-icon-triangle-1-s')]");
		By elementToSearch = By.xpath("//tbody//label[text()='" + label + "']/../../..");
		selectComboOption(option, label, button, elementToSearch);
		option = "Mercedes";
		label = "Grouping: ";
		elementToSearch = By.xpath("//tbody//label[text()='" + label + "']/../../..");
		selectComboOption(option, label, button , elementToSearch);
		
		
	}

	private void selectComboOption(String option, String label, By button, By elementToSearch) {
		dsl.clickOnButtonOnSameLineLabel(label, button, elementToSearch);
		dsl.clica(By.xpath("//*[@data-label='" + option + "']"));
		Assert.assertTrue(driver.findElement(elementToSearch).findElement(button).getText().contains(option));
	}
}
