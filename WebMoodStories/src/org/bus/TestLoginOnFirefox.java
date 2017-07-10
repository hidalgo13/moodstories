package org.bus;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.pom.AdminLoginPageObject;
import org.setup.DriverSetup;
import org.setup.ExcelLib;
import org.setup.ExcelReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;

public class TestLoginOnFirefox {

	WebDriver driver = null;
	ExcelReader excel = null;
	XSSFSheet sheet = null;
	XSSFRow row = null;
	XSSFCell cell = null;
	AdminLoginPageObject adminLoginPage = null;
	@BeforeTest
	public void beforeTest() throws BiffException, IOException {
		DriverSetup setup = new DriverSetup();
		driver = setup.FirefoxDriverSetup();
		adminLoginPage = new AdminLoginPageObject(driver);
		excel = new ExcelReader(".\\TestData\\UserAdmin.xlsx");
	}

	@Test
	public void TestLogin() throws InterruptedException, IOException {
		excel.open();
		sheet = excel.getSheet("Admin");
		row = sheet.getRow(1);
		cell = row.getCell(1);
		String username = cell.getStringCellValue();
		row = sheet.getRow(1);
		cell = row.getCell(2);
		String password = cell.getStringCellValue();
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
