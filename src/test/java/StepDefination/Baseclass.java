package StepDefination;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Common.Xls_Reader;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Map<String,Map<String,String>> data;
	public Scenario scenario;
	
	public void init()
	{
		prop=ReadProperties(System.getProperty("user.dir")+"/src/test/resources/Config/Settings.properties");
		Startdriver();
		data=Readxls(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\Data.xlsx","sheet1");
		System.out.println();
	}
	
	public void Startdriver()
	{
		if(prop.getProperty("browser").equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
		}else
		if(prop.getProperty("browser").equals("edge"))
			{
				WebDriverManager.edgedriver().setup();
			    driver=new EdgeDriver();
			}
		else
			if(prop.getProperty("browser").equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
			    driver=new FirefoxDriver();
			}
			else
			{
				WebDriverManager.chromedriver().setup();
			    driver=new ChromeDriver();
			}
		driver.get("http://localhost:100/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	public Properties ReadProperties(String file)
	{
		FileInputStream fis=null;
		Properties prop=new Properties();
		try
		{
			
			fis=new FileInputStream(file);
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return prop;
	}
	
	public Map<String,Map<String,String>> Readxls(String file, String sheet)
	{
		Xls_Reader xl=new Xls_Reader(file);
		int rowcount=xl.getRowCount(sheet);
		int colcount=xl.getColumnCount(sheet);
		Map<String,Map<String,String>> Allhm=new HashMap<String,Map<String,String>>();
		for(int i=2;i<=rowcount;i++)
		{
			Map<String,String> hm=new HashMap<String, String>();
			for(int j=1;j<colcount;j++)
			{
			String data=xl.getCellData("sheet1", j, i).trim();
			hm.put(xl.getCellData("sheet1", j, 1).trim(), data);
			}
			
			Allhm.put(xl.getCellData("sheet1", 0, i), hm);
		}
		
		return Allhm;
	}
}
