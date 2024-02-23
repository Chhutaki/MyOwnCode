package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseTest {
	

	@Test(priority = 1)
	public void testHomePageTitle() 
	{
		String title = homePage.getHomePageTitle();
		Assert.assertTrue(title.contains("Demo Web Shop"));	
	}
	
	@Test(priority = 2)
	public void testLoginFunction() {
		homePage.clickLogin();
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertTrue(loginPageTitle.contains("Login"));
		loginPage.enterEmail("selauto1@test.com");
		loginPage.enterPassword("Pass@123");
		loginPage.clickLoginButton();
		String title = homePage.getHomePageTitle();
		Assert.assertTrue(title.contains("Demo Web Shop"));
		homePage.clickLogout();
	}
	
	@Test(priority = 3)
	public void testIsForgotpasswordLinkPresent() 
	{
		homePage.clickLogin();
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertTrue(loginPageTitle.contains("Login"));
		boolean flag = loginPage.isForgotpasswordLinkPresent();
		Assert.assertTrue(flag);
	}

}


