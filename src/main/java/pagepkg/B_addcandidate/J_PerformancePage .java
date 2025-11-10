package pagepkg.B_addcandidate;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class J_PerformancePage {
	


	    WebDriver driver;

	    // ---------- Element Locators ----------

	    
	    @FindBy(xpath = " //*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[7]/a/span")
	    WebElement Performance;
	    
	
	    
	    // Text / autocomplete
	    @FindBy(xpath = "//label[text()='Employee Name']/following::input[1]")
	    WebElement employeeName;

	    // Dropdowns
	    @FindBy(xpath = "//label[text()='Job Title']/following::div[contains(@class,'oxd-select-text')][1]")
	    WebElement jobTitleDropdown;

	    @FindBy(xpath = "//label[text()='Sub Unit']/following::div[contains(@class,'oxd-select-text')][1]")
	    WebElement subUnitDropdown;

	    @FindBy(xpath = "//label[text()='Include']/following::div[contains(@class,'oxd-select-text')][1]")
	    WebElement includeDropdown;

	    @FindBy(xpath = "//label[text()='Review Status']/following::div[contains(@class,'oxd-select-text')][1]")
	    WebElement reviewStatusDropdown;

	    // Date fields
	    @FindBy(xpath = "//label[text()='From Date']/following::input[1]")
	    WebElement fromDate;

	    @FindBy(xpath = "//label[text()='To Date']/following::input[1]")
	    WebElement toDate;

	    // Buttons
	    @FindBy(xpath = "//button[normalize-space()='Search']")
	    WebElement searchButton;

	    @FindBy(xpath = "//button[normalize-space()='Reset']")
	    WebElement resetButton;


	    // ---------- Constructor ----------
	    public J_PerformancePage(WebDriver driver) {
	    	 this.driver = driver;
		        PageFactory.initElements(driver, this);
		}

		
	    public void page() {
	        Performance.click();
	    }
	    // ---------- Action Methods ----------

	    public void setEmployeeName(String name) throws InterruptedException {
	        employeeName.clear();
	        employeeName.sendKeys(name);
	        Thread.sleep(2000);
	        
	        employeeName.sendKeys(Keys.ARROW_DOWN);
	        employeeName.sendKeys(Keys.ENTER);
	     
	    }

	    public void selectJobTitle(String jobTitle) {
	        jobTitleDropdown.click();
	        WebElement option = driver.findElement(By.xpath("//div[@role='option']//span[text()='" + jobTitle + "']"));
	        option.click();
	    }

	    public void selectSubUnit(String subUnit) {
	        subUnitDropdown.click();
	        WebElement option = driver.findElement(By.xpath("//div[@role='option']//span[text()='" + subUnit + "']"));
	        option.click();
	    }

	    public void selectInclude(String includeText) {
	        includeDropdown.click();
	        WebElement option = driver.findElement(By.xpath("//div[@role='option']//span[text()='" + includeText + "']"));
	        option.click();
	    }

	    public void selectReviewStatus(String status) {
	        reviewStatusDropdown.click();
	        WebElement option = driver.findElement(By.xpath("//div[@role='option']//span[text()='" + status + "']"));
	        option.click();
	    }

	    public void setFromDate(String from) throws InterruptedException {
	        fromDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	        fromDate.sendKeys(Keys.DELETE);
	        Thread.sleep(2000);
	        fromDate.sendKeys(from);
	    }

	    public void setToDate(String to) throws InterruptedException {
	    	toDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	    	toDate.sendKeys(Keys.DELETE);
	        Thread.sleep(2000);
	        toDate.sendKeys(to);
	    }

	    public void clickSearch() {
	        searchButton.click();
	    }

	    public void clickReset() {
	        resetButton.click();
	    }

	    // Combined convenience method
	    public void filterEmployeeReviews(String empName, String jobTitle, String subUnit,
	                                      String includeText, String status,
	                                      String from, String to) throws InterruptedException {

	        setEmployeeName(empName);
	        selectJobTitle(jobTitle);
	        Thread.sleep(2000);
	        selectSubUnit(subUnit);
	        Thread.sleep(2000);
	        selectInclude(includeText);
	        selectReviewStatus(status);
	        
	        setFromDate(from);
	        setToDate(to);
	        clickSearch();
	        clickReset();
	    }
	
	


	
	
	

}