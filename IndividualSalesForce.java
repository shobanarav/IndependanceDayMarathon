package week6.day1;



import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class IndividualSalesForce extends SalsForceBaseCode {

	@BeforeTest
	public void setup() {
		browserName ="edge";
		excelFileName= "Salutation";
	}
	
	@Test(dataProvider = "fetch")
	public void Individual(String sal) throws InterruptedException {
		// TODO Auto-generated method stub
		   
				
				//Type Individuals on the Search box
				driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Individuals");
				
				// Click Individuals Link
				driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
				
				// Click New
				 driver.findElement(By.xpath("//div[@title='New']")).click();
			
				
				// Select Salutation with data (coming from excel) 
				 driver.findElement(By.xpath("(//a[@class='select'])[1]")).click();
				 String salutation = sal;
			     driver.findElement(By.xpath("//a[@title='"+salutation+"']")).click();
				
				// Type Last Name 
			     String lastName = "Ravi";
				driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
				
				// Click Save
				driver.findElement(By.xpath("//button[@title='Save']")).click();
				
				
				Thread.sleep(5000);
				// Click on the App Launcher (dots)
				driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-show')]")).click();
				
				//Click View All
				driver.findElement(By.xpath("//button[@class='slds-button']")).click();
				
				// Type Customers on the Search box
				driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Customer");
				
				// Click Customers Link
				driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
				
				
				Thread.sleep(3000);
				// Click New
				driver.findElement(By.xpath("(//a[@title='New'])[1]")).click();
				
				Thread.sleep(3000);
				// Type the same name provided in step 8 and confirm it appears
				driver.findElement(By.xpath("//input[@role='combobox']")).click();
			 String name = driver.findElement(By.xpath("//div[@title='Ravi']")).getText();
				 
				 if(name.contains(lastName))
				 {
					 System.out.println("The name appears");
				 }
				 else
				 {
					 System.out.println("The name does not appear");
				 }
				
				// Close the browser
				 driver.close();

	}

}
