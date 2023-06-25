package screenShotTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.utility.TakeScreenshot;

import baseclass.BaseClass;

public class ScreenshotBaseclassTest extends BaseClass {

	@Test
	public void textCase1(){
		
		driver.findElement(By.name("q")).sendKeys("ScreeShot Demon");
	    TakeScreenshot.screenshot(driver,"screenshot1");
	}
	@Test
	public void textCase2(){
	    TakeScreenshot.screenshot(driver,"screenshot2");
	}
}
