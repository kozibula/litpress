package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "nav_shop")
	private WebElement shopLink;

	public ShopPage navigateToShop() {
		shopLink.click();
		return PageFactory.initElements(driver, ShopPage.class);
	}
}
