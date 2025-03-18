package com.finalpa;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.baseclass.Base_class;
import com.pom.Home_Page;
import com.pom.Parfum_Page;

import utilities.RetryAnalyzer_Test;
import utilities.TestListener;
import utilities.Test_Configuration;
@Listeners(TestListener.class)
public class Assessment extends Base_class {

	public static Home_Page home;
	public static Parfum_Page parfum;
	public static Test_Configuration config;
	@Parameters("browser")
	@BeforeClass
	public void browser_Launching(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			browser_Launch("chrome");
			maximizeWindow();
		}else if(browser.equalsIgnoreCase("edge")) {
			browser_Launch("edge");
			maximizeWindow();
		}
		
	}

	@Test(priority = 1, retryAnalyzer = RetryAnalyzer_Test.class)
	public void user_Click_The_Parfum_Category() throws Throwable {
//		browser_Launch("chrome");
//		maximizeWindow();
		// driver.get("https://www.douglas.de/de");
		try {
		config = new Test_Configuration();
		launch_Url(config.getUrl());
		home = new Home_Page(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		threadMethod();
		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("usercentrics-root")));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Object shadowRoot = js.executeScript("return arguments[0].shadowRoot", shadowHost);
		if (shadowRoot == null) {
			throw new NullPointerException("Shadow root not found! The page might not be fully loaded.");
		}

		WebElement accInfo = (WebElement) js.executeScript(
				"return arguments[0].querySelector('button[data-testid=\"uc-accept-all-button\"]')", shadowRoot);
		if (accInfo == null) {
			throw new NullPointerException("'ALL ERLAUBEN' button not found. check the selector.");
		}
		if(accInfo.isEnabled()) {
			accInfo.click();
		}else {
			System.out.println("Element isn't clickable");
		}
		
		System.out.println("Successfully clicked");

		clickOnElement(home.getParfumOption());
		System.out.println("Successfull");
	}catch (Exception e) {
		System.out.println("Getting the error in user_Click_The_Parfum_Category: " + e.getMessage());
        throw e;  
    }
	}

	@Test(priority = 2,retryAnalyzer = RetryAnalyzer_Test.class)
	public void user_Clicks_The_All_Filter_Options() throws Throwable {
		try{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		parfum = new Parfum_Page(driver);
		Assert.assertTrue(parfum.getMehrFilter().isDisplayed() || parfum.getMehrFilter().isEnabled()
				, "Filter element is not ready to interact.");
		clickOnElement(parfum.getMehrFilter());
		
		threadMethod();
		
		Assert.assertTrue(parfum.getGeschenkfür().isDisplayed() || parfum.getGeschenkfür().isEnabled()
				, "Gift dpdo element is not ready to interact.");
		clickOnElement(parfum.getGeschenkfür());
		
		threadMethod();
		
		Assert.assertTrue(parfum.getGeschenkfürElement().isDisplayed() || parfum.getGeschenkfürElement().isEnabled()
				, "Gift element is not ready to interact.");
		clickOnElement(parfum.getGeschenkfürElement());
		
		threadMethod();
		
		Assert.assertTrue(parfum.getProduktart().isDisplayed() || parfum.getProduktart().isEnabled()
				, "Product dpdo element is not ready to interact.");
		clickOnElement(parfum.getProduktart());
		
		threadMethod();
		
		Assert.assertTrue(parfum.getProduktartElement().isDisplayed() || parfum.getProduktartElement().isEnabled()
				, "Product element is not ready to interact.");
		clickOnElement(parfum.getProduktartElement());
		
		threadMethod();
		
		Assert.assertTrue(parfum.getMarke().isDisplayed() || parfum.getMarke().isEnabled()
				, "Brand dpdo element is not ready to interact.");
		
		clickOnElement(parfum.getMarke());
		
		threadMethod();
		
		Assert.assertTrue(parfum.getMarkeEelment().isDisplayed() || parfum.getMarkeEelment().isEnabled()
				, "Brand element is not ready to interact.");
		clickOnElement(parfum.getMarkeEelment());
		
		threadMethod();
		
		Assert.assertTrue(parfum.getFürWen().isDisplayed() || parfum.getFürWen().isEnabled()
				, "Gender dpdo element is not ready to interact.");
		clickOnElement(parfum.getFürWen());
		
		threadMethod();
		
		Assert.assertTrue(parfum.getFürWenElement().isDisplayed() || parfum.getFürWenElement().isEnabled()
				, "Gender element is not ready to interact.");
		clickOnElement(parfum.getFürWenElement());
		threadMethod();
		
	}catch (Exception e) {
        System.out.println("Getting the error in user_Clicks_The_All_Filter_Options: " + e.getMessage());
        throw e;  
    }
	}
	@Test(priority = 3,retryAnalyzer = RetryAnalyzer_Test.class)
	public void validate_The_Listed_Products() throws Throwable {
		try {
		List<WebElement> products = driver.findElements(By.xpath
				("//*[@class='cms-container']//descendant::div[@class='text top-brand']"));
		
		Assert.assertFalse(products.isEmpty(),"No products are displayed after applying filter!");
		System.out.println("Successfully Valiadte the listed products");
	}catch (Exception e) {
        System.out.println(" Getting the error in validate_The_Listed_Products: " + e.getMessage());
        throw e;  
    }
	}
}
