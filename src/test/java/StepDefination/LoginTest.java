package StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	public WebDriver driver;
	public LoginPage lp;
	
	@Given("User luanch chrome browser")
	public void user_luanch_chrome_browser() {
	    
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    lp=new LoginPage(driver);
	}
	@When("User give the URL {string}")
	public void user_give_the_url(String url) throws Exception {
	    
		driver.get(url);
		Thread.sleep(5000);
	}
	@When("User enters the username as {string} and password as a {string}")
	public void user_enters_the_username_as_and_password_as_a(String string, String string2) throws Exception {
	
		
		lp.EnterUsername(string);
		lp.EnterUserpassword(string2);
		Thread.sleep(2000);
	}
	@When("User click on login button")
	public void user_click_on_login_button() {
	    lp.ClickonLogin();
	}
	@Then("User should not able to login")
	public void user_should_not_able_to_login() {
	    System.out.println("Invalid credentials");
	}


}
