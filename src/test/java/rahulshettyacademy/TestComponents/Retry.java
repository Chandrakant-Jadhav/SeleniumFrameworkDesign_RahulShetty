package rahulshettyacademy.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

// Retry class is used to re-run failed test cases in TestNG
public class Retry implements IRetryAnalyzer {
	
	int count = 0;      // Tracks current retry count
	int maxTry = 1;     // Maximum retry attempts allowed

	@Override
	public boolean retry(ITestResult result) {
		
		// If retry count is less than maxTry, re-run the test
		if (count < maxTry) {
			count++;
			return true;   // TestNG will retry the failed test
		}
		
		return false;      // No more retries
	}
}