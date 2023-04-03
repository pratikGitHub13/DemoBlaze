package com.DemoBlaze.Automation.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.DemoBlaze.Automation.Base.BaseClassDemoBlaze;
import com.DemoBlaze.Automation.Pages.*;

public class LogOutPage extends BaseClassDemoBlaze{
	
	
	@FindBy(id = "logout2")
	WebElement logout;
	
	@FindBy(id = "login2")
	WebElement login;
	
	public LogOutPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void userLogout() {
		LoginPage loginpage = new LoginPage();
		expectedWaitElementToBeClickable(login);
		String logIn = login.getText();
		if(logIn.equals("Log in")) {
			loginpage.login();
			expectedWaitElementToBeClickable(logout);
			logout.click();
		}
		else {
			expectedWaitElementToBeClickable(logout);
			logout.click();
		}
	}
}
