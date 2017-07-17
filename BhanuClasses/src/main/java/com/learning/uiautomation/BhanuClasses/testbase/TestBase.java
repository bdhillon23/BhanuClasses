package com.learning.uiautomation.BhanuClasses.testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public static final Logger log =Logger.getLogger(TestBase.class.getName());
	public WebDriver driver;
	String URL = "http://automationpractice.com/index.php";
	String Browser = "Chrome" ;

	public void init(){
		String log4jconfig="log4j.properties";
		PropertyConfigurator.configure(log4jconfig);
		selectBrowser(Browser);
		getURL(URL);
		
	}
	
	
	public void selectBrowser(String Browser) {
		if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "/Drivers//chromedriver.exe");
			log.info("Creating obejct of browser "+ Browser);
			driver = new ChromeDriver();

		}
	}

	public void getURL(String URL) {
		driver.get(URL);
		log.info("Navigating to the URL : "+ URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
