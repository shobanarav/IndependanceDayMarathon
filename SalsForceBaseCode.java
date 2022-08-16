package week6.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalsForceBaseCode {
	
	RemoteWebDriver driver;
	String browserName="";
	String excelFileName="";
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void setup(String url, String name, String pwd) throws InterruptedException {
		
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			//disable notifications
			ChromeOptions notification = new ChromeOptions();
			notification.addArguments("--disable-notifications");
			
			driver = new ChromeDriver(notification);
			
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			
			 //disable notifications
			EdgeOptions notification = new EdgeOptions();
			notification.addArguments("--disable-notifications");
			
			driver = new EdgeDriver(notification);
			
		}
		
		//Loading URL
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Logging In
		driver.findElement(By.id("username")).sendKeys(name);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@id=\"Login\"]")).click();
		
		//Click on App Launcher
		driver.findElement(By.xpath("//button[contains(@class,'slds-icon-waffle')]")).click();
		
		Thread.sleep(5000);
		//click on view All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		
	}
	
	@DataProvider(name="fetch")
	public String[][] fetchData() throws IOException
	{
		
		String[] [] data = ExcelSheet.excelsheet(excelFileName);
		return data;
	}
	

}
