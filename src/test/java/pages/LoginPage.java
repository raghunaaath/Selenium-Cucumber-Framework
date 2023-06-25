package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import configValueProviders.ConfigFileReader;
import driverManager.DriverManager;
import org.junit.Assert;

public class LoginPage {
	
	WebDriver driver;
	By userNameInput = By.xpath("//input[@name='username']");
	By passwordInput = By.xpath("//input[@name='password']");
	By loginBtn = By.xpath("//button[@type='submit']");
	By dashBoardHeader = By.tagName("h6");
	By InvalidCredentials = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
	
	public LoginPage() throws Exception {
		DriverManager driverManager = new DriverManager();
		this.driver = driverManager.getDriver();
		
	}
	
	public void Login(String userName,String password) {
		
		driver.findElement(userNameInput).sendKeys(userName);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(loginBtn).click();
		
	}
	
	public void validate_Successful_Login(String expectedValue) {
		String actualValue = driver.findElement(dashBoardHeader).getText();
		Assert.assertEquals(actualValue, expectedValue);
	}
	
	public void validate_UnSuccessful_Login(String expectedValue) {
		String actualValue = driver.findElement(InvalidCredentials).getText();
		Assert.assertEquals(actualValue, expectedValue);
	}

}
