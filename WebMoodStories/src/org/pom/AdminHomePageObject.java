package org.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePageObject {
	public AdminHomePageObject(WebDriver driver) {
		// Initialize my objects in the page
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	public WebElement txtsearch;
	
	
}
