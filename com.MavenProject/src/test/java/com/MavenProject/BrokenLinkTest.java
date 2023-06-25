package com.MavenProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
public class BrokenLinkTest {
	
	WebDriver driver;
	
	List <WebElement> activeLinkImage = new ArrayList <WebElement>();
	
  @BeforeTest
  public void BrowserLaunch() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "D:/chromefile/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("chrome driver launched successfully");
		driver.get("http://www.google.com");
		Thread.sleep(2000);
  }
  @Test(priority=1)
  public void getLink() {
	  List<WebElement> linkImgList = driver.findElements(By.tagName("a"));
	  linkImgList.addAll(driver.findElements(By.tagName("img")));
	  
	  int total = linkImgList.size();
	  System.out.println("Total link and Images are : "+total);
	  
	  for(int i =0; i<total;i++) {
		  
		  if(linkImgList.get(i).getAttribute("href") != null && (!linkImgList.get(i).getAttribute("href").contains("javascript"))) {
			  activeLinkImage.add(linkImgList.get(i));
		  }
	  }
	  int total1 = activeLinkImage.size();
	  System.out.println("Total Active Links and Images: "+total1);
	  
  }
  @Test(priority=2)
  public void VerifyBrokenLinks() {
	  
	  VerifyBrokenLink obj=new VerifyBrokenLink();
	  for(int j = 0;j<activeLinkImage.size();j++) {
		  WebElement ele = activeLinkImage.get(j);
		  String url = ele.getAttribute("href");
		  obj.VerifyBrokenLinks(url);
	  }
	  System.out.println("Total valid Links : "+obj.validLink);
	  System.out.println("Total invalid Links : "+obj.invalidLink);
	  
  }
  @AfterTest()
  public void tearDown() {
		driver.close();
  }
}
