package testpkg;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.Base;
import basepkg.Reporterclass;
import pagepkg.A_login.A_loginpage;
import pagepkg.B_addcandidate.E_AdminPage;

public class E_AdminTest extends Base {

	

	@Test(priority = 1)
	public void OpenOrange() throws InterruptedException {
		
		
	   
	        
	        A_loginpage ob= new A_loginpage(driver);
	        Thread.sleep(2000);
	        
	        ob.input("Admin", "admin123");
	        ob.click();
	        
	        
	        Thread.sleep(2000);
	     

		
	}
	
	
	
	
	  @Test(priority = 2)
	    public void createNewUser() throws InterruptedException {
		  E_AdminPage addUser = new E_AdminPage(driver);
		  
		  addUser.adminclick();
		  Thread.sleep(1000);
		  addUser.addclick();
		  
		  Thread.sleep(1000);
	       

	        addUser.addUser(
	                "Admin",          // User Role
	                "vishnu",  // Employee Name (choose valid)
	                "Enabled",         // Status
	                "newuser1011",      // Username
	                "Pass@1234",       // Password
	                "Pass@1234"        // Confirm Password
	        );

	        Thread.sleep(3000);
	
	
	
	
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test (priority = 3)
	public void search() throws InterruptedException {
		
		E_AdminPage sr = new E_AdminPage(driver);
	
		     
	
		sr.search("vishnu");
		
		Thread.sleep(2000);

        // Fetch and print record found count text
        System.out.println("Record Info: " + sr.getRecordFoundText());

        // Print search result row
        sr.printSearchResult();
		
		
	}
	
	
	
	
//	@Test (priority = 4)
//	public void confermation() throws InterruptedException {
//		E_AdminPage sr = new E_AdminPage(driver);
//
//        A_loginpage ob= new A_loginpage(driver);
//        ob.logout();
//        
//        Thread.sleep(2000);
//        
//        ob.input("newuser1011", "Pass@1234");
//        ob.click();
//        
//        
//        Thread.sleep(2000);
//        
//        
//        String actualUserName = sr.getDisplayedUserName();
//        String expectedUserName = "vishnu Nair";
//
//        System.out.println("Actual displayed username: " + actualUserName);
//        System.out.println("Expected username: " + expectedUserName);
//
//        Assert.assertEquals(actualUserName, expectedUserName,
//            "Displayed username does not match expected value!");
//        
//	}
	
//	  @Test(priority = 4)
//	    public void confirmation() throws InterruptedException, IOException {
//	        test = extent.createTest("Confirm admin Login and Verify Username");
//
//	        E_AdminPage sr = new E_AdminPage(driver);
//	        A_loginpage ob = new A_loginpage(driver);
//
//	        // Logout and login again
//	        ob.logout();
//	        Thread.sleep(2000);
//
//	        ob.input("newuser1011", "Pass@1234");
//	        ob.click();
//	        Thread.sleep(2000);
//
//	        // Check login success and displayed username
//	        try {
//	            String actualUserName = sr.getDisplayedUserName();
//	            String expectedUserName = "Vishnu Nair";
//
//	            System.out.println("Actual username: " + actualUserName);
//	            System.out.println("Expected username: " + expectedUserName);
//
//	            if (driver.getCurrentUrl().contains("/dashboard/index")) {
//	                Assert.assertEquals(actualUserName, expectedUserName, "Username mismatch after login!");
//	                test.pass("Login successful — username verified as: " + actualUserName);
//	            } else {
//	                String path = Reporterclass.screenshotMethod(driver, "Login_Failure");
//	                test.fail("Login unsuccessful — dashboard not loaded")
//	                    .addScreenCaptureFromPath(path);
//	            }
//	        } catch (Exception e) {
//	            String path = Reporterclass.screenshotMethod(driver, "Username_Verification_Error");
//	            test.fail("Error while verifying username: " + e.getMessage())
//	                .addScreenCaptureFromPath(path);
//	        }
//	    }
	

	  @Test(priority = 4)
	  public void confirmation() throws InterruptedException, IOException, TimeoutException {
	      test = extent.createTest("Admin Login and Verify Username");

	      E_AdminPage sr = new E_AdminPage(driver);
	      A_loginpage ob = new A_loginpage(driver);

	      ob.logout();
	      Thread.sleep(2000);

	      ob.input("newuser1011","Pass@1234");
	      ob.click();

	      try {
	          new WebDriverWait(driver, Duration.ofSeconds(10))
	                  .until(ExpectedConditions.urlContains("/dashboard/index"));

	          String actualUserName = sr.getDisplayedUserName().trim();
	          String expectedUserName = "Vishnu Nair";

	          System.out.println("Fetched username → [" + actualUserName + "]");
	          test.info("Fetched username: " + actualUserName);

	          if (actualUserName.equalsIgnoreCase(expectedUserName)) {
	              test.pass("Login successful – username matched: " + actualUserName);
	          } else {
	              String path = Reporterclass.screenshotMethod(driver, "UsernameMismatch");
	              test.fail("Expected '"+expectedUserName+"' but got '"+actualUserName+"'")
	                  .addScreenCaptureFromPath(path);
	          }

	      } catch (Exception e) {
	          String path = Reporterclass.screenshotMethod(driver, "UsernameVerificationError");
	          test.fail("Error verifying username: " + e.getMessage())
	              .addScreenCaptureFromPath(path);
	      }
	  }
	
	
}