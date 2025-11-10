package testpkg;

import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;
import basepkg.Base;
import basepkg.Reporterclass;
import pagepkg.A_login.A_loginpage;
import pagepkg.A_login.B_DashboardPage;




public class B_DashboardTest extends Base{



	@Test
	public void OpenOrange() throws InterruptedException {
		
		
		
		A_loginpage log= new A_loginpage(driver);
   
        Thread.sleep(3000);
        
        log.input("Admin", "admin123");
        log.click();
        
        Thread.sleep(2000);
        
     
        
        
        
        
        

	}
	
	
	
	 @Test(dependsOnMethods = "OpenOrange")
	    public void printDashboardWidgetTitles() throws InterruptedException, IOException {
		 
		 test=extent.createTest("Dashboard");
		 
	        Thread.sleep(2000);
	        B_DashboardPage dashboard = new B_DashboardPage(driver);
	        List<String> titles = dashboard.getAllWidgetTitles();

	        System.out.println("Dashboard Widget Titles:");
	        for (String title : titles) {
	            System.out.println("- " + title);
	        }
	        
	       
	        
	        
	        if (driver.getCurrentUrl().contains("/dashboard/index")) {

				 System.out.println("Login successfull element fetch");

				 test.pass("pass");
				   

			} else {

			 
				String path = Reporterclass.screenshotMethod(driver,"Loginsuccess ");
				test.addScreenCaptureFromPath(path);

			    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			    test.fail("fail");
			}
       
		
	    }
	


}
