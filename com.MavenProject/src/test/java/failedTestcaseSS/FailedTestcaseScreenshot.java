package failedTestcaseSS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.utility.TakeScreenshot;

public class FailedTestcaseScreenshot {

	
	WebDriver driver;
	@BeforeMethod
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/chromefile/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("chrome driver launched successfully");
		driver.get("http://www.google.com");
		Thread.sleep(2000);
	}
	
	@Test
	public void textCase1(){
		
		driver.findElement(By.name("q")).sendKeys("ScreeShot Demon");
		Assert.assertTrue(false);
	}
	@Test
	public void textCase2(){
		Assert.assertTrue(true);
	}
	@AfterMethod
	public void tearDowm(ITestResult result) {
		
		if(result.FAILURE==result.getStatus()) {
			TakeScreenshot.screenshot(driver, result.getName());
		}
		driver.close();
	}
}
