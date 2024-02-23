package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ws.base.DriverScript;

/*
 * Title: HomePage
 * Description: HomePage class which contains elements and its methods
 * Developed By: John Developed Date: 21/2/2024
 * Approved / Verified By: john@gmail.com
 */

public class HomePage extends DriverScript {
	
// ****************************************** Page Elements *************************************************//
	
	@FindBy(linkText = "Log in") WebElement loginLink;
	@FindBy(linkText = "Log out") WebElement logoutLink;
	
// ****************************************** Page Initialization *******************************************//
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
// ****************************************** Page Actions/Methods ******************************************//
	
	public void clickLogout() {
		logoutLink.click();
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public void clickLogin() {
		loginLink.click();
	}

}
