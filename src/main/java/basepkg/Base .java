package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Base {
	
	public  WebDriver driver;
	public String url= "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public static 	ExtentReports extent;
	public static ExtentTest test;
		
	
	@BeforeClass
	public void srt () {

		       
				//extent=Reporterclass.sam();
		        driver = new ChromeDriver();
		        driver.get(url);
		        driver.manage().window().maximize();
		
		
	}
	
	
	@BeforeTest
	public void srto () {

		extent=Reporterclass.sam();
	}
	
	
	@AfterTest
	public void srt1() {
		extent.flush();
	}
	
	
	
	

	@AfterClass
	public void srt2() {
		driver.quit();
	}

}
