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

public class BTrainTest {

	 WebDriver driver;
	 
	 
		@BeforeClass
		public void asetUpTrain()
		{	
	     System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hcl\\Desktop\\Selinium\\Drivers\\chromedriver.exe");
	    
	     DesiredCapabilities dcap = new DesiredCapabilities();
	       dcap.setCapability("pageLoadStrategy", "normal");
	     ChromeOptions chromeOptions = new ChromeOptions();
	     //chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	     chromeOptions.merge(dcap);
	     		    //WebDriver driver = new ChromeDriver(options1);
	     this.driver = new ChromeDriver(chromeOptions);
	     driver.get("https://www.cleartrip.com");
			driver.manage().window().maximize(); 
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.findElement(By.partialLinkText("Trains")).click();
			String mainWindow=driver.getWindowHandle();
			Set<String> w=driver.getWindowHandles();
			Iterator<String> itr= w.iterator();
			while(itr.hasNext()){
				String childWindow=itr.next();
				if(!mainWindow.equals(childWindow)){
				driver.switchTo().window(childWindow);
				System.out.println("I am Before Method Second");
			
				}
				
			}
		}
		
		@Test(priority=2)
		public void bclassTrain()
		{
			WebElement c=driver.findElement(By.id("trainClass"));
			c.click();
			Select s= new Select(c); 
			s.selectByVisibleText("AC First Class (1A)");
			System.out.println("I am TrainFirst");
			
		}
		
		@Test(priority=3)
		public void cdateTrain()
		{
			
			driver.findElement(By.className("cal_openLink")).click();
			driver.findElement(By.cssSelector(".selected.current")).click();
			   System.out.println("I am Trainsecond");
		}
		
		@AfterClass
		public void dcloseTrain()
		{
			driver.quit();
			System.out.println("Second Browser is closed");
		}
	
	
}
