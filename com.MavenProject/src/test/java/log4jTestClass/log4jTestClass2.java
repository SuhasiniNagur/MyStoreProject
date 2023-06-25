package log4jTestClass;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import log4jBaseClass.log4jBaseClass;
import log4jUtility.Log;

public class log4jTestClass2 extends log4jBaseClass {
 
 @Test
 public void wordPressTest() {
  Log.startTestCase("wordPressTest");
  Log.info("Entering User Name");
  driver.findElement(By.id("user_login")).sendKeys("opensourcecms");
  Log.info("Entering User Password");
  driver.findElement(By.id("user_pass")).sendKeys("opensourcecms");
  Log.info("Click on Login Button");
  driver.findElement(By.id("wp-submit")).click();
  Log.info("Home Page");
  Log.info("Get Current URL");
  String urlString=driver.getCurrentUrl();
  Log.info("Validate the URL");
  String expectedURL="https://s1.demo1.opensourcecms.com/wordpress/wp-admin/";
  Assert.assertEquals(urlString, expectedURL);
  Log.info("URL Matches");
  Log.endTestCase("wordPressTest");
 }

}