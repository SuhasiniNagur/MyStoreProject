package screenShot;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class AshotTest2 {
 WebDriver driver;

 @Test
 public void setup() throws InterruptedException {
  System.setProperty("webdriver.chrome.driver",
    "C:\\Users\\Hitendra\\Downloads\\chromedriver_win32\\chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
  WebElement element = driver.findElement(By.id("btnLogin"));

  //Create the object of AShot() class and get the image co-ordinates 
  //by coordsProvider method and take screenshot using takeScreenshot method
  Screenshot screenshot = new AShot()
    .coordsProvider(new WebDriverCoordsProvider())
    .takeScreenshot(driver,element);

  //Copy the element screenshot to desired location
  try {
   ImageIO.write(screenshot.getImage(), "png",
     new File("D:\\Workspace_Eclipse\\WebDriverConcept3\\ScreenShot\\Ashot2.png"));
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }

  driver.close();
 }
}