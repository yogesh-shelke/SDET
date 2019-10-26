package MavenWeek5_6Oct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelTestCasesMethods {
	static WebDriver driver;

	
	public ExcelTestCasesMethods() 
	{
	// Constructor to invoke the WebBrowser
		String exePath = "./Resources/chromedriver.exe";
	    System.setProperty("webdriver.chrome.driver", exePath); 
	    driver = new ChromeDriver();
	}
	

	  public static boolean LoginOrangeHRM(String td1, String td2,String td3,String td4,String td5)
	  	{
		  //Login
	      System.out.println("Executing Test1");
		  System.out.println("Test Case executSessionOne with Thread Id:- "   + Thread.currentThread().getId());
	      driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	      driver.findElement(By.cssSelector("[name='txtUsername']")).sendKeys(td1);
	      driver.findElement(By.cssSelector("[name = 'txtPassword']")).sendKeys(td2);
	      driver.findElement(By.cssSelector("[name = 'Submit']")).click();
	      String S = driver.getTitle();
		  if (S.equals("OrangeHRM")){
			  driver.close();
			  return true;
			  }
		  else {
			  driver.close();
			  return false;
			  }
	      
	  	}

	  public static boolean VerifyPageTile(String td1, String td2,String td3,String td4,String td5) 
	  	{
		  System.out.println("Executing Test2");
		  System.out.println("Test Case executSessionOne with Thread Id:- "   + Thread.currentThread().getId());

		  driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		  driver.findElement(By.cssSelector("[name='txtUsername']")).sendKeys(td1);
		  driver.findElement(By.cssSelector("[name = 'txtPassword']")).sendKeys(td2);
		  driver.findElement(By.cssSelector("[name = 'Submit']")).click();
	      
		  String S = driver.getTitle();
		  if (S.equals(td3))
		  {	System.out.println ("page header is as expected " + S);
		  	driver.close();
		  	return true;
		  }
		  else
		  { System.out.println ("page header is not as expected " + S);
		  	driver.close();
		  	return false;
		  }
		  
	  	}
  
	  public static boolean ClickMenu(String td1, String td2,String td3,String td4,String td5)
	  {
		  //Click on any menu 
		  System.out.println("Executing Test3");
		  driver.findElement(By.cssSelector("[id='menu_recruitment_viewRecruitmentModule']")).click();
		  return true;
	  }	

}
