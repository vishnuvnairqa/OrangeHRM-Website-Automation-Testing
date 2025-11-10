package testpkg;

import java.io.IOException;

import org.testng.annotations.Test;


import basepkg.Base;
import basepkg.Reporterclass;
import pagepkg.A_login.A_loginpage;

import pagepkg.B_addcandidate.G_ClaimPage;
import pagepkg.B_addcandidate.G_CreateClaimPage;

public class G_ClaimsTest extends Base   {

	
	
	//Assign Claim >>>> create >>> addexpense >>> save >> submite >> claom >> searcjemopname>> fetrchdetail>> 
	
	

	@Test(priority = 1)
	public void OpenOrange() throws InterruptedException {
		
		
		  
        A_loginpage ob= new A_loginpage(driver);
        Thread.sleep(2000);
        
        ob.input("Admin", "admin123");
        ob.click();
        
        
        Thread.sleep(2000);
     
	   
	}
	
	
	

	   @Test(priority = 2)
		
		private void Assign() throws InterruptedException {
		   
	   G_CreateClaimPage  addmb = new G_CreateClaimPage (driver);
		
		   Thread.sleep(2000);
		   addmb.clameclick();
		   Thread.sleep(2000);
		   addmb.AssignClick();
		   

		   
		   
	        addmb.createClaim(
	                "Vishnu Nair",           // Employee Name
	                "Travel Allowance",      // Event
	                "Indian Rupee",          // Currency
	                "Client meeting travel expenses" // Remarks
	        );

	        Thread.sleep(3000);
	        
	        addmb.clickExpenses();
	        addmb.addExpense(
	                "Accommodation",   // Expense Type option
	                "2025-05-01",      // Date
	                "3500000",            // Amount
	                "client site viste lOndon " // Note
	        );

	        Thread.sleep(3000);
	        
	        
		   
	   }
	
	
	
	   
	   
	 
	   
	   
	   

//	
//	   @Test(priority = 3)
//		
//		private void searchbyName() throws InterruptedException {
//			
//		   G_ClaimPage addd = new G_ClaimPage(driver);
//			Thread.sleep(2000);
//			
//			
//			addd.clameclick();
//			addd.searchbyName("vishnu");
//
//			 Thread.sleep(2000);
//			   addd.printSearchResultDetails();
//
//		}
	
	   @Test(priority = 3)
	   public void searchByName() throws InterruptedException, IOException {
	       test = extent.createTest("ClaimsTest by Name");

	       try {
	           G_ClaimPage addd = new G_ClaimPage(driver);
	           Thread.sleep(2000);
	           addd.clameclick();
	           addd.searchbyName("vishnu");
	           Thread.sleep(2000);

	           addd.printSearchResultDetails();
	           String fetchedName = addd.getFetchedName();

	           if (fetchedName.equalsIgnoreCase("vishnu Nair")) {
	               test.pass("Fetched name is Vishnu — Test Passed ✅");
	           } else {
	               String path = Reporterclass.screenshotMethod(driver, "NameMismatch");
	               test.fail("Fetched name is '" + fetchedName + "' — expected 'Vishnu' ❌")
	                   .addScreenCaptureFromPath(path);
	           }

	       } catch (Exception e) {
	           String path = Reporterclass.screenshotMethod(driver, "SearchByNameError");
	           test.fail("Error during search by name: " + e.getMessage())
	               .addScreenCaptureFromPath(path);
	       }
	   }
	
	
}