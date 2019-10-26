package Week3Assignment3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelStoreCollection {

	public static void main(String[] args) throws Exception {
		 
		//
		// An excel file name. You can create a file name with a full
		// path information.
		//
		String filename = "./Resources/Read_Write.xlsx";
		 
		 
		 List sheetData = new ArrayList();
		 FileInputStream fis = null;
		        try {
		 fis = new FileInputStream(filename);
		 
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheet("Scenarios");
		 
		 Iterator rows = sheet.rowIterator();
		            while (rows.hasNext()) {
		                XSSFRow row = (XSSFRow) rows.next();
		                Iterator cells = row.cellIterator();
		 
		                List data = new ArrayList();
		                while (cells.hasNext()) {
		                    XSSFCell cell = (XSSFCell) cells.next();
		                    data.add(cell);
		                }
		 
		                sheetData.add(data);
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		            if (fis != null) {
		                fis.close();
		            }
		        }
		 
				showExcelData(sheetData);
		    }
		 
	
	private static void showExcelData(List sheetData)
	{
        //
        // Iterates the data and print it out to the console.
        //
        for (int i = 0; i < sheetData.size(); i++) {
            List list = (List) sheetData.get(i);
            for (int j = 0; j < list.size(); j++) {
                XSSFCell cell = (XSSFCell) list.get(j);
                System.out.print(cell.getRichStringCellValue().getString());
                if (j < list.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("");
        }
    }

}