package testpkg;

import java.io.IOException;

import org.testng.annotations.Test;

import basepkg.Base;
import basepkg.Reporterclass;
import pagepkg.A_login.A_loginpage;
import pagepkg.B_addcandidate.DA_PIMsearchEmpPage;
import pagepkg.B_addcandidate.D_PIMaddEmpPage;

public class D_PIMTest extends Base {

	
	
// add employ and search it on the list
	

	@Test (priority = 1)
	public void OpenOrange() throws InterruptedException {
		
		
	        Thread.sleep(2000);
	        
	        A_loginpage ob= new A_loginpage(driver);
	        
	        
	        ob.input("Admin", "admin123");
	        ob.click();
	        
	        
	        Thread.sleep(2000);
	     

		
	}
	
	
	
	
	
	
	@Test(priority = 2)
	
    public void nameAdd() throws InterruptedException {
    	
    	
    	 
    	D_PIMaddEmpPage add= new D_PIMaddEmpPage (driver);
    	
    	add.addemp();
   	   
    	add.input("vishnu", "V", "Nair", "1238");
    	Thread.sleep(2000);
    	add.save();
    	
	}
    
    
//    
//	@Test(priority = 3)
//	
//	private void searchbyName() throws InterruptedException {
//		
//		DA_PIMsearchEmpPage addd= new DA_PIMsearchEmpPage (driver);
//		Thread.sleep(2000);
//		
//		
//		addd.pimclick();
//		addd.searchbyName("vishnu");
//
//		 Thread.sleep(2000);
//		   addd.printSearchResultDetails();
//
//	}
//	
//	
//	
//	   
//		@Test(priority = 4)
//		
//		private void searchbyID() throws InterruptedException {
//			
//			DA_PIMsearchEmpPage addd= new DA_PIMsearchEmpPage (driver);
//			Thread.sleep(2000);
//			
//			
//			addd.pimclick();
//			addd.searchbyID("1238");
//
//			 Thread.sleep(2000);
//			    addd.printSearchResultDetails();
//
//		}
		
		
		
		@Test(priority = 3)
		public void searchByName() throws InterruptedException, IOException {
		    test = extent.createTest("PIMTest(Search by Name)");

		    try {
		        DA_PIMsearchEmpPage page = new DA_PIMsearchEmpPage(driver);

		        page.pimclick();
		        page.searchbyName("vishnu");
		        Thread.sleep(2000);
		        page.printSearchResultDetails();
		        // Grab fetched data – assume locator methods read first row values
		        String fetchedName = page.getFetchedName();
		        String fetchedId   = page.getFetchedId();

		        System.out.println("Fetched → Name: " + fetchedName + " | ID: " + fetchedId);
		        test.info("Fetched → Name: " + fetchedName + ",  ID: " + fetchedId);
//		        System.out.println(fetchedName);
//		        System.out.println(fetchedId);
//		        
		        
		        if (fetchedName.equalsIgnoreCase("Vishnu V") && fetchedId.equals("1238")) {
		            test.pass("Name = 'Vishnu' and ID = '1238' — verification PASSED ✅");
		        } else {
		            String path = Reporterclass.screenshotMethod(driver, "SearchByNameMismatch");
		            test.fail("Mismatch! Fetched → Name: " + fetchedName + ", ID: " + fetchedId)
		                .addScreenCaptureFromPath(path);
		        }

		    } catch (Exception e) {
		        String path = Reporterclass.screenshotMethod(driver, "SearchByNameError");
		        test.fail("Error during search by name: " + e.getMessage())
		            .addScreenCaptureFromPath(path);
		    }
		}
		
		
		@Test(priority = 4)
		public void searchById() throws InterruptedException, IOException {
		    test = extent.createTest("PIMTest(Search by ID)");

		    try {
		        DA_PIMsearchEmpPage page = new DA_PIMsearchEmpPage(driver);

		        page.pimclick();
		        page.searchbyID("1238");
		        Thread.sleep(2000);
		        page.printSearchResultDetails();
		        String fetchedName = page.getFetchedName();
		        String fetchedId   = page.getFetchedId();

		        System.out.println("Fetched → Name: " + fetchedName + " | ID: " + fetchedId);
		        test.info("Fetched → Name: " + fetchedName + ",  ID: " + fetchedId);
		        
		        if (fetchedName.equalsIgnoreCase("Vishnu V") && fetchedId.equals("1238")) {
		            test.pass("Name = 'Vishnu' and ID = '1238' — verification PASSED ✅");
		        } else {
		            String path = Reporterclass.screenshotMethod(driver, "SearchByIdMismatch");
		            test.fail("Mismatch! Fetched → Name: " + fetchedName + ", ID: " + fetchedId)
		                .addScreenCaptureFromPath(path);
		        }

		    } catch (Exception e) {
		        String path = Reporterclass.screenshotMethod(driver, "SearchByIdError");
		        test.fail("Error during search by ID: " + e.getMessage())
		            .addScreenCaptureFromPath(path);
		    }
		}
		
		
	
}