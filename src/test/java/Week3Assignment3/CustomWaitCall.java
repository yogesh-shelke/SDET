package Week3Assignment3;


import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Week1Assignment1.Webdriverdefinition;
import MavenWeek26_27Oct.Page_LoginPage;

public class CustomWaitCall extends Webdriverdefinition
{
	
	static WebDriver driver;
	    @Test(priority=1)
	    public void login_OrangeHRM()
	    {   
	    	driver = getdriver();
	    	
	        getdriver().get("https://opensource-demo.orangehrmlive.com/");
	        
	        CustomWait CW = new CustomWait();
	        CW.isElementPresnt(driver, "xpath", "name", "txtUsername", 20).sendKeys("Admin");
	        CW.isElementPresnt(driver, "cssSelector", "name", "txtPassword", 20).sendKeys("admin123");

	        getdriver().findElement(By.cssSelector("[name='Submit']")).click(); 

	      
	        //this.loginToOrangeHRM(driver, "Admin", "admin123");
	        
	    }
	    
//	    @Test(priority=2)
//	    public void loginHRM_GetTitle()
//	    {
//	        String Title;
//	        Title = getdriver().getTitle();
//	        System.out.print("Title--"+Title);      
//	        
//	    }
	

}
