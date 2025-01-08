package Common;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commonmethod {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	public Commonmethod(WebDriver driver)
	{
		this.driver=driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	}

	public void EnterValue(WebElement elm, String value)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			elm.clear();
			elm.sendKeys(value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void Click(WebElement elm)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			
			elm.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void VerifyPage(WebElement elm)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(elm));
			
			elm.isDisplayed();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
