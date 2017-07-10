package org.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.pom.AdminHomePageObject;

public class DriverSetup {

	public WebDriver FirefoxDriverSetup() {
			
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver", ".\\Driver\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		return driver;

	}

	
	public WebDriver ChromeDriverSetup() {
		
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", ".\\Driver\\geckodriver.exe");

		WebDriver driver = new ChromeDriver();
		return driver;

	}
}
