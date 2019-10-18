import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	
	public WebDriver FirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", "/home/eduardo/Downloads/geckodriver/geckodriver"); // comentar isso depois
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
}
