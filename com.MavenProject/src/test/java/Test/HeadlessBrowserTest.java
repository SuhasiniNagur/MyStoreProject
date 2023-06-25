package Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowserTest {

	
	public void headlessTest() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:/chromefile/chromedriver.exe");

		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("headless");
		chromeoptions.addArguments("window-size=1200X600");
		
        WebDriver driver = new ChromeDriver(chromeoptions);
		driver.get("http://www.google.com");
		System.out.println("Test Start: ");
		System.out.println("Google title is: "+driver.getTitle());
		System.out.println("Test End");
		Thread.sleep(2000);
		
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File source = takescreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("E:\\Eclipse 2023\\com.MavenProject\\Screenshot"));
		
		driver.close();
	}
}
