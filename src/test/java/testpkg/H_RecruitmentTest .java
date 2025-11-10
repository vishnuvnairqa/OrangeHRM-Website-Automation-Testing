package testpkg;

	import basepkg.Base;
import basepkg.Reporterclass;
import pagepkg.A_login.A_loginpage;
import pagepkg.Recruitment.H_RecruitmentPage;
import pagepkg.Recruitment.H_RecruitmentSearchPage;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;
	

	public class H_RecruitmentTest extends Base {

	    @Test(priority = 1)
	    public void loginAndOpenAddCandidatePage() throws InterruptedException {
	        A_loginpage login = new A_loginpage(driver);
	        Thread.sleep(2000);
	        login.input("Admin", "admin123");
	        login.click();
	        Thread.sleep(2000);
	    }
	    
	    

	    @Test(priority = 2, dependsOnMethods = "loginAndOpenAddCandidatePage")
	    public void addCandidateDetails() throws InterruptedException {
	        // Assuming you're already navigated to Add Candidate page
	    	H_RecruitmentPage addCandidate = new H_RecruitmentPage(driver);
	    	
	    	addCandidate.recruitmentclick();
	    
	    

	        if (addCandidate.isPageDisplayed()) {
	            System.out.println("Page title: " + addCandidate.getPageTitle());
	        }

	        addCandidate.fillFullName("vishnu", "M", "Doe");
	        Thread.sleep(1000);
	       // addCandidate.selectVacancy();
	        Thread.sleep(2000);
	        addCandidate.enterEmail("john.doe@example.com");
	        addCandidate.enterContactNumber("9876543210");
	      //  addCandidate.uploadResume("C:\\Users\\Public\\Documents\\Resume.pdf");
	        addCandidate.enterKeywords("Java, Selenium, TestNG");
	        addCandidate.enterDateOfApplication("2025-12-01");
	        addCandidate.enterNotes("Experienced automation tester.");
	       // addCandidate.clickConsentCheckbox();
	        addCandidate.clickSave();

	        Thread.sleep(3000);
	    }
	
	
	    @Test(priority = 3)
	    public void searchAndFetchCandidate() throws InterruptedException, IOException {
	        test = extent.createTest("Recruitment – Verify Candidate Name");

	        try {
	            H_RecruitmentSearchPage search = new H_RecruitmentSearchPage(driver);

	            Thread.sleep(2000);
	            search.recruitmentclick();
	            Thread.sleep(3000);

	            search.searchCandidate("vishnu");

	            // Record info
	            String recordInfo = search.getRecordFoundText();
	            test.info("Record Info: " + recordInfo);

	            // Get row data
	            List<String> resultData = search.getResultRowData();
	            String fetchedName = resultData.isEmpty() ? "" : resultData.get(0).trim();

	            System.out.println("Fetched candidate: " + fetchedName);
	            test.info("Fetched candidate: " + fetchedName);

	            // ✅  Verify name
	            if (fetchedName.equalsIgnoreCase("vishnu M Doe")) {
	                test.pass("Fetched name is 'Vishnu M Doe' — verification PASSED ");
	            } else {
	                String path = Reporterclass.screenshotMethod(driver, "Recruitment_NameFail");
	                test.fail("Fetched name is '" + fetchedName + " — expected 'Vishnu M Doe' ")
	                    .addScreenCaptureFromPath(path);
	            }

	            // Display all row data (optional)
	            test.info("Candidate Row Details: " + String.join(" | ", resultData));

	        } catch (Exception e) {
	            String path = Reporterclass.screenshotMethod(driver, "RecruitmentSearchError");
	            test.fail("Error while searching candidate: " + e.getMessage())
	                .addScreenCaptureFromPath(path);
	        }
	    }
	    
	    
	    
	    
	    
	    
	    
	
	
	
	
	
}