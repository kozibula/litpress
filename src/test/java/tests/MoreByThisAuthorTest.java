package tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoreByThisAuthorTest extends AbstractTest {

	public void navigateToShop(WebDriver driver) {
		WebElement shopLink = driver.findElement(By.linkText("SHOP"));
		shopLink.click();
	}

	public List<WebElement> getCategoriesList(WebDriver driver) {
		WebElement categoriesList = driver.findElement(By.id("NormalSidebar"));
		List<WebElement> categories;
		categories = categoriesList.findElements(By.tagName("li"));
		return categories;

	}

	public List<WebElement> getTitlesList(WebDriver driver) {
		// WebElement titlesList = driver.findElement(By.id("content_detail"));
		List<WebElement> titles = null;
		try {
			titles = driver.findElements(By.className("result_row"));
		} catch (StaleElementReferenceException e) {
			System.out.println(e);
		}
		return titles;
	}

	public boolean checkForMoreByAuthor(WebDriver driver) {
		List<WebElement> productTabs = driver.findElements(By
				.className("togItem"));

		for (WebElement productTab : productTabs) {
			if (productTab.getText().matches("More by this Author")) {
				productTab.click();
				return true;
			}
		}
		return false;
	}

	public void checkMoreLikeThisTitles(WebDriver driver, String author) {

		WebElement moreLikeThisContainer = driver.findElement(By
				.id("bMoreByThisAuthor"));
		List<WebElement> authorNames = moreLikeThisContainer.findElements(By
				.className("bAuthor"));

		for (WebElement authorName : authorNames) {
			String titleName = moreLikeThisContainer.findElement(
					By.className("bTitle")).getText();
			Assert.assertTrue("The author names didn't match on title "
					+ titleName, authorName.getText().matches(author));
		}

	}

	@Test
	public void testForMoreByThis() throws InterruptedException {

		navigateToShop(driver);

		List<WebElement> categories = getCategoriesList(driver);
		List<WebElement> titles = getTitlesList(driver);

		int categoriesCount = categories.size();

		for (int i = 0; i < categoriesCount; i++) {
			categories.get(i).click();

			int titlesCount = titles.size();

			for (int j = 6; j < titlesCount; j++) {

				try {
					titles = getTitlesList(driver);
					titles.get(j).findElement(By.className("bTitle"))
							.findElement(By.tagName("a")).click();
				} catch (Exception e) {
					System.out.print(e.getMessage());
				}

				boolean isMoreByThisAuthorPresent = checkForMoreByAuthor(driver);
				if (isMoreByThisAuthorPresent) {
					String author = driver
							.findElement(By.className("productDetails"))
							.findElement(By.className("bAuthor")).getText();
					checkMoreLikeThisTitles(driver, author);

				}
				Thread.sleep(3000);
				driver.navigate().back();

				if (j == (titlesCount - 1)) {
					driver.findElement(By.linkText("Next")).click();
					j = 0;
				}

			}
		}
	}
}
