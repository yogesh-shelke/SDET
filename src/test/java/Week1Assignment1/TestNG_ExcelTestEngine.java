package Week1Assignment1;

import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

import MavenWeek12Oct.Webdriverdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

@Listeners(MavenWeek5_6Oct.Reporting_Listners_6thOct.class)

public class TestNG_ExcelTestEngine extends Webdriverdefinition 
{
	static WebDriver driver;

	@Test(retryAnalyzer = MavenWeek5_6Oct.CustomRetryAnalyzer.class)
	public void ExcelTestSuitRun() 
	{
	try {
		
		File src=new File("./Resources/Read_Write.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh1 = wb.getSheet("Scenarios");
		
		for (int i = 1; i<= sh1.getLastRowNum(); i++)
		{
			String ExecuteTest = sh1.getRow(i).getCell(1).getStringCellValue();
		
			if (ExecuteTest.equals("Yes"))
			{  
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");  
				LocalDateTime now = LocalDateTime.now();  
				String strDate = dtf.format(now);  		
				System.out.println(strDate); 
				String SreenShotName ;
				
				String tcClassString = "Week1Assignment1.ExcelTestCasesMethods" ;
			 	Class<?> tcClass = Class.forName(tcClassString); // convert string classname to class
			 	Object tcClassObj = tcClass.newInstance(); // invoke empty constructor	
			 	
			 	// Reading test case name from Excel
				String tcNameString = ReadExcelCell(sh1, i, 2);
				
				// Reading Test Case data from Excel
				String td1 = ReadExcelCell(sh1, i, 3);
				String td2 = ReadExcelCell(sh1, i, 4);
				String td3 = ReadExcelCell(sh1, i, 5);
				String td4 = ReadExcelCell(sh1, i, 6);
				String td5 = ReadExcelCell(sh1, i, 7);
				
				// Setting up Test case Object to call respective Testcase Class
		        Class<?>[] paramTypes = {WebDriver.class, String.class, String.class, String.class, String.class, String.class};
				Method TestCase = tcClassObj.getClass().getMethod(tcNameString, paramTypes);
		     

				// Invoking Test Case Class Run		
				boolean TCResult = (boolean) TestCase.invoke(tcClassObj, driver, td1, td2, td3, td4, td5);
				
				if (TCResult)
				 	{
					 sh1.getRow(i).createCell(8).setCellValue("Pass");
				 	 SreenShotName	= tcNameString + " Pass " + strDate;
				 	 Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE).withName(SreenShotName).save("./Screenshot");
				 	}
					
				else
					{
					 sh1.getRow(i).createCell(8).setCellValue("Fail");
					 SreenShotName	= tcNameString + " Fail "+ strDate;
				 	 Shutterbug.shootPage(driver,ScrollStrategy.WHOLE_PAGE).withName(SreenShotName).save("./Screenshot");
					}
				
				// where you want to save file
				 FileOutputStream fout=new FileOutputStream(new File("./Resources/Read_Write.xlsx"));
				 				 
				// finally write content 
				 wb.write(fout);
				 
				// close the file
				 fout.close();		
				} 
			}	
		 wb.close();
		}catch (Exception e) {System.out.println(e.getMessage());} 
  	}
  
  

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
	  // closing web page 
	  driver.close();
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	  driver = getdriver();
	  driver.manage().window().maximize();
  }

  @AfterSuite
  public void afterSuite() {
  }
  
  
  
  
// Supporting Methods
public static String ReadExcelCell (XSSFSheet sh , int rownum, int cellnum) 
	{
	XSSFCell cell = sh.getRow(rownum).getCell(cellnum);
	String value = "";
	
	if (cell != null)
	{ 
	switch (cell.getCellType()) 
	{
	case BLANK:
		 value = "";
	     break;
	case NUMERIC:
		 value = "" + cell.getNumericCellValue();
		 break;
	case STRING:
		 value = "" + cell.getStringCellValue();
	     break;
	default:
	     break;       
	}
	
	}
	
	return value;
	
	}
    

}
