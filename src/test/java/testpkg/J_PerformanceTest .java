package testpkg;

import org.testng.annotations.Test;
import basepkg.Base;


import pagepkg.A_login.A_loginpage;
import pagepkg.B_addcandidate.J_PerformancePage;
public class J_PerformanceTest extends Base {
	
// performance >>> configure >>> tracker >>> add >>>> employe tracker >>> search >>> fatch
	
	
	
	@Test
    public void OpenOrange() throws InterruptedException {
		A_loginpage log= new A_loginpage(driver);
     
        Thread.sleep(3000);
        
        log.input("Admin", "admin123");
        log.click();
        
        Thread.sleep(2000);
        
      
       
        
      
    }
	
	
	
	

	    @Test
	    public void testEmployeeReviewsSearch() throws InterruptedException {
	    	J_PerformancePage reviewPage = new J_PerformancePage(driver);
	    	reviewPage.page();
	    	  Thread.sleep(2000);
	    	
	        reviewPage.filterEmployeeReviews(
	                "vishnu",
	                "QA Engineer",          // Job Title
	                "Quality Assurance",    // Sub Unit
	                "Current Employees Only",
	                "In Progress",              // Review Status
	                "2024-01-01",
	                "2024-03-31"
	        );

	        Thread.sleep(2000);  // replace with explicit waits later
	    }
	
	    
	    
	    
	    
}