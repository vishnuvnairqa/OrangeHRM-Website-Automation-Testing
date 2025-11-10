package testpkg;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basepkg.Base;
import basepkg.Reporterclass;
import pagepkg.A_login.A_loginpage;
import pagepkg.B_addcandidate.F_LeavePage;



public class F_LeaveTest extends Base {

	
	@Test
	public void OpenOrange() throws InterruptedException {
		
		
	        Thread.sleep(2000);
	        
	        A_loginpage ob= new A_loginpage(driver);
	        
	        
	        ob.input("Admin", "admin123");
	        ob.click();
	        
	        
	        Thread.sleep(2000);
	     

		
	}
	
	
	
	
	
	

    @Test
    public void assignLeaveTest() throws InterruptedException, IOException {
    	test = extent.createTest("Assign Leave ");
    	 try {	
    	F_LeavePage assign = new F_LeavePage(driver);
    	
    	
    	assign.assignpage();
    	
  
        assign.enterEmployeeName("vishnu");

        // Select leave type (example Annual Leave)
        assign.selectLeaveType();
        Thread.sleep(2000);
        WebElement option = driver.findElement(By.xpath("//div[@role='listbox']//span[text()='CAN - Personal']"));
        option.click();

        assign.enterFromDate("2025-10-10");
        Thread.sleep(2000);
        
        assign.enterToDate("2025-10-12");
        
        
        assign.enterComments("Family Function Leave");
        assign.clickAssign();

        
        assign.handlePopup();
        Thread.sleep(2000); 
	
        try {
            driver.switchTo().alert();
            // Alert still exists → fail
            String path = Reporterclass.screenshotMethod(driver, "PopupStillOpen");
            test.fail("Popup still open after handling!").addScreenCaptureFromPath(path);
        } catch (NoAlertPresentException e) {
            test.pass("Popup handled successfully and leave assigned!");
        }

    } catch (Exception e) {
        String path = Reporterclass.screenshotMethod(driver, "AssignLeaveError");
        test.fail("Error while assigning leave: " + e.getMessage())
            .addScreenCaptureFromPath(path);
    
	
    }
    
    

 
    
    
    
    
    
}}