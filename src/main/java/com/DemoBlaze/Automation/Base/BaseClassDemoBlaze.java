package com.DemoBlaze.Automation.Base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClassDemoBlaze {

	protected static WebDriver driver;
	protected static Properties props;

	public BaseClassDemoBlaze() {
		props = new Properties();
		FileReader reader = null;
		try {
			reader = new FileReader(System.getProperty("user.dir")+"/ProjectConfig.properties");
			System.out.println(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			props.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void intialization() {
		String browserName = props.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
	}
	public void launch() {
		driver.get(props.getProperty("url"));
	}
	
	public void windowMaximize() {
		driver.manage().window().maximize();
	}
	
	public void expectedWaitElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
