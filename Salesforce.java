package week6.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Salesforce extends SalsForceBaseCode{

	@BeforeTest
	public void setup() {
		browserName ="chrome";
		excelFileName="question";
	}
	
	
	@Test(dataProvider = "fetch")
	public void content(String question, String description) throws InterruptedException {
		
		Thread.sleep(3000);
		//Type Content on the Search box
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Content");
		
		//Click on Content Link
		driver.findElement(By.xpath("//div[@class='slds-app-launcher__tile-body slds-truncate']//mark")).click();
		
		Thread.sleep(5000);
		//Click on Chatter Tab
		WebElement chatter = driver.findElement(By.xpath("//span[text()='Chatter']"));
		driver.executeScript("arguments[0].click();", chatter);
		
		//Verify Chatter title on the page
		String title = driver.getTitle();
		
		if(title.equalsIgnoreCase("Chatter Home | Salesforce"))
		{
			System.out.println("Chatter tab has opened");
		}
		else
		{
			System.out.println("Some other window opened");
		}
		
		Thread.sleep(5000);
		//Click Question tab
		driver.findElement(By.xpath("//a[@title='Question']")).click();
		
		//Type Question with data (coming from excel)
		String ques = question;
		driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys(ques);
		
		//Type Details with data (coming from excel)
		String desc = description;
		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys(desc);
		
		//click ask
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand cuf-publisherShareButton qe-questionPostDesktop MEDIUM']")).click();
		
		//Confirm the question appears
		String ques2 = driver.findElement(By.xpath("(//span[@data-aura-class='uiOutputText'])[4]")).getText();
		
		if(ques2.contains(ques))
		{
			System.out.println("the question is published");
		}
		else
		{
			System.out.println("The question is not published");
		}
		
		//Close the browser
		driver.close();

	}

}
