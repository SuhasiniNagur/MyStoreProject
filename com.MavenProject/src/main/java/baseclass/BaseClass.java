package baseclass;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public WebDriver driver;

	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/chromefile/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("chrome driver launched successfully");
		driver.get("http://www.google.com");
		Thread.sleep(2000);
	}
	
	public static void screenshot(WebDriver driver, String filename) {
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File source =takeScreenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File (System.getProperty("user.dir")+"\\Screenshot\\"+filename+".png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
}
