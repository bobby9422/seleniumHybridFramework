package test;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BasePage;
import pages.loginPage;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class BaseTest {

	public WebDriver driver;
	public WebDriverWait wait;
	BasePage page; 
	loginPage lp;
	public Properties prop;
	public FileInputStream in;
	
	@BeforeSuite
	@Parameters({ "browser" })
	public void beforetest(@Optional("chrome") String browser) throws IOException {
		if (browser.equalsIgnoreCase("chrome")) {
			final ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			chromeOptions.addArguments("--headless");
			driver = new ChromeDriver(chromeOptions);
			wait = new WebDriverWait(driver, 15);
			driver.manage().window().maximize();
			page = new BasePage(driver,wait);
			System.out.println("chrome: "+driver);
		}
		
	}

	@AfterTest
	public void afterSuite() {
		driver.close();
	}

}
