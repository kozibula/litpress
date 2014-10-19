package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;
import pages.ShopPage;
import pages.TitlePage;

public class AbstractTest {

	protected WebDriver driver;
	private String baseURL = "https://littlerock.test.devsmm.com/";


	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(baseURL);


	}

	@After
	public void tearDown() {
		driver.close();
	}

}
