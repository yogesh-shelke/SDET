package MavenWeek12Oct;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Verbose_Thread {


@Test    
public void executSessionOne(){
        //First session of WebDriver
    String exePath = "./Resources/chromedriver.exe";
      System.setProperty("webdriver.chrome.driver", exePath);
        ChromeDriver driver = new ChromeDriver();
        //Open URL
        System.out.println("Test Case executSessionOne with Thread Id:- " + Thread.currentThread().getId());
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        Assert.fail();
        //find user name text box and fill it
        
        
    }
    
@Test    
    public void executeSessionTwo(){
        //Second session of WebDriver
    String exePath = "./Resources/chromedriver.exe";
      System.setProperty("webdriver.chrome.driver", exePath);
    WebDriver driver = new ChromeDriver();
        //Open URL
    System.out.println("Test Case executSessionTwo with Thread Id:- " + Thread.currentThread().getId());
    driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    //find user name text box and fill it
    
    
    }
    
@Test    
    public void executSessionThree(){
        //Third session of WebDriver
    String exePath = "./Resources/chromedriver.exe";
      System.setProperty("webdriver.chrome.driver", exePath);
    WebDriver driver = new ChromeDriver();
        //Open URL
    System.out.println("Test Case executSessionThree with Thread Id:- "   + Thread.currentThread().getId());
    driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    //find user name text box and fill it
    
    
    }
}