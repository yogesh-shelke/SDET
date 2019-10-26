package MavenWeek5_6Oct;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

//import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelTestSuitRun 
{
	static WebDriver driver;

	public static void main(String[] args) 
	{ 
		
		try {
			File src=new File("./Resources/Read_Write.xlsx");
			FileInputStream fis=new FileInputStream(src);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh1= wb.getSheet("Scenarios");
		
			for (int i = 1; i<= sh1.getLastRowNum(); i++ )
			{
				String ExecuteTest = sh1.getRow(i).getCell(1).getStringCellValue();
			
				if (ExecuteTest.equals("Yes"))
				{	String tcClassString = "MavenWeek5_6Oct.ExcelTestCasesMethods" ;
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
			        Class<?>[] paramTypes = {String.class, String.class, String.class, String.class, String.class};
					Method TestCase = tcClassObj.getClass().getMethod(tcNameString, paramTypes);
			     
	
					// Invoking Test Case Class Run		
					boolean TCResult = (boolean) TestCase.invoke(tcClassObj, td1, td2, td3, td4, td5);
					
					if (TCResult)
					 	{sh1.getRow(i).createCell(8).setCellValue("Pass");}
					else
						{sh1.getRow(i).createCell(8).setCellValue("Fail");}
					
					
					// where you want to save file
					 FileOutputStream fout=new FileOutputStream(new File("./Resources/Read_Write.xlsx"));
					 
					 
					// finally write content 
					 wb.write(fout);
					 
					// close the file
					 fout.close();
				} 
			}	
			
			} catch (Exception e) {System.out.println(e.getMessage());}
		}
		

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
