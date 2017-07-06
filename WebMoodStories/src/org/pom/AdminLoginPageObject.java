package org.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPageObject {

	public AdminLoginPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "email")
	public WebElement txtUserName;

	@FindBy(name = "password")
	public WebElement txtPassWord;

	@FindBy(tagName = "button")
	public WebElement btnLogin;

	@FindBy(linkText = "Forgot Your Password?")
	public WebElement lnkForgotPassword;
	
	// Keyword driven
	public void LogInWithCorrectUser(String email, String pass) {
		txtUserName.sendKeys(email);
		txtPassWord.sendKeys(pass);
		txtUserName.click();
		btnLogin.click();
	}

	

}
