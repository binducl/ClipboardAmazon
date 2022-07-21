package pck.amazon.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pck.amazone.utilities.Utility;

public class BaseClass {
	
	Utility util = new Utility();
	public static WebDriver driver;
	public static String baseUrl;
	

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {

		baseUrl = util.getURL();
		

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", util.getChromePath());
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", util.getChromePath());
			driver = new ChromeDriver();
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver", util.getChromePath());
			driver = new ChromeDriver();

		default:
			System.setProperty("webdriver.chrome.driver", util.getChromePath());
			driver = new ChromeDriver();
			break;
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}


}
