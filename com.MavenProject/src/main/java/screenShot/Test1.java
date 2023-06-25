package screenShot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1 {

 WebDriver driver;

 @Test
 public void setup() throws IOException  {
  System.setProperty("webdriver.chrome.driver",
    "C:\\Users\\Hitendra\\Downloads\\chromedriver_win32\\chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php?");
  WebElement element = driver.findElement(By.id("wp-submit"));

  // Get entire page screenshot
  File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        BufferedImage  fullImg = ImageIO.read(screenshot);
  // Get the location,height,width of element on the page
  Point point = element.getLocation();
      int eleWidth = element.getSize().getWidth();
  int eleHeight = element.getSize().getHeight();
  // Crop the entire page screenshot to get only element screenshot
  try {
   BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
        eleWidth, eleHeight);
   ImageIO.write(eleScreenshot, "png", screenshot);
  } catch (Exception e) {
   // TODO Auto-generated catch block
   e.getMessage();
  }
  // Copy the element screenshot to desired location
  File screenshotLocation = new File("D:\\Workspace_Eclipse\\WebDriverConcept3\\ScreenShot\\Ashot3.png");
  FileUtils.copyFile(screenshot, screenshotLocation);
  // Close the browser
  driver.close();
 }
}