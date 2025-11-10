package testpkg;

import java.io.IOException;

//import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.Base;
import basepkg.Reporterclass;
import pagepkg.A_login.A_loginpage;
import pagepkg.A_login.C_SearchPage;

public class C_SearchTest extends Base {


	@Test
	public void OpenOrange() throws InterruptedException {
		
		
	        Thread.sleep(2000);
	        
	        A_loginpage ob= new A_loginpage(driver);
	        
	        ob.input("Admin", "admin123");
	        ob.click();
	        
	        
	        Thread.sleep(2000);
	     

		
	}
	

		
	
    
	
	 @Test
	    public void search() throws InterruptedException, IOException {
	        test = extent.createTest("Search box- Valid Entry");

	        C_SearchPage obsrch = new C_SearchPage(driver);
	        Thread.sleep(2000);

	        obsrch.search("pim");
	        Thread.sleep(2000);

	        String resultText = obsrch.getSearchResultText();
	        System.out.println("Search Result: " + resultText);

	        if (resultText.equalsIgnoreCase("PIM")) {
	            test.pass("Search succeeded with result: " + resultText);
	        } else {
	            String path = Reporterclass.screenshotMethod(driver, "SearchFailure_Valid");
	            test.addScreenCaptureFromPath(path);
	            test.fail("Search did not return expected result. Actual: " + resultText);
	        }

	        obsrch.clear();
	    }



	    @Test
	    public void searchInvalid() throws InterruptedException, IOException {
	        test = extent.createTest("Search box- Invalid Entry");

	        C_SearchPage obsrch = new C_SearchPage(driver);
	        Thread.sleep(2000);

	        obsrch.search("abcd");
	        Thread.sleep(2000);

	        String resultText;
	        try {
	            resultText = obsrch.getSearchResultText();
	        } catch (Exception e) {
	            resultText = "No Result"; // fallback if element not found
	        }

	        System.out.println("Search Result: " + resultText);

	        if (!resultText.equalsIgnoreCase("PIM")) {
	            test.pass("Invalid search behaved correctly. Got: " + resultText);
	        } else {
	            String path = Reporterclass.screenshotMethod(driver, "SearchFailure_Invalid");
	            test.addScreenCaptureFromPath(path);
	            test.fail("Unexpected valid result appeared for invalid search!");
	        }

	        obsrch.clear();
	    }
	
	
	
	
	
}
