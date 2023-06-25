package screenShot;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AshotTest1 {
 WebDriver driver;

 @Test
 public void setup() throws InterruptedException {
  System.setProperty("webdriver.chrome.driver",
    "C:\\Users\\Hitendra\\Downloads\\chromedriver_win32\\chromedriver.exe");
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.get("https://www.automationtestinginsider.com/p/selenium-vi.html");

  //Create the object of AShot() class and set image strategy by shootingStrategy method
     //and viewportPasting method and take screenshot using takeScreenshot method
  Screenshot Screenshot = new AShot()
    .shootingStrategy(ShootingStrategies.viewportPasting(500))
    .takeScreenshot(driver);

  //Copy the element screenshot to desired location
  try {
   ImageIO.write(Screenshot.getImage(), "png",
     new File("D:\\Workspace_Eclipse\\WebDriverConcept3\\ScreenShot\\Ashot.png"));
  } catch (IOException e) {
   e.getMessage();
  }
  
  driver.close();
 }
}