package com.DemoBlaze.Automation.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.DemoBlaze.Automation.Pages.LoginPage;

public class TestLoginPage extends LoginPage {

	LoginPage loginpage;

	public TestLoginPage() {
		super();
	}

	@BeforeMethod
	public void startTesting() {
		intialization();
		launch();
		windowMaximize();
		loginpage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void testPageTitle() {
		String expectedString = "STORE";
		String actualString = loginpage.getPageTitle();
		Assert.assertEquals(expectedString, actualString);
	}
	
	@Test(priority = 2)
	public void loginTest() {
		loginpage.login();
	}
	
	@AfterMethod
	public void terminate() {
		tearDown();
	}
}
