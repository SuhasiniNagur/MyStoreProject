package extentTestClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import extentreportBaseClass.ExtentBaseClass;


public class ExtentTestClass extends ExtentBaseClass {
 
 @Test
 public void loginPageTest() {
  test=extent.createTest("loginPageTest");
  WebElement imgElement=driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
  Assert.assertTrue(imgElement.isDisplayed());
 }
 
 @Test
 public void loginTest() {
  test=extent.createTest("loginTest");
  driver.findElement(By.id("txtUsername")).sendKeys("admin");
  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
  driver.findElement(By.id("btnLogin")).click();
        String actualTitle=driver.getTitle();
        String expectedTitle="OrangeHRM";
        Assert.assertEquals(actualTitle, expectedTitle);
 }

 @Test
 public void sampleCase() {
  test=extent.createTest("sampleCase");
  test.createNode("Validation1");
  Assert.assertTrue(true);
  test.createNode("Validation2");
  Assert.assertTrue(true);
  test.createNode("Validation3");
  Assert.assertTrue(true);
  test.createNode("Validation4");
  Assert.assertTrue(true);
 }
}