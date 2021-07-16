package firstcleartriptest.mavenjava;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AFlightTest {
	  WebDriver driver;
	    
		@BeforeClass
		public void setUpFlight()
		{
				
			
	     System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hcl\\Desktop\\Selinium\\Drivers\\chromedriver.exe");
	     this.driver=new ChromeDriver();
	    
		    //WebDriver driver = new ChromeDriver(options2);
	    
	     //DesiredCapabilities dcap2 = new DesiredCapabilities();
	     //dcap2.setCapability("pageLoadStrategy", "normal");
	     //ChromeOptions chromeOptions2 = new ChromeOptions();
	     //chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	     //chromeOptions2.merge(dcap2);
	    //this.driver = new ChromeDriver(chromeOptions2);
	     
	     driver.get("https://www.cleartrip.com");
			driver.manage().window().maximize(); 
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			System.out.println("I am Before Method1");
			
		}
		@Test(priority=0)
		public void testFlight()
		{
		driver.findElement(By.xpath("//div[contains(@class,'mb-4')]/label[2]/div")).click();
		System.out.println("I am FlightFirst");
		}
		
		
		@Test(priority=1)
		public void testPersons()
		{
			
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("window.scrollBy(0,200)");
			
			WebElement value=driver.findElement(By.xpath("//div[@class='mb-4']/select[contains(@class,'neutral')]"));
			Select s=new Select(value);
		    driver.findElement(By.xpath("//div[@class='mb-4']/select[contains(@class,'neutral')]")).click();
		    List<WebElement> adult = driver.findElements(By.xpath("//div[@class='mb-4']/select[contains(@class,'neutral')]/option [contains(@class,'fs-3 ')]"));
		    
			//System.out.println(adult.size());
		    for(int i=1;i<adult.size();i++)
		    {
			s.selectByIndex(i);
			//System.out.println("Successful");
		    }
				
		    driver.findElement(By.xpath("//div[@class='mb-4']/select[contains(@class,'neutral')]")).click();
			
		    System.out.println("I am FlightSecond");
			
		}
			
		
		
		@AfterClass
		public void closeFlight()
		{
			driver.quit();
			System.out.println("First Browser is closed");
		}

}
