package MavenWeek12Oct;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import com.assertthat.selenium_shutterbug.core.Shutterbug;
//import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;


public class TestScreenshot {
	
	public static void main(String[] args) 
	{
		String exePath = "./Resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);             
        WebDriver driver = new ChromeDriver();
        driver.get("http://news.google.com");
        driver.manage().window().maximize();
        Shutterbug.shootPage(driver,ScrollStrategy.WHOLE_PAGE).withName("FullCapture").save("./Screenshot");
        //driver.quit();  
	}
		

}
