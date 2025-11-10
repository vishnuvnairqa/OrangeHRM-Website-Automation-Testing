package basepkg;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporterclass {
	
	public static WebDriver driver;
	public static 	ExtentSparkReporter reporter;
	public static 	ExtentReports extent;
	public static ExtentTest test;
		
		@BeforeTest
		public static  ExtentReports sam() {
			reporter = new ExtentSparkReporter("C:\\Users\\PC\\eclipse-workspace\\orangehrm\\Reports\\orangehrm.html");
			reporter.config().setDocumentTitle(" Automation Report ");
			reporter.config().setReportName("Functional Test");
			reporter.config().setTheme(Theme.DARK);
			
			
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("hostname", "localhost");
			extent.setSystemInfo("os ", "windows 11");
			extent.setSystemInfo("QA Tesrter name ", "Vishnu V");
			extent.setSystemInfo("QA Head name ", "Hridya Hari ");
			extent.setSystemInfo("Browser name ", "Chrome");
			driver = new ChromeDriver();
			return extent;
			
		}

		
		@AfterMethod
		
		public void brrowserclass(ITestResult result) throws IOException {
			
			if (result.getStatus()== ITestResult.FAILURE) {
				
				test.log(Status.FAIL, "test case failed is "+ result.getName());
				test.log(Status.FAIL, "test case failed is "+ result.getThrowable());
				
				
		
			}else if (result.getStatus()== ITestResult.SKIP) {
				test.log(Status.SKIP, "test case skipped is "+ result.getName());
				
				
			}else if (result.getStatus()== ITestResult.SUCCESS) {
				test.log(Status.PASS, "test case Passed is "  + result.getName()  );
			}
		
		}
		
		
		
		
		public static String screenshotMethod (WebDriver driver, String screenshotname) throws IOException {
			
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			String destination = "C:\\Users\\PC\\eclipse-workspace\\orangehrm\\Reports\\"+screenshotname+".png";
			FileHandler.copy(src,new File(destination));
			
			return destination;
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


