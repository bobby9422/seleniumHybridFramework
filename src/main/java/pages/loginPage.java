package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends BasePage{
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement user99GuruName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password99Guru;

	@FindBy(xpath = "//h2[text()=' Secure Area']")
	WebElement titleText;

	@FindBy(xpath = "//a[@href='/logout'] ")
	WebElement logout;

	public loginPage(WebDriver driver,WebDriverWait wait) {
		 super(driver, wait);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String strUserName) {

		user99GuruName.sendKeys(strUserName);
	}

	public void setPassword(String strPassword) {

		password99Guru.sendKeys(strPassword);
		password99Guru.submit();

	}

	public String getLoginTitle() {

		return titleText.getText();

	}
	public void Logout() {

		logout.click();

	}

	public void loginToGuru99(String strUserName, String strPasword) {
		this.setUserName(strUserName);
		this.setPassword(strPasword);
		assertEquals(this.getLoginTitle(),"Secure Area","Login failed");
		this.Logout();
	}
	

}