package MavenWeek5_6Oct;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class CustomRetryAnalyzer implements IRetryAnalyzer
{
	int counter = 0;
	int retryLimit = 3;
			
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(counter < retryLimit)
        {
            System.out.println("*Retry count* " +counter);
            counter++;
            return true;
        }
		return false;
	}
	
}
