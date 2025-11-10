package testpkg;

import org.testng.annotations.Test;

import basepkg.Base;
import pagepkg.A_login.A_loginpage;
import pagepkg.B_addcandidate.I_TimesheetPage;

public class I_TimesheetTest  extends Base {
	
	
	
	//searchempname>> view>>> submit>>
	
	@Test
	public void OpenOrange() throws InterruptedException {

	        
	        A_loginpage ob= new A_loginpage(driver);
	        
	        
	        Thread.sleep(2000);
	        ob.input("Admin", "admin123");
	        ob.click();
	        
	        Thread.sleep(2000);

	}
	


	    @Test
	    public void testViewEmployee() throws InterruptedException {
	    	I_TimesheetPage selectPage = new I_TimesheetPage(driver);

	        // Example usage
	        selectPage.viewEmployeeProfile("vishnu");

	        Thread.sleep(2000); // Prefer WebDriverWait in real tests
	        selectPage.printTimesheetInfo();
	        
	        
	    }
	
	
	
	
	

}