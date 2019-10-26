package Week1Assignment1;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExcelTestCasesMethods 
{
	public ExcelTestCasesMethods() 
	{
	// 	Empty Constructor 
	}
	
	 public static boolean LoginOrangeHRM(WebDriver driver, String td1, String td2,String td3,String td4,String td5)
	 {
		  //Login
	     System.out.println("Executing Test1");
		 System.out.println("Test Case executSessionOne with Thread Id:- "   + Thread.currentThread().getId());
	     
		  //Login
		  Login(driver)	; 
	     
	     // Adding Explicit wait for Page title	    
	     WebDriverWait wait = new WebDriverWait(driver,30);
	     Boolean PageTitle =  wait.until(ExpectedConditions.titleIs(td1));

		 if (PageTitle)
		 {
		  return true;
		 }
		 else 
		 {
		  return false;
		 }
	      
	  }

	  public static boolean VerifyPageTile(WebDriver driver, String td1, String td2,String td3,String td4,String td5) 
	  {
		  System.out.println("Executing Test2");
		  System.out.println("Test Case executSessionOne with Thread Id:- "   + Thread.currentThread().getId());

		  //Login
		  Login(driver)	; 
	      
		  String S = driver.getTitle();
		  if (S.equals(td1))
		  {	System.out.println ("page header is as expected " + td1);
		  	return true;
		  }
		  else
		  { System.out.println ("page header is not as expected " + driver.getTitle());
		  	return false;
		  }
		  
	  	}
  
	  
	  public static boolean AdminSearchUser (WebDriver driver, String td1, String td2,String td3,String td4,String td5)
	  {
		  //Click Admin menu 
		  System.out.println("Executing Test3");
		  
		  //Login
		  Login(driver)	;  
		  
		  driver.findElement(By.cssSelector("[id='menu_admin_viewAdminModule']")).click();
		  
		  if (waitForElement(driver, "searchSystemUser_userName"))
		  {
			  driver.findElement(By.cssSelector("[id = 'searchSystemUser_userName']")).sendKeys(td2);
			  driver.findElement(By.cssSelector("[id = 'searchBtn']")).click();
			  
		  }
		  
		  return true;
	  }	

	  
	  
	  
	  
	  //PIMSearchEmp
	  public static boolean PIMSearchEmp (WebDriver driver, String td1, String td2,String td3,String td4,String td5)
	  {
		  //Click PIM menu 
		  System.out.println("Executing Test4");
		  
		  //Login
		  Login(driver)	;  
		  
		//  driver.findElement(By.cssSelector("[id='menu_pim_viewPimModule']")).click();
		  
		  

		  Actions actions = new Actions(driver);
          WebElement menuOption = driver.findElement(By.xpath(".//a[@id='menu_admin_viewAdminModule']"));
          actions.moveToElement(menuOption).perform();
          List<WebElement> el = driver.findElements(By.xpath(".//*[@class='arrow']"));
          el.get(0).click();
		  
		  
		  
		  
		  if (waitForElement(driver, "empsearch_employee_name_empName"))
		  {
			  driver.findElement(By.cssSelector("[id = 'empsearch_employee_name_empName']")).sendKeys(td2);
			  driver.findElement(By.cssSelector("[id = 'searchBtn']")).click();
		  }
		  
		  return true;
	  }	

	  
	  public static boolean ClickMenu(WebDriver driver, String td1, String td2,String td3,String td4,String td5)
	  {
		  //Click on any menu 
		  System.out.println("Executing Test4");
		  driver.findElement(By.cssSelector("[id='menu_recruitment_viewRecruitmentModule']")).click();
		  return true;
	  }	

	
	
	  public static boolean waitForElement(WebDriver driver, String item) 
	  {
		    WebDriverWait wait = new WebDriverWait(driver,30);
		    WebElement element =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(item)));
		    return element.isDisplayed();	    
	  }
	  
	  
	  public static void Login (WebDriver driver) 
	  { 
		    
		  File file = new File("./Resources/Config.properties");
	      FileInputStream fileInput = null;
      
			try 
			{
          		fileInput = new FileInputStream(file);
      		} catch (FileNotFoundException e) {e.printStackTrace();}
      
			Properties prop = new Properties();
			//load properties file
			try 
			{
				prop.load(fileInput);
			} catch (IOException e){e.printStackTrace();}
      
			String Username = prop.getProperty("AdminName");
			String PWD = prop.getProperty("AdminPWD");
			String URL = prop.getProperty("LoginPage");
			
		    driver.get(URL);
		    
		    driver.findElement(By.cssSelector("[name='txtUsername']")).sendKeys(Username);
		    driver.findElement(By.cssSelector("[name = 'txtPassword']")).sendKeys(PWD);
		    driver.findElement(By.cssSelector("[name = 'Submit']")).click();
		     
		    // Adding Explicit wait for Page title	    
		    WebDriverWait wait = new WebDriverWait(driver,30);
		    Boolean PageTitle =  wait.until(ExpectedConditions.titleIs("OrangeHRM"));
		    
		    if (PageTitle) 
		    	System.out.println("---Login Successful---");
		    else
		    	System.out.println("---Login Failed---");
		    

	  }
	  
	
  @Test
  public void f() {
  }
  
}
