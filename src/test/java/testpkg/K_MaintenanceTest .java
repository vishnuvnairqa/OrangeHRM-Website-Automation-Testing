package testpkg;


import java.io.IOException;

import org.testng.annotations.Test;
import basepkg.Base;
import basepkg.Reporterclass;
import pagepkg.A_login.A_loginpage;
import pagepkg.Recruitment.K_MaintenancePage;


public class K_MaintenanceTest extends Base {
	
 
	@Test
    public void OpenOrange() throws InterruptedException {
		A_loginpage log= new A_loginpage(driver);
      
        Thread.sleep(3000);
        
        log.input("Admin", "admin123");
        log.click();
        
        Thread.sleep(2000);
        
      

        
      
    }
	

	@Test
	
	public void bypass() throws InterruptedException {
		K_MaintenancePage page = new  K_MaintenancePage(driver);
		
	
        page.bypass("admin123");
        
        Thread.sleep(2000);
		//page.clickSearch();
		
	}
	
	
	

//	@Test
//	
//	public void searchPastEmployee() throws InterruptedException {
//		K_MaintenancePage page = new  K_MaintenancePage(driver);
//		
//	
//		 Thread.sleep(2000);
//		page.enterEmployee("vishnu");
//		
//		 Thread.sleep(2000);
//		 
//		 
//		
//	        page.printEmployeeDetails();
//	
//		
//	}
	
	
	@Test
	public void searchPastEmployee() throws InterruptedException, IOException {
	    test = extent.createTest("MaintenanceTest Verify Employee Name");

	    K_MaintenancePage page = new K_MaintenancePage(driver);

	    Thread.sleep(2000);
	    page.enterEmployee("vishnu");      // search for the name
	    Thread.sleep(2000);

	    String firstName = page.getFirstName();
	    String middleName = page.getMiddleName();
	    String lastName  = page.getLastName();
	    String fullName  = firstName + " " + middleName + " " + lastName;

	    System.out.println("Fetched Name: " + fullName);
	    test.info("Fetched Name: " + fullName);

	    // ✅ Verify first name (or full name, if you prefer)
	    if (firstName.equalsIgnoreCase("Vishnu")) {
	        test.pass("Fetched employee name is 'ishnu' — verification PASSED ✅");
	    } else {
	        String path = Reporterclass.screenshotMethod(driver, "EmployeeNameMismatch");
	        test.fail("Fetched employee name was '" + fullName + "' — expected 'Vishnu' ❌")
	            .addScreenCaptureFromPath(path);
	    }

	    // Optionally include more info
	    test.info("Employee ID: " + page.getEmployeeId());
	}	

	

}