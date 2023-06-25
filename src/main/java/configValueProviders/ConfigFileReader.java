package configValueProviders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigFileReader {
	
	private static final String configFilePath = "D:\\Java\\Cucumber\\config\\configuration.properties";
	private Properties properties;
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(configFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getURL() {
		return properties.getProperty("url");
	}
	
	public String getBrowser() {
		return properties.getProperty("browser");
	}
	
	public String shouldWindowBeMaximized() {
		return properties.getProperty("windowMaximize");
	}
	
	public String getEnvironment() {
		return properties.getProperty("environment");
	}
	
}
