package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pages.LoginPage;

import org.junit.Assert;

@RunWith(Cucumber.class)
public class DefintionFile {
	
	public static ChromeDriver driver;
	public static LoginPage loginPage;
	
	@Given("I navigate to URL {string}")
	public void i_navigate_to_url(String url) throws Exception {
		loginPage = new LoginPage();	    
	}
	@When("I enter userName {string},password {string} & Click on Login Button")
	public void i_enter_user_name_password_click_on_login_button(String userName, String password) {
	   loginPage.Login(userName, password);
	}
	
	@Then("Login successful for OrangeHRM")
	public void login_successful_for_orange_hrm() {
	   loginPage.validate_Successful_Login("Dashboard");
	}
	
	@Then("Login should be unsuccessful for OrangeHRM")
	public void login_shoul_be_unsuccessful_for_orange_hrm() {
	   loginPage.validate_UnSuccessful_Login("Invalid credentials");
	}






	

}
