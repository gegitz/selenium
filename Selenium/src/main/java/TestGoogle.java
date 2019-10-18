import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestGoogle {
	
	@Test
	public void test() {
		System.setProperty("webdriver.gecko.driver", "/home/eduardo/Downloads/geckodriver/geckodriver"); // comentar isso depois
		WebDriver driver = new FirefoxDriver();
		driver.get("https://google.com");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
}
