package MavenWeek26_27Oct;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import MavenWeek26_27Oct.Page_LoginPage;

public class NewTest {
    
  WebDriver driver = null;
  
  @Test
  public void f() {
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
     // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      
      //wait = new WebDriverWait(driver,40);
     // WebDriverWait wait=new WebDriverWait(driver, 20);

      driver.get("https://opensource-demo.orangehrmlive.com/");
  }

  @Test
  public void LoginTest()
  {
      Page_LoginPage o_Login = new Page_LoginPage();
      driver = o_Login.loginToOrangeHRM(driver, "Admin", "admin123");
  }
  
  
  
  @AfterSuite
  public void afterSuite() {
  }

}
