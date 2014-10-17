package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage extends AbstractPage {

	public ShopPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "content_detail")
	public WebElement titlesList;

	public List<WebElement> getTitles() {
		List<WebElement> titles = titlesList.findElements(By
				.className("bTitle"));
		return titles;
	}
}
