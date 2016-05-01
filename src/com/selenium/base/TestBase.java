<<<<<<< HEAD
package com.selenium.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.selenium.util.XLSReader;

public class TestBase {
	
	public static XLSReader suiteXLS =null;
	
	public static XLSReader suiteShoeShopXLS = null;
	
	public static Properties CONFIG = null;
	
	public static Properties OR = null;
	
	public boolean isInitialized= false;
	
	public boolean isBrowserOpen = false;
	
	public WebDriver driver = null;
	
	public void initialize() throws IOException
	{
		
		if(!isInitialized)
		{
			
			System.out.println("Loading properties files");
			//Loading properties files
			
			CONFIG = new Properties();
			
			FileInputStream istr = new FileInputStream(System.getProperty("user.dir")+"/src/com/selenium/config/config.properties");
			
			CONFIG.load(istr);
			
			
			OR = new Properties();
			
			istr = new FileInputStream(System.getProperty("user.dir")+"/src/com/selenium/config/OR.properties");
			
			OR.load(istr);
			
			
			//Loading EXcel Files
			
			suiteXLS = new XLSReader(System.getProperty("user.dir")+"/src/com/selenium/xls/Suite.xlsx");
			
			suiteShoeShopXLS=new XLSReader(System.getProperty("user.dir")+"/src/com/selenium/xls/ShoeShop Suite.xlsx");
			
			isInitialized = true;
		
		}
		
	}
	
	
	public void openBrowser()
	{
		String browser = CONFIG.getProperty("browserName");
		
		if(!isBrowserOpen)
		{
		
			if(browser.equalsIgnoreCase("Mozilla"))
			{
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
				
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
				
				driver = new InternetExplorerDriver();
			}
			
			isBrowserOpen = true;
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(CONFIG.getProperty("implicitWaitTime")), TimeUnit.SECONDS);
		}
		
	}
	
	public void closeBrowser()
	{
		if(driver != null)
		{
			driver.close();
		}
	}

}
=======
package com.selenium.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.selenium.util.XLSReader;

public class TestBase {
	
	public static XLSReader suiteXLS =null;
	
	public static XLSReader suiteShoeShopXLS = null;
	
	public static Properties CONFIG = null;
	
	public static Properties OR = null;
	
	public boolean isInitialized= false;
	
	public boolean isBrowserOpen = false;
	
	public WebDriver driver = null;
	
	public void initialize() throws IOException
	{
		
		if(!isInitialized)
		{
			
			System.out.println("Loading properties files");
			//Loading properties files
			
			CONFIG = new Properties();
			
			FileInputStream istr = new FileInputStream(System.getProperty("user.dir")+"/src/com/selenium/config/config.properties");
			
			CONFIG.load(istr);
			
			
			OR = new Properties();
			
			istr = new FileInputStream(System.getProperty("user.dir")+"/src/com/selenium/config/OR.properties");
			
			OR.load(istr);
			
			
			//Loading EXcel Files
			
			suiteXLS = new XLSReader(System.getProperty("user.dir")+"/src/com/selenium/xls/Suite.xlsx");
			
			suiteShoeShopXLS=new XLSReader(System.getProperty("user.dir")+"/src/com/selenium/xls/ShoeShop Suite.xlsx");
			
			isInitialized = true;
		
		}
		
	}
	
	
	public void openBrowser()
	{
		String browser = CONFIG.getProperty("browserName");
		
		if(!isBrowserOpen)
		{
		
			if(browser.equalsIgnoreCase("Mozilla"))
			{
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
				
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
				
				driver = new InternetExplorerDriver();
			}
			
			isBrowserOpen = true;
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(CONFIG.getProperty("implicitWaitTime")), TimeUnit.SECONDS);
		}
		
	}
	
	public void closeBrowser()
	{
		if(driver != null)
		{
			driver.close();
		}
	}

}
>>>>>>> origin/master
