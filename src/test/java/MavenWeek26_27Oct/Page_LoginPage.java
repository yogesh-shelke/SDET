package MavenWeek26_27Oct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_LoginPage {
    
//  WebDriver driver = null;

    By userName = By.cssSelector("[name='txtUsername']");

    By userPassword = By.cssSelector("[name='txtPassword']");

    By login = By.cssSelector("[value='LOGIN']");
    
    By Passwordlink = By.xpath(".//div[@id='forgotPasswordLink']/a");
    By PasswordUserName = By.xpath(".//input[@id='securityAuthentication_userName']");
    By ForfotPsswrdBttn = By.xpath(".//input[@id='btnSearchValues']");
    //ForgetPassword link click

    public void clickonForgetPssword(WebDriver driver){

        driver.findElement(Passwordlink).click();

    }
    
    //InserEmail for forgot password
    public void setemailforpassword(WebDriver driver, String email){

        driver.findElement(PasswordUserName).sendKeys(email);;

    }
    
    public void ForgotpasswordSubmission(WebDriver driver)
    {
        driver.findElement(ForfotPsswrdBttn).click();;;
    }

    //Set user name in textbox

    public void setUserName(WebDriver driver, String strUserName){

        //Clear text box values
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(strUserName);

    }

    //Set password in password textbox

    public void setPassword(WebDriver driver, String strPassword){

         driver.findElement(userPassword).sendKeys(strPassword);

    }

    //Click on login button

    public void clickLogin(WebDriver driver ){

            driver.findElement(login).click();

    }

    

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    public WebDriver loginToOrangeHRM(WebDriver driver, String strUserName,String strPasword){

        //Fill user name

        this.setUserName(driver, strUserName);

        //Fill password

        this.setPassword(driver, strPasword);

        //Click Login button

        this.clickLogin(driver); 
        
        return driver;
    }
    

    public WebDriver forgetPassword(WebDriver driver, String strUserName,String strPasword){

       
        
        return driver;
    }
}
