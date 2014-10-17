package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

	protected WebDriver driver;
	private String baseURL = "https://littlerock.test.devsmm.com/";

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage navigateToHome() {
		driver.navigate().to(baseURL);
		return PageFactory.initElements(driver, HomePage.class);
	}

}
