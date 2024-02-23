package com.ws.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ws.base.DriverScript;

public class LoginPage extends DriverScript {

// ****************************************** Page Elements *************************************************//

	@FindBy(id = "Email") WebElement emailTextField;
	@FindBy(name = "Password") WebElement passwordTextField;
	@FindBy(xpath = "//input[@class='button-1 login-button']") WebElement loginButton;
	@FindBy(linkText = "Forgot password?") WebElement forgotPasswordLink;

// ****************************************** Page Initialization *******************************************//

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

// ****************************************** Page Actions/Methods ******************************************//
	
	public void enterEmail(String email) {
		emailTextField.clear();
		emailTextField.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordTextField.sendKeys(password);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public boolean isForgotpasswordLinkPresent() {
		return forgotPasswordLink.isDisplayed();
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

}



