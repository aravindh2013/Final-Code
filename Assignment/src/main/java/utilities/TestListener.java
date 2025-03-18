package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.baseclass.Base_class;

public class TestListener extends Base_class implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test Started: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: " + result.getName());
		takeScreenshot(result.getName());
	}

	public void takeScreenshot(String testName) {
		// Convert WebDriver object to TakeScreenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// Define destination path (inside "screenshots" folder)
		String destPath = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
		File destination = new File(destPath);

		try {
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot saved at: " + destPath);
		} catch (IOException e) {
			System.out.println("Failed to save screenshot: " + e.getMessage());
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: " + result.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("All tests completed.");
	}
}
