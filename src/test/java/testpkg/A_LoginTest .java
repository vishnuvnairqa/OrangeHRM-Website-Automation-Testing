package testpkg;


import java.io.IOException;

import org.testng.annotations.Test;

import basepkg.Base;
import basepkg.Reporterclass;
import pagepkg.A_login.A_loginpage;
import utilitypkg.Exutilities;

public class A_LoginTest extends Base {
	


	@Test
public void test1() throws InterruptedException, IOException {
		
	test=extent.createTest("login test");
		
	A_loginpage log= new A_loginpage(driver);
	         Thread.sleep(2000);
	
	        
	
		String xl ="C:\\Users\\PC\\Downloads\\hrm.xlsx";      
		
		String Sheet = "Sheet1";                                                  
		int rowcount = Exutilities.getRowCount(xl, Sheet);
		System.out.println(rowcount);
		
		
		for (int i = 0; i <= rowcount; i++ ) {
			
			int cellcount = Exutilities.getCellCount(xl, Sheet, i);
			System.out.println("cellcount "  + cellcount);
			
			for (int j=0; j < cellcount ; j +=2) {
				
				
				String username = Exutilities.getCellValue(xl, Sheet, i, j);
				System.out.println("username  "  + username);
				
				String pswd = Exutilities.getCellValue(xl, Sheet, i, j+1);
				System.out.println("password  "  + pswd);
				
				Thread.sleep(3000);
				log.input(username, pswd);
				log.click();
				
		
				Thread.sleep(2000);
				
				
				
				
				

	
				if (driver.getCurrentUrl().contains("/dashboard/index")) {

					 System.out.println("Login successfull");

					 test.pass("pass");
					    log.logout();

				} else {

				 
					String path = Reporterclass.screenshotMethod(driver,"Loginsuccess"+username);
					test.addScreenCaptureFromPath(path);

				    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				    test.fail("fail");
				}
	        
			}
						
			
			
			
		}
	
		
	}


		

	
	
	
	

	
	
	

}