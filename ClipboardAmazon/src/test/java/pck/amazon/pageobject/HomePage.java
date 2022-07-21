package pck.amazon.pageobject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
	WebDriver Idriver;

	public HomePage(WebDriver pDriver) {
		Idriver = pDriver;
		PageFactory.initElements(pDriver, this);
	}

	@FindBy(id = "nav-hamburger-menu")
	WebElement hamBurger;

	@FindBy(xpath = "//div[contains(text(),'shop by department')]")
	WebElement shopByDepartment;

	@FindBy(xpath = "//div[contains(text(),'TV, Appliances, Electronics')]")
	WebElement tvMenu;

	@FindBy(xpath = "//a[contains(text(),'Televisions')]")
	WebElement tvSubMenu;

	@FindBy(xpath = "//span[normalize-space()='Brands']")
	WebElement brands;

	@FindBy(xpath = "//span[@class='a-size-base a-color-base'][normalize-space()='Samsung']")
	WebElement samsung;

	@FindBy(how = How.CSS, using = ".a-dropdown-prompt")
	WebElement sortBy;

	@FindBy(xpath = "//a[@id='s-result-sort-select_2']")
	WebElement priceHighToLow;

	@FindBy(xpath = "//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_2']//a")
	WebElement searchResult;

	@FindBy(xpath = "//div[@id='feature-bullets']")
	WebElement aboutThisItemDiv;

	@FindBy(xpath = "//h1[normalize-space()='About this item']")
	WebElement aboutItem;

	@FindBy(xpath = "//ul[@class='a-unordered-list a-vertical a-spacing-mini']")
	WebElement aboutItemDetails;

	public void clickHamBurger() {
		WebDriverWait wait = new WebDriverWait(Idriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(hamBurger));
		hamBurger.click();
	}

	public void scrollToDepartment() {
		scrollToElement(Idriver, shopByDepartment);
	}

	public void clickTvMenu() {
		WebDriverWait wait = new WebDriverWait(Idriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(tvMenu));
		tvMenu.click();
	}

	public void clickTvSubMenu() {
		WebDriverWait wait = new WebDriverWait(Idriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(tvSubMenu));
		tvSubMenu.click();
	}

	public void scrollToBrand() {
		scrollToElement(Idriver, brands);
	}

	public void clickSamsung() {
		WebDriverWait wait = new WebDriverWait(Idriver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(samsung));
		samsung.click();
	}

	public void clickSortByPrice() {
		new WebDriverWait(Idriver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(sortBy));
		sortBy.click();
		new WebDriverWait(Idriver, Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(priceHighToLow));
		priceHighToLow.click();

	}

	public void clickSecondSearchResult() {
		try {
			new WebDriverWait(Idriver, Duration.ofSeconds(30))
					.until(ExpectedConditions.elementToBeClickable(searchResult));
			searchResult.click();
			new WebDriverWait(Idriver, Duration.ofSeconds(30)).until(ExpectedConditions.numberOfWindowsToBe(2));

			ArrayList<String> newTab = new ArrayList<String>(Idriver.getWindowHandles());
			// Switch Window
			Idriver.switchTo().window(newTab.get(1));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public String GetAboutItemText() {
		new WebDriverWait(Idriver, Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(aboutThisItemDiv));
		return aboutItem.getText();
	}

	public String GetAboutItemDetailsText() {
		new WebDriverWait(Idriver, Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(aboutThisItemDiv));
		List<WebElement> elmnts = aboutItemDetails.findElements(By.className("a-list-item"));
		StringBuilder result = new StringBuilder();
		//Loop through child li elements and build about item details text
		for (WebElement el : elmnts) {
			result.append(el.getText());
			result.append(System.getProperty("line.separator"));
		}
		return result.toString();
	}

	void scrollToElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}


}
