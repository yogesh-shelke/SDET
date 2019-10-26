package Week3Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomWait {
    
    
    public static WebElement isElementPresnt(WebDriver driver,String LocatorMethod, String tag, String obj , int time)
    {
        WebElement ele = null;
        
        for(int i=0;i<time;i++)
        {
            try{
                System.out.println("***Inside custom wait***");
                
                if (LocatorMethod.equals("xpath")) 
                	ele=driver.findElement(By.xpath(".//*[@" + tag +"='"+ obj +"']"));
                else if (LocatorMethod.equals("cssSelector"))
                	ele=driver.findElement(By.cssSelector("[" + tag + "="+ obj + "]"));
                else 
                	System.out.println("object not found please check the idetifier");
        }
        catch(Exception e)
        {
        try 
        {
            Thread.sleep(1000);
        }
        
        catch (InterruptedException e1) 
        {
            System.out.println("Waiting for element to appear on DOM");
        }
        
        }
    }
    return ele;
    
    }
}


