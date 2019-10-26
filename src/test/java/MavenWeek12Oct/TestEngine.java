package MavenWeek12Oct;

import java.awt.AWTException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.xml.parsers.ParserConfigurationException;
//import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

     
public class TestEngine  
{
    static public WebDriver driver;
    
    
    
    ArrayList<String> row;
        
//    Setter_Getter o_SetGet = new Setter_Getter();
        
    @BeforeSuite
    public void Prerunsetup() throws IOException
    {
//      Runtime rt = Runtime.getRuntime();
//      Process pr = rt.exec("Taskkill /IM Chrome.exe /F");
//      pr = rt.exec("Taskkill /IM Chromedriver.exe /F");
//                              
    }
    
    
    @BeforeTest
    public void Setup() throws IOException, InterruptedException
    {
        String ViewType, Browser_Value;     
    }
    
    @DataProvider(name = "DP_Flow")
    public Iterator<Object[]> credentials() throws IOException
    {
        String RunType;             
        System.out.print("Inside Authentication1 --->");
        Collection<Object[]> arrayExcelData1 =  new ArrayList<>(); 
        File src=new File("./Resources/Read_Write.xlsx");
        FileInputStream fis=new FileInputStream(src);
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        String[][] Arraydata = null;
        XSSFSheet sh1;
        sh1 = null;
        sh1= wb.getSheetAt(2);
        int totalNoOfCols = sh1.getLastRowNum();
        System.out.println("Last row count ++++ " + String.valueOf(totalNoOfCols));
        System.out.println("Count of data-->"+totalNoOfCols);
        Arraydata=new String[2][totalNoOfCols];     
        XSSFRow Row_Excel = sh1.getRow(0);
        int colNum = Row_Excel.getLastCellNum();
        System.out.println("Total Number of Columns in the excel is : "+colNum);
        int rowNum = sh1.getLastRowNum()+1;
        System.out.println("Total Number of Rows in the excel is : "+rowNum);
       // CellType type = ((Object) row).getCellTypeEnum();     
            for (int i= 1 ; i <= rowNum-1; i++)
            {
                ArrayList<String> row = new ArrayList<String>();
                    for (int j= 0 ; j <= colNum-1; j++)
                    {
                        XSSFCell cell = sh1.getRow(i).getCell(j);                                               
   //                     switch(cell.getCellType())
                        row.add(sh1.getRow(i).getCell(j).getStringCellValue());
                        
                        {
    //                        case (Cell.CELL_TYPE_STRING):
                                //System.out.println("***********Inside String ******"+"i-->"+i+"j-->"+j);
                               // row.add(sh1.getRow(i).getCell(j).getStringCellValue());
                                //break;
//                              System.out.println("***********Inside Integer ******");
//                              int t = (int) sh1.getRow(i).getCell(j).getNumericCellValue();
//                             // System.out.println("***********TVALUE ******"+Integer.toString(t));
//                              row.add(Integer.toString(t));
                                //break;        
                           // case (Cell.CELL_TYPE_BLANK):
                               // System.out.println("***********Inside String ******"+"i-->"+i+"j-->"+j);
                                //System.out.println("***********Blank ******"+sh1.getRow(i).getCell(j).getStringCellValue());
                                //row.add(sh1.getRow(i).getCell(j).getStringCellValue());
                               // break;
                        }                      
                     }                  
                    arrayExcelData1.add(new Object[]{row});
            }           
            return arrayExcelData1.iterator();          
  }
        
    
     @Test(dataProvider = "DP_Flow")
      public void Product_Sanity(ArrayList<String> row) throws IOException, InterruptedException, AWTException 
     {              
        System.out.println("Execution-->"+row.get(0));      
        String RunStatus, Team, Scenerio, Location1, Location2, Srch_Param;
        
        System.out.println("***Value before 0***"+row.get(0).toString());
        System.out.println("***Value before 1***"+row.get(1).toString());
        System.out.println("***Value before 2***"+row.get(2).toString());
        System.out.println("***Value before 3***"+row.get(3).toString());
        System.out.println("***Value before 4***"+row.get(4).toString());
        System.out.println("***Value before 5***"+row.get(5).toString());
        
       // o_SetGet.set_Row(row.get(0).toString());
        System.out.println("size of row"+row.size());
        
        for(int i=0;i<row.size();i++)
        {
            System.out.println("***Value before "+i+"***"+row.get(i).toString());
        }
                
                
        if(row.get(0).contains("Yes"))
        {
            System.out.println("***Value before 4***"+row.get(4).toString());
            //System.out.println("VE--Teampath>*(*(*"+Teampath);
            switch(row.get(1)) 
            {
            case "ScenarioA":
                System.out.println("***Inside Scenario A***");
                //Call Test Method here
                //
                
                break;
            case "ScenarioB":
                System.out.println("***Inside Scenario B***");  
                
                break;
               default :                    
                        System.out.println("***Inside Defaulf***"); 
             
            }
            
        }
        else if(row.get(1).contains("No"))
        {
            
            {
                throw new SkipException("Skipping this Test");
            }
            
        }
    } 
    
    @AfterSuite
    public void PostExecution() throws IOException, ParserConfigurationException, SAXException
    {
        String FileName;
        //ileName = "ExcelReport.xls";
        
    }
}
