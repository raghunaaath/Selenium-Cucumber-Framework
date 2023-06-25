package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import configValueProviders.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	private WebDriver driver;
	private String environmentType;
	private String driverType;
	private ConfigFileReader propertiesFile;
	
	public DriverManager() {
		propertiesFile = new ConfigFileReader();
		environmentType = propertiesFile.getEnvironment().toUpperCase();
		driverType = propertiesFile.getBrowser().toUpperCase();
	}
	
	public WebDriver getDriver() throws Exception {
		switch(environmentType) {
		case "LOCAL":
			driver = createLocalDriver();
		case "REMOTE":
			driver=createRemoteDriver();
		}
		return driver;
	}
	
	private WebDriver createLocalDriver() {
		switch(driverType) {
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(propertiesFile.getURL());
		case "EDGE":
			WebDriverManager.edgedriver().setup();;
			driver = new EdgeDriver();
			driver.get(propertiesFile.getURL());
		case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();;
			driver = new FirefoxDriver();
			driver.get(propertiesFile.getURL());
		}
		return driver;
	}
	
	private WebDriver createRemoteDriver() throws Exception {
		throw new Exception("Remote Driver Not Yet Implemented");
	}
	
}
