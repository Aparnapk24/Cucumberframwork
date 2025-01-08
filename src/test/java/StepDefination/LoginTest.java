package StepDefination;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;



import PageObject.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;


public class LoginTest extends Baseclass {
	
	
	public LoginPage lp;
	String TCName;
	
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
	@BeforeClass
	@Given("User luanch browser")
	public void user_luanch_browser() {
	   
		init();
		lp=new LoginPage(driver);
		
	}
	@When("User give the URL")
	public void user_give_the_url() throws Exception {
	    
		System.out.println("URL of the application"+prop.getProperty("AppURL"));
		Thread.sleep(5000);
	}
	@When("User enters the username and password")
	public void user_enters_the_username_and_password() throws Exception {
	
		//TCName = scenario.getName();
		TCName="TC02_InvalidLogin";
		lp.EnterUsername(data.get(TCName).get("Userid"));
		lp.EnterUserpassword(data.get(TCName).get("Password"));
		Thread.sleep(2000);
	}
	@When("User click on login button")
	public void user_click_on_login_button() {
	    lp.ClickonLogin();
	}
	@Then("User should be able to login")
	public void user_should_be_able_to_login() {
	    
		lp.VerifyHomePage();
	}

	

}
