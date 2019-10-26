package MavenWeek5_6Oct;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

@Listeners(MavenWeek5_6Oct.Reporting_Listners_6thOct.class)
@Test(retryAnalyzer = MavenWeek5_6Oct.CustomRetryAnalyzer.class)

public class NewTestNGTestCase {
	
	static WebDriver driver;
  //@Test (priority=1)
  public void LoginOrangeHRM()
	  {
	     	  
		  //Login
	      System.out.println("Executing Test1");
		  System.out.println("Test Case executSessionOne with Thread Id:- "   + Thread.currentThread().getId());
	      driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	      driver.findElement(By.cssSelector("[name='txtUsername']")).sendKeys("Admin");
          driver.findElement(By.cssSelector("[name = 'txtPassword']")).sendKeys("admin123");
	      driver.findElement(By.cssSelector("[name = 'Submit']")).click();
	      //Assert.fail();
	  }
  
  
  //@Test (priority=2, dependsOnMethods= {"Test1"})
  public void VerifyPageTile() 
	 {
	    //Title  
	     System.out.println("Executing Test2");
	     String S = driver.getTitle();
			if (S.equals("OrangeHRM"))
				System.out.println ("page header is as expected " + S);
			else
				System.out.println ("page header is not as expected " + S);
	 }
  
  
  
 // @Test (priority=3)
	  public void ClickMenu()
	  {
		//Click on any menu 
	      System.out.println("Executing Test3");
	      //Thread.sleep(300);
	      driver.findElement(By.cssSelector("[id='menu_recruitment_viewRecruitmentModule']")).click();
	     // Assert.fail();
	  }	

  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }
  
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	  String exePath = "./Resources/chromedriver.exe";
      System.setProperty("webdriver.chrome.driver", exePath); 
      driver = new ChromeDriver();
  }

  @AfterSuite
  public void afterSuite() {
  }

}
