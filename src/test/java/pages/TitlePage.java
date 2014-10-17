package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TitlePage extends AbstractPage {

	public TitlePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(className = "tabs")
	private WebElement tabs;

	public TitlePage checkForMoreLikeThis() {

		List<WebElement> tabsList = tabs.findElements(By.className("togItem"));
		for (WebElement tab : tabsList)
			if (tab.getText().contains("More by this Author")) {
				tab.click();
				System.out.println("More like this is clicked!");
			}
		driver.navigate().back();

		return PageFactory.initElements(driver, TitlePage.class);
	}
}
