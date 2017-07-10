package org.bus;

import org.testng.annotations.Test;

import jxl.read.biff.BiffException;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.pom.AdminLoginPageObject;
import org.setup.DriverSetup;
import org.setup.ExcelLib;
import org.testng.annotations.AfterTest;

public class TestLoginOnChrome {

	WebDriver driver = null;
	ExcelLib excel = null;
	AdminLoginPageObject adminLoginPage = null;
	@BeforeTest
	public void beforeTest() throws BiffException, IOException {
		DriverSetup setup = new DriverSetup();
		//driver = setup.FirefoxDriverSetup();
		driver = setup.ChromeDriverSetup();
		adminLoginPage = new AdminLoginPageObject(driver);
		excel = new ExcelLib(".\\TestData\\UserAdmin.xls");
		excel.ColumnDictionary();
	}

	@Test
	public void TestLogin() throws InterruptedException {
		int colnumber = excel.GetCell("User");
		
		String username = excel.ReadCell(colnumber, 1);
		String password = excel.ReadCell(excel.GetCell("Pass"), 1);
		//Navigate to MoodStories login page
		driver.navigate().to("http://sample-env-1.tjibmamzsj.eu-west-1.elasticbeanstalk.com");
		
		Thread.sleep(3000);
		//Call login function - Login with correct user
		adminLoginPage.LogInWithCorrectUser(username, password);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
