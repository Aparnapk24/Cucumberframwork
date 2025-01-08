package PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.Commonmethod;

public class LoginPage {
	
	
	public WebDriver driver;
	public Commonmethod cm;
	//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		cm=new Commonmethod(driver);
	}
	
	@FindBy(name="user_name")
	WebElement userid;
	
	@FindBy(name="user_password")
	WebElement userpswrd;
	
	@FindBy(name="Login")
	WebElement login;
	
	@FindBy(xpath="//td[contains(text(),\"My Upcoming and Pending Activities\")]")
	WebElement verifyhome;
	
	public void EnterUsername(String usernm)
	{
		cm.EnterValue(userid, usernm);
	}
	
	public void EnterUserpassword(String userpass)
	{
		cm.EnterValue(userpswrd,userpass);
	}
	
	public void ClickonLogin()
	{
		
		cm.Click(login);
	}
	
	public void VerifyHomePage()
	{
		cm.VerifyPage(verifyhome);
	}

}
