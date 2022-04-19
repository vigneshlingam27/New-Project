	   package org.sample;

	   import java.io.File;
	   import java.io.IOException;
	   import java.util.List;
	   import java.util.Set;
	   import java.util.concurrent.TimeUnit;

	   import org.apache.commons.io.FileUtils;
	   import org.openqa.selenium.Alert;
	   import org.openqa.selenium.By;
	   import org.openqa.selenium.JavascriptExecutor;
	   import org.openqa.selenium.OutputType;
	   import org.openqa.selenium.TakesScreenshot;
	   import org.openqa.selenium.WebDriver;
	   import org.openqa.selenium.WebElement;
	   import org.openqa.selenium.WebDriver.TargetLocator;
	   import org.openqa.selenium.chrome.ChromeDriver;
	   import org.openqa.selenium.edge.EdgeDriver;
	   import org.openqa.selenium.firefox.FirefoxDriver;
	   import org.openqa.selenium.interactions.Actions;
	   import org.openqa.selenium.support.ui.Select;

	   import io.github.bonigarcia.wdm.WebDriverManager;

	   public class BaseClass
	   {
	       
	   	 public static WebDriver driver;
	   	    
	   	 
	   	    
	   	        public static WebDriver launchBrowser(String browserName)
	   	        {
	   	        
//	   	 
	   	    
	   	     switch (browserName)
	   	     {
	   	     case "chrome":
	   	     WebDriverManager.chromedriver().setup();
	   	     driver=new ChromeDriver();
	   	     break;
	   	     
	   	     case "firefox":
	   	     WebDriverManager.firefoxdriver().setup();
	   	     driver=new FirefoxDriver();
	   	     break;
	   	     
	   	     case "edge":
	   	    	 WebDriverManager.edgedriver().setup();
	   	    	 driver=new EdgeDriver();
	   	    	 break;
	   	     }
	   	     
	   	        return driver;
	   	}
	   	        
	   	        //url launch
	   	        
	   	   public static void launchUrl(String url)
	   	   {
	   	        driver.get(url);
	   		   driver.manage().window().maximize();
	   	}
	   	   
	   	   //wait
	   	   
	   	   public static void implicityWait(long time) 
	   	   {
	   	       driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	   	}
	   	    	
	   	   //getcurrent url
	   	   
	   	   public static String getCurrentUrl() 
	   	   {
	   	       String currentUrl = driver.getCurrentUrl();
	   		return currentUrl;
	   	   }
	   	   
	   	   //gettitle
	   	   
	   	   public static String getTitle()
	   	   {
	   	      String title = driver.getTitle();
	   		return title;
	   		   
	   	}
	   	   
	   	   //quit
	   	   
	   	   public static void quit()
	   	   {
	   	        driver.quit();
	   	}
	   	   
	   	   //sendkeys
	   	   
	   	   public static void sendKeys(WebElement e,String value) 
	   	   {
	   	       e.sendKeys(value);
	   	}
	   	   
	   	   //get  Attribute
	   	   
	   	  public static String getAttribute(WebElement e) 
	   	  {
	   	      String value = e.getAttribute("value");
	   		return value;     
	   	}
	   	  //maximize
	   	public static void maximize() {
driver.manage().window().maximize();
		}
	   	  //gettext
	   	  
	   	    public static String getText(WebElement e) 
	   	    {
	   	        String text = e.getText();
	   			return text;
	   		}
	   	   
	   	    //click
	   	    public static void buttonClick(WebElement e)
	   	    {
	   	    	e.click();
	   		}
	   	    
	   	    //actions
	   	    //movetoelement
	   	    
	   	    public static void moveToElement(WebElement e) 
	   	    {
	   	        Actions a=new Actions(driver);
	   	        a.moveToElement(e).perform();
	   		}
	   	    
	   	    //drag&drop
	   	    
	   	    public void dragAndDrop(WebElement src,WebElement des) 
	   	    {
	   	    	 Actions a=new Actions(driver);
	   	    	 a.dragAndDrop(src, des).perform();
	   		}
	   	    
	   	    //select
	   	    //select by index
	   	    
	   	    public static void selectByIndex(WebElement e,int index) 
	   	    {
	   	         Select s=new Select(e);
	   	         s.selectByIndex(index);
	   		}
	   	    
	   	    //deselect by value
	   	    
	   	    public static void deselectByValue(WebElement e,String value)
	   	    {
	   	          Select s=new Select(e);
	   	          s.deselectByValue(value);;
	   		}

	   	    //findelement
	   	    
	   	     public static WebElement findElement(String locatorName,String locatorValue) 
	   	     {
	   	         WebElement value=null;
	   	         
	   	         if(locatorName.equals("id"))
	   	         {
	   	        	  value = driver.findElement(By.id(locatorValue));
	   	         }
	   	         else if(locatorName.equals("name"))
	   	         {
	   	        	  value = driver.findElement(By.name(locatorValue));
	   	         }
	   	         else if(locatorName.equals("xpath"))
	   	         {
	   	        	  value = driver.findElement(By.xpath(locatorValue));
	   	         }
	   	         
	   	         return value;
	   		}
	   	     
	   	     
	   	     //alert 1.
	   	     public static Alert alert() 
	   	     {
	   	        Alert alert = driver.switchTo().alert();
	   			return alert;
	   		}
	   	    
	   	    //alert 2.accept
	   	     
	   	     public static void accept() 
	   	     {
	   	        driver.switchTo().alert().accept();     
	   		}
	   	     
	   	     //alert 3.dismiss
	   	     
	   	     public static void dismiss() 
	   	     {
	   	        driver.switchTo().alert().dismiss();
	   		}
	   	     
	   	     
	   	     
	   	     //alert 5.gettext
	   	     
	   	     public  static String getText()
	   	     {
	   	         String text = driver.switchTo().alert().getText();
	   			 return text;
	   		}
	   	     
	   	     // 6.close
	   	     
	   	     public static void close()
	   	     {
	   	         driver.close();
	   		}
	   	     
	   	     //7.selectByvalue
	   	     public static void selectByValue(WebElement e,String value) 
	   	     {
	   	          Select s=new Select(e);
	   	          s.selectByValue(value);
	   	 	}
	   	     
	   	     //8.selectByVisibleText
	   	     
	   	     public static void selectByVisibleText(WebElement e)
	   	     {
	   	    	 Select s=new Select(e);
	   	    	 s.selectByVisibleText(getText());
	   		}
	   	     
	   	     //9.getoptions
	   	     
	   	     public static  List<WebElement> getOptions(WebElement e)
	   	     {
	   	    	 Select s=new Select(e);
	   	    	 List<WebElement> options = s.getOptions();
	   			return options;
	   		}
	   	     
	   	     //10.getAllSelectedOptions
	   	     
	   	     public static  List<WebElement> getAllSelectedOptions(WebElement e) 
	   	     {
	   	    	 Select s=new Select(e);
	   	    	 List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
	   			return allSelectedOptions;
	   		}
	   	     
	   	     //11.deselectAll
	   	     
	   	     public static void deSelectAll(WebElement e)
	   	     {
	   	    	 Select s=new Select(e);  
	   	    	 s.deselectAll();
	   		}
	   	    
	   	    // 12.getFirstSelectedOptions
	   	     
	   	     public static  List<WebElement> getFirstSelectedOptions(WebElement e)
	   	     {
	   	    	 Select s=new Select(e);
	   	    	 List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
	   			return allSelectedOptions;
	   		}
	   	    
	   	     //13.isMultiple
	   	     
	   	     public static boolean isMultiple(WebElement e)
	   	     { 
	   	    	 Select s=new Select(e);
	   	    	 boolean multiple = s.isMultiple();
	   			return multiple;
	   		}
	   	     
	   	     //14.deSelectByIndex
	   	     
	   	     public static void deSelectByIndex(WebElement e,int index)
	   	     {
	   	            Select s=new Select(e);
	   	            s.deselectByIndex(index);
	   		}
	   	     
	   	     //15.deSelectByVisibleText
	   	     
	   	     public static void deSelectByVisibleText(WebElement e)
	   	     {
	   	          Select s=new Select(e);
	   	          s.deselectByVisibleText(getText());
	   		}
	   	     
	   	     //16.getScreenShotAs
	   	     
	   	    public static void screenShot(String FileName) throws IOException
	   	    {
	   	         TakesScreenshot tk= (TakesScreenshot)driver;
	   	         File src=tk.getScreenshotAs(OutputType.FILE);
	   	         System.out.println(src);
	   	         File des=new File("C:\\MavenPack\\src\\test\\resources\\"+FileName+".png");
	   	         FileUtils.copyFile(src, des);
	   		}
	   	     
	   	     //17.switchTo
	   	     
	   	     public static TargetLocator switchTo() 
	   	     {
	   	      TargetLocator switchTo = driver.switchTo();
	   		return switchTo;   
	   		}
	   	     
	   	     //18.windowHandle
	   	     public static String windowHandle() 
	   	     {
	   	           String windowHandle = driver.getWindowHandle();
	   			return windowHandle;
	   		}
	   	     
	   	     //19.windowHandles
	   	     
	   	     public static  Set<String> windowHandles() 
	   	     {
	   	           Set<String> windowHandles = driver.getWindowHandles();
	   			return windowHandles;
	   		}
	   	     
	   	     //20.clear
	   	     public static void clear(WebElement e) 
	   	     {
	   	         e.clear();
	   		}
	   	     
	   	     //21.clickAndHold
	   	     
	   	     public static void clickAndHold() 
	   	     {
	   	            Actions a=new Actions(driver);
	   	            a.clickAndHold().perform();
	   		}
	   	     
	   	     //22.isEnabled
	   	     
	   	     public static boolean  isEnabled(WebElement e) 
	   	     {
	   	        boolean enabled = e.isEnabled();
	   			return enabled;
	   		}
	   	     
	   	     //23.isDisplayed
	   	     
	   	     public static boolean isDisplayed(WebElement e) 
	   	     {
	   	          boolean displayed = e.isDisplayed();
	   			return displayed;
	   		}
	   	     
	   	     //24.isSelected
	   	     
	   	     public static boolean isSelected(WebElement e) 
	   	     {
	   	       boolean selected = e.isSelected();
	   		return selected;
	   		}
	   	     
	   	     //25.click
	   	     
	   	     public static void click() 
	   	     {
	   	        Actions a= new Actions(driver);
	   	        a.click().perform();
	   		}
	   	     
	   	     //26.contextClick
	   	     
	   	     public static void contextClick()
	   	     {
	   	    	 Actions a= new Actions(driver);
	   	    	 a.contextClick();
	   		}
	   	     
	   	     //27.navigation
	   	     //back
	   	     
	   	     public static void back()
	   	     {
	   	         driver.navigate().back();
	   		}
	   	     
	   	     //28.//forward
	   	     
	   	     public static void forward() 
	   	     {
	   	        driver.navigate().forward();
	   		}
	   	     
	   	     //29.refresh
	   	     
	   	     public static void refresh()
	   	     {
	   	         driver.navigate().refresh();
	   		}
	   	     
	   	     //30.to
	   	     
	   	     public static void to() 
	   	     {
	   	           driver.navigate().to(getCurrentUrl());
	   		}
	   	     
	   	     //31.frames
	   	     //switchto
	   	     
	   	     public static void switchToWindow() 
	   	     {
	   	         driver.switchTo().window(getCurrentUrl());
	   		}
	   	     
	   	     //32.switchtoFrame
	   	     
	   	       public static WebDriver switchToFrame(int index)
	   	       {
	   	           WebDriver frame = driver.switchTo().frame(index);
	   			  return frame;
	   		}
	   	       
	   	       //33.Switchtoframeidorname
	   	     
	   	       public static WebDriver switchToIdorName()
	   	       {
	   	          WebDriver frame = driver.switchTo().frame(getCurrentUrl());
	   			return frame;
	   		   }
	   	     
	   	     
	   	      //34.Switchtoframetitle  
	   	     
	   	       public static void Switchtoframetitle(String value) 
	   	       {
	   	            driver.switchTo().frame(value);
	   		   }
	   	       
	   	       //35.actions perform
	   	       
	   	       public static void perform()
	   	       {
	   	          Actions a=new Actions(driver);
	   	          a.perform();
	   		   }
	   	       
	   	       //36.build
	   	       
//	   	       {
//	   	           Actions a=new Actions(driver);
//	   	           a.build();
//	   	 	   }
//	   	     
	   	     //37.sendkeys using action
	   	     
	   	       public static void sendKeysActions(String value) 
	   	       {
	   	    	   
	   	    	          Actions a=new Actions(driver);
	   	    	          a.sendKeys(value);
	   		   }
	   	       
	   	       //38.keyup using actions
	   	        
	   	       public static void keyUp()
	   	       {
	   	    	   Actions a=new Actions(driver);
	   		          a.keyUp(getCurrentUrl());
	   		}
	   	     
	   	       //39.keydown using actions
	   	       
	   	       public static void keyDown()
	   	       {
	   	    	   Actions a=new Actions(driver);
	   		          a.keyDown(getCurrentUrl());
	   		}
	   	       
	   	       //40.release
	   	       
	   	       public static void release()
	   	       {
	   	    	   Actions a=new Actions(driver);
	   		          a.release();
	   		}
	   	       
	   	       //41.threadsleep
	   	       
	   	      public static void threadSleep() throws InterruptedException
	   	      {
	   	           Thread.sleep(5000);
	   		}
	   	      
	   	      //42.getcssValue
	   	      
	   	        public static String cssValue(WebElement e) 
	   	        {
	   	             String cssValue = e.getCssValue(getCurrentUrl());
	   				return cssValue;
	   			}
	   	        
	   	        //44.location
	   	        
	   	        public static void location(WebElement e)
	   	        {
	   	           e.getLocation();
	   			}
	   	       
	   	        //45.getSize
	   	       
	   	       public static void getSize(WebElement e)
	   	       {
	   	           e.getSize();
	   		}
	   	       
	   	       //46.js.equals
	   	       public static boolean equals() 
	   	       {
	   	           JavascriptExecutor js=(JavascriptExecutor) driver;
	   	           
	   	           boolean equals = js.equals(js);
	   			   return equals;
	   		   }
	   	       
	   	       //47.js.tostring
	   	       

	   	           public static String jsToString() 
	   	           {
	   	        	   JavascriptExecutor js=(JavascriptExecutor) driver;
	   	        	   String string = js.toString();
	   				   return string;
	   			   }
	   	       
	   	       //48.executeScript
	   	           
	   	           public static void executeScript(String value)
	   	           {
	   	        	   JavascriptExecutor js=(JavascriptExecutor) driver;
	   	        	   js.executeScript(getCurrentUrl(), value);
	   			   } 
	   	          
	   	       //49.jsWait
	   	           
	   	           public static void jsWait() throws InterruptedException
	   	           {
	   	        	   JavascriptExecutor js=(JavascriptExecutor) driver;
	   	        	   js.wait(6000);
	   			   }
	   	           
	   	         //50.tripleClick
	   	           
	   	           public static void tripleClick() 
	   	           {
	   	               Actions a=new Actions(driver);
	   	               a.contextClick().click();
	   			}
	   	       
	   	       //51.js
	   	     
	   	           public static void js(WebElement e, String value)
	   	           {
	   	        	   JavascriptExecutor js=(JavascriptExecutor) driver;
	   	        	   js.executeScript("arguments[0].setAttribute('value','"+value+"')",e);
	   	           }
	   	           
	   	        //52.jsGetAttribute
	   	           
	   	           public static String jsGetAttribute(WebElement e) 
	   	           {
	   	        	   JavascriptExecutor js=(JavascriptExecutor) driver;
	   	        	   Object atUser = js.executeScript("return arguments[0].getAttribute('value')", e);
	   	        	   String value = atUser.toString();
	   				   return value;
	   			}
	   	           
	   	           
	   	           //53.jsScrollup
	   	           
	   	           public static void jsScrollUp(WebElement e) 
	   	           {
	   	        	   JavascriptExecutor js=(JavascriptExecutor) driver;
	   	        	   js.executeScript("arguments[0].scrollIntoView(false)", e);
	   			}
	   	           
	   	           //53.jsScrollDown
	   	           
	   	           public static void jsScrollDown(WebElement e)
	   	           {
	   	        	   JavascriptExecutor js=(JavascriptExecutor) driver;
	   	        	   js.executeScript("arguments[0].scrollIntoView(true)", e);
	   			   }
	   	           
	   	           
	   	           //54.jsClick
	   	           
	   	           public static void jsClick(WebElement e) 
	   	           {
	   	        	   JavascriptExecutor js=(JavascriptExecutor) driver;
	   	        	   js.executeScript("arguments[0].click()", e);
	   			
	   	           }
	   	           
	   	           
	   	           
	   	           
	   	           
	   	           
	   	           
	   	      	           
	   	           
	   	           
	   	     
	   	     
	   	
	   	
	   	
	   }


