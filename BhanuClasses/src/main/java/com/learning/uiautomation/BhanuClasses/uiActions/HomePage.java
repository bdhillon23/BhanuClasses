package com.learning.uiautomation.BhanuClasses.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public static final Logger log =Logger.getLogger(HomePage.class.getName());
	
	WebDriver driver;
	
	@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	@FindBy(css="#email")
	WebElement userName;
	
	@FindBy(css="#passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement submitBtn;
	
	@FindBy(css=".alert.alert-danger>ol>li")
	WebElement errorText;
	
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginToApplication(String Email,String Password) throws InterruptedException{
		//Thread.sleep(2000);
		signIn.click();
		log.info("Clicking on the sign in btn "+ signIn.toString());
		Thread.sleep(2000);
		userName.sendKeys(Email);
		log.info("Entering the username "+Email +" in the field ");
		password.sendKeys(Password);
		log.info("Entering the password in the field ");
		submitBtn.click();
		
	}
	public String errorMessage() throws InterruptedException{
		Thread.sleep(1000);
		return errorText.getText();
	}
	
}
