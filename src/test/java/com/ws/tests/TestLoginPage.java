package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LoginPage;

public class TestLoginPage extends DriverScript {
	
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp()
	{
		initApplication();
		homePage = new HomePage();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		quitDriver();
	}
	
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


