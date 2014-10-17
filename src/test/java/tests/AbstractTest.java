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
	protected HomePage onHomePage;
	protected ShopPage onShopPage;
	protected TitlePage onTitlePage;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		onShopPage = PageFactory.initElements(driver, ShopPage.class);
		onTitlePage = PageFactory.initElements(driver, TitlePage.class);
		onHomePage = PageFactory.initElements(driver, HomePage.class);

		onHomePage.navigateToHome();
	}

	@After
	public void tearDown() {
		driver.close();
	}

}
