package com.ws.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverScript {
	
	/*
	 * public driver reference which can be accessed across the project
	 * prop global variable to access properties class methods 
	 */
	public static WebDriver driver;
	Properties prop;
	
	/*
	 * This constructor is responsible for loading the properties file
	 */
	public DriverScript() {
		try 
		{
			File file = new File("./src/test/resources/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e) 
		{
			System.out.println("unable to load the properties file");
			e.printStackTrace();
		}
	}
	
	/*
	 * this method is used to launch the browser and apply all the wait settings and also
	 * navigate to the application
	 */
	public void initApplication() 
	{
		String browser = prop.getProperty("browser");
		
		if(browser.trim().equalsIgnoreCase("Chrome")) 
		{
			System.out.println("Browser Inuse : "+browser);
			driver = new ChromeDriver();
		}
		else if(browser.trim().equalsIgnoreCase("Firefox")) 
		{
			System.out.println("Browser Inuse : "+browser);
			driver = new FirefoxDriver();
		}
		else if(browser.trim().equalsIgnoreCase("Edge")) 
		{
			System.out.println("Browser Inuse : "+browser);
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Unsupported Browser Type!");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		getUrl();
		
	}
	
	/*
	 * this method is used to get the application url from the properties file
	 */
	public void getUrl() {
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	/*
	 * this method is used to quit the driver instance
	 */
	public static void quitDriver() {
		driver.quit();
	}

}


















