package firstcleartriptest.mavenjava;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CHotelTest {
	 WebDriver driver;
	 
	 
		@BeforeClass
		public void setUpHotel()
		{	
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hcl\\Desktop\\Selinium\\Drivers\\chromedriver.exe");
		     //this.driver=new ChromeDriver();
			DesiredCapabilities dcap1 = new DesiredCapabilities();
	        dcap1.setCapability("pageLoadStrategy", "none");
		     ChromeOptions chromeOptions1 = new ChromeOptions();
		     //chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
		     chromeOptions1.merge(dcap1);
			 
			    
		     this.driver = new ChromeDriver(chromeOptions1);
		     
		     
		     driver.get("https://www.cleartrip.com");
		     
		     
		     driver.manage().window().maximize(); 
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				driver.findElement(By.partialLinkText("Hotels")).click();
				String mainWindow=driver.getWindowHandle();
				Set<String> w=driver.getWindowHandles();
				Iterator<String> itr= w.iterator();
				while(itr.hasNext()){
					String childWindow=itr.next();
					if(!mainWindow.equals(childWindow)){
					driver.switchTo().window(childWindow);
				
				System.out.println("I am Before Method Third");
		        }
			}
		}
		
		@Test(timeOut=5000,priority=4)
		public void aHotelLocation()
		{
			
			driver.findElement(By.cssSelector("#Tags")).sendKeys("Puri");
			System.out.println("I am HotelFirst");
		}
		
		@Test(priority=5)
		public void bHotelTraveller()
		{
			WebElement store=driver.findElement(By.id("travellersOnhome"));
			store.click();
			Select s1= new Select(store);
			s1.selectByIndex(1);
			System.out.println("I am HotelSecond");

			
		}
		
		@AfterClass
		public void closeHotel()
		{
			driver.quit();
			System.out.println("Third Browser is closed");
		}	

}
