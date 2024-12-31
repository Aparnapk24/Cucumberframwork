package PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	
	WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="email")
	WebElement userid;
	
	@FindBy(name="pass")
	WebElement userpswrd;
	
	@FindBy(name="login")
	WebElement login;
	
	public void EnterUsername(String usernm)
	{
		userid.clear();
		userid.sendKeys(usernm);
	}
	
	public void EnterUserpassword(String userpass)
	{
		userpswrd.clear();
		userpswrd.sendKeys(userpass);
	}
	
	public void ClickonLogin()
	{
		
		login.click();
	}

}
