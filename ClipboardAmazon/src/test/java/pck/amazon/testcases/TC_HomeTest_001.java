package pck.amazon.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import pck.amazon.pageobject.HomePage;

public class TC_HomeTest_001 extends BaseClass {
	@Test
	public void clickHamburger() throws InterruptedException {
		try
		{
		//get Amazon Home page
		System.out.println("Go to Amazon home page");
		driver.get(baseUrl);
		//maximize browser window
		System.out.println("Maximize browser window");
		driver.manage().window().maximize();
		
		HomePage home = new HomePage(driver);

		System.out.println("Click on hamburger menu");
		home.clickHamBurger();
		System.out.println("Scroll on and then Click on the TV, Appliances and Electronics link under Shop by Department section");
		home.scrollToDepartment();
		home.clickTvMenu();
		System.out.println("Then click on Televisions under Tv, Audio & Cameras sub section");
		home.clickTvSubMenu();
		System.out.println("Scroll down and filter the results by Brand ‘Samsung’.");
		home.scrollToBrand();
		home.clickSamsung();
		System.out.println("Sort the Samsung results with price High to Low.");
		home.clickSortByPrice();
		System.out.println("Click on the second highest priced item.");
		home.clickSecondSearchResult();

		String aboutItem = home.GetAboutItemText().trim().toLowerCase();

		System.out.println("Assert that “About this item” section is present and log this section text to console/report");
		if (aboutItem.equals("about this item")) {
			System.out.println(home.GetAboutItemDetailsText());
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

}
