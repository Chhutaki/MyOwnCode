package com.ws.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ws.base.DriverScript;
import com.ws.pages.HomePage;
import com.ws.pages.LoginPage;

public class BaseTest extends DriverScript {
	
	protected static ExtentHtmlReporter extent;
	protected static ExtentReports report;
	protected static ExtentTest logger;
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeSuite
	public void setUpReport() 
	{
		extent = new ExtentHtmlReporter("./reports/index.html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
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
		report.flush();
		quitDriver();
	}

}
