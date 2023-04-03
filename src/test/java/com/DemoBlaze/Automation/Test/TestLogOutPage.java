package com.DemoBlaze.Automation.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.DemoBlaze.Automation.Base.BaseClassDemoBlaze;
import com.DemoBlaze.Automation.Pages.LogOutPage;

public class TestLogOutPage extends BaseClassDemoBlaze{

	LogOutPage logout;

	public TestLogOutPage() {
		super();
	}

	@BeforeMethod
	public void startTesting() {
		intialization();
		launch();
		windowMaximize();
		logout = new LogOutPage();
	}

	@Test(priority = 1)
	public void testUserLogOut() {
		logout.userLogout();
	
	}

	@AfterMethod
	public void terminate() {
		tearDown();
	}
}