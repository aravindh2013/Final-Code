package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer_Test implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int maxRetryCount = 2; // Change if needed

	public boolean retry(ITestResult result) {

		if (retryCount < maxRetryCount) {
			retryCount++;
			return true; // Retry failed test
		}
		return false; // Stop retrying
	}

}
