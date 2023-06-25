package screenShotTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utility.TakeScreenshot;

public class ScreenShotTest {


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
	    TakeScreenshot.screenshot(driver,"screenshot1");
	}
	@Test
	public void textCase2(){
	    TakeScreenshot.screenshot(driver,"screenshot2");
	}
	@AfterMethod
	public void tearDowm() {
		driver.close();
	}
}
