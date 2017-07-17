package com.learning.uiautomation.BhanuClasses.homepage;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.learning.uiautomation.BhanuClasses.testbase.TestBase;
import com.learning.uiautomation.BhanuClasses.uiActions.HomePage;

public class TC001_VerifyLoginWithInvalidCredentials extends TestBase{
	
	public static final Logger log =Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());	
	
	HomePage homepage;
	
	@BeforeTest
	public void setUp(){
		init();
		
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials() throws InterruptedException{
		log.info("*******Starting the Test***********");
		homepage=new HomePage(driver);
		homepage.loginToApplication("Balvinder.dh23@gmail.com", "passswda");
		Assert.assertEquals(homepage.errorMessage(), "Authentication failed.");
		log.info("*******Finishing the Test***********");
		
	}
	
	@AfterClass
	public void endTest(){
		if(driver!=null){
		driver.quit();
	  }
     }
  }
