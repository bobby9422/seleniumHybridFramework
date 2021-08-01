package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import pages.loginPage;

public class LoginTest extends BaseTest {
	loginPage lp;
	
	@Test
	public void LoginT() throws IOException {
		prop = new Properties();
		in = new FileInputStream(System.getProperty("user.dir")+"\\res\\input.properties");
		prop.load(in);
		System.out.println(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		page.GetInstance(loginPage.class)
		.loginToGuru99(prop.getProperty("username"), prop.getProperty("password"));
	}
}
