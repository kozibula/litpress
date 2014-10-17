package tests;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import pages.ShopPage;
import pages.TitlePage;

public class NavigateToShopTest extends AbstractTest {

	@Test
	public void getListOfTitles() {
		onHomePage.navigateToShop();

		List<WebElement> titles = onShopPage.getTitles();
		for (WebElement title : titles) {
			try {
				title.findElement(By.tagName("a")).click();
				onTitlePage.checkForMoreLikeThis();
			} catch (StaleElementReferenceException e) {

				System.out.println(e.getMessage() + "\n");
			}

		}

	}

}
