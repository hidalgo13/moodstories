package org.action;

import org.openqa.selenium.WebDriver;


public class WebDriverAction {
	WebDriver driver = null;
	public WebDriverAction(WebDriver driver) {
		this.driver= driver;
	}
	
	public void Close(){
		driver.close();
	}
	
	public void OpenUrl(String url){
		driver.get(url);
	}
}
