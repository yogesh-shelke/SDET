package MavenWeek12Oct;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWikiPedia extends Webdriverdefinition

{

	@Test(priority=1)
    public void Launch_Wiki()
    {       
        getdriver().get("https://en.wikipedia.org/wiki/Login");
        
        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='search']")));
          
        getdriver().findElement(By.cssSelector("input[name='search']")).sendKeys("Test Automation");
        getdriver().findElement(By.cssSelector("input[name='go']")).click();
        
        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
     
         
    }
    
	@Test(priority=2)
    public void Ckeck_Wiki()
    {
      String Header =  getdriver().findElement(By.cssSelector("[id=firstHeading]")).getText();
    		  System.out.println("Heading of the page = " + Header);
    		  Assert.assertEquals(Header, "Test automation");
    }
	
	@Test(priority=3)
    public void Get_Hyperlinks()
    {
		List<WebElement> el = driver.findElements(By.tagName("a"));
		

		
		
		for (int i = 0 ; i< el.size(); i++)
		{
			
			System.out.println("---Link " + i + " = " + el.get(i));
			//System.out.println("---Link " + i + " = " + elHref.get(i));
		}
			
		
//		for (int i:el)
//		{
//			
//		}
    }

}
