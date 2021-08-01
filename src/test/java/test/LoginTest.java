package test;

import org.testng.annotations.Test;

import pages.loginPage;

public class LoginTest extends BaseTest {
	loginPage lp;
	
	@Test
	public void LoginT() {
		driver.get(prop.getProperty("url"));
		page.GetInstance(loginPage.class)
		.loginToGuru99(prop.getProperty("username"), prop.getProperty("password"));
	}
}
