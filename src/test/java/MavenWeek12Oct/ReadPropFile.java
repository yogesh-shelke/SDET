package MavenWeek12Oct;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile 
	{
	

	public static void main(String[] args) 
		{
		getProp ();
		writeProp ();
		}
	
	
	
		public static void getProp () 
		{
			File file = new File("./Resources/Config.properties");
        
			FileInputStream fileInput = null;
        
			try {
            		fileInput = new FileInputStream(file);
        		} 
			catch (FileNotFoundException e) 
        		{
            	e.printStackTrace();
        		}
        
			Properties prop = new Properties();
			//load properties file
			try 
			{
				prop.load(fileInput);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
        
			System.out.println("Name of Trainig---->"+prop.getProperty("Training"));
			System.out.println("Batch no is--->"+prop.getProperty("Batch"));
			System.out.println("Start date of batch is--->"+prop.getProperty("StartDate"));
			
		}
		
		public static void writeProp ()
		{
			try {
                Properties properties = new Properties();
                properties.setProperty("Todayis-", "13");
                properties.setProperty("Wearein-", "3rd Week");
                properties.setProperty("ItsGoing-", "Good So far");

                File file1 = new File("./Resources/Config.properties");
                FileOutputStream fileOut = new FileOutputStream(file1, true);
                properties.store(fileOut, "Favorite Things");
                System.out.println("File Writing Completed");
                fileOut.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
		}

}
