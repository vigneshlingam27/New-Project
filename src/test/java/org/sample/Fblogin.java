package org.sample;

import java.util.Date;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.xml.LaunchSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fblogin extends BaseClass  {

	public  WebDriver driver;
	
	@BeforeClass
	private  void beforeClass() 
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		launchUrl("https://www.facebook.com/");
//	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	private void before()
	{
       Date d=new Date();
       System.out.println("d="+d);
	}
	
	
   @Test
   private void test1() 
   {
	   SoftAssert s=new SoftAssert();
	   
	   WebElement btnctr = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
	   btnctr.click();
	   WebElement txtfirstname = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
	   txtfirstname.sendKeys("vicky");
	   s.assertEquals("vicky", txtfirstname,"super");
	   WebElement txtlastname = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
	   txtlastname.sendKeys("lingam");
	   s.assertEquals(txtlastname,"nandy","super2");
	   s.assertAll();

          }
 
   
   @AfterMethod
   private void after()
	{
		   Date d=new Date();
	       System.out.println("d="+d);
	}
	
   
   
   private  void afterClass()
   {
	   driver.quit();
             System.out.println("done.....");
   }
	
	
	
	
	
	
	
	
	
}
