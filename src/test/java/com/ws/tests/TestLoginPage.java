package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseTest {
	

	@Test(priority = 1)
	public void testHomePageTitle() 
	{
		logger = report.createTest("Validating HomePage Title");
		String title = homePage.getHomePageTitle();
		logger.pass("got the homepage title");
		Assert.assertTrue(title.contains("Demo Web Shop"));
		logger.pass("verified homepage title successuflly");
	}
	
	@Test(priority = 2)
	public void testLoginFunction() {
		logger = report.createTest("Validating Login Function");
		homePage.clickLogin();
		logger.pass("clicked login link");
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertTrue(loginPageTitle.contains("Login"));
		logger.pass("verified login title successuflly");
		loginPage.enterEmail("selauto1@test.com");
		logger.pass("entered username");
		loginPage.enterPassword("Pass@123");
		logger.pass("entered password");
		loginPage.clickLoginButton();
		logger.pass("clicked login button");
		String title = homePage.getHomePageTitle();
		Assert.assertTrue(title.contains("Demo Web Shop"));
		logger.pass("verified homepage title successuflly");
		homePage.clickLogout();
		logger.pass("clicked logout link");
	}
	
	@Test(priority = 3)
	public void testIsForgotpasswordLinkPresent() 
	{
		logger = report.createTest("Validating ForgotPassword Link is Present");
		homePage.clickLogin();
		logger.pass("clicked login link");
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertTrue(loginPageTitle.contains("Login"));
		boolean flag = loginPage.isForgotpasswordLinkPresent();
		Assert.assertTrue(flag);
		logger.pass("forgot password link is present");
	}

}


