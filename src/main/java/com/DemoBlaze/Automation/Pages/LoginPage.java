package com.DemoBlaze.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.DemoBlaze.Automation.Base.BaseClassDemoBlaze;

public class LoginPage extends BaseClassDemoBlaze{
	
	@FindBy(id = "login2")
	WebElement loginMenuBttn;
	
	@FindBy(id = "loginusername")
	WebElement username;
	
	@FindBy(id = "loginpassword")
	WebElement password;
	
	@FindBy(xpath = "//button[normalize-space()='Log in']")
	WebElement loginBttn;
	 
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void login() {
		expectedWaitElementToBeClickable(loginMenuBttn);
		loginMenuBttn.click();
		expectedWaitElementToBeClickable(username);
		username.click();
		username.sendKeys(props.getProperty("username"));
		password.click();
		password.sendKeys(props.getProperty("password"));
		loginBttn.click();
	}
	
}
