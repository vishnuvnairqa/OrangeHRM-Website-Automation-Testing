package pagepkg.B_addcandidate;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class I_TimesheetPage {
	
	
	
    WebDriver driver;

    // ---------- Element Locators ----------
    
 
    
    
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a")
    WebElement time;

    // Employee Name field
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[1]/div/div/div/div[2]/div/div/input")
    WebElement employeeName;

    // View button
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/form/div[2]/button")
    WebElement viewButton;

    
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/button")
    WebElement  createTimesheet ;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[3]/div[2]/button[2]")
    WebElement  submit ;

    @FindBy(xpath = "//button[normalize-space()='View']")
    WebElement  submitmessage ;
    
    
    
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[1]/div[1]/h6")
    private WebElement timesheetTitle;

    // Status text at bottom:  Status: Submitted
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[3]/div[1]/p")
    private WebElement statusText;

    // Optional: timesheet period field
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/form/div[1]/div[2]/div/div/div[2]/div/div/input")
    private WebElement periodInput;
    
    
    
    
    // ---------- Constructor ----------
    public I_TimesheetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ---------- Actions ----------

    public void enterEmployeeName(String name) throws InterruptedException {
    	time.click();
    	  Thread.sleep(2000);
        employeeName.clear();
        Thread.sleep(2000);
        employeeName.sendKeys(name);
        Thread.sleep(2000);
		employeeName.sendKeys(Keys.ARROW_DOWN);
		employeeName.sendKeys(Keys.ENTER);
    }

    public void clickView() throws InterruptedException {
        viewButton.click();
        Thread.sleep(2000);
        createTimesheet.click();
        Thread.sleep(2000);
        submit.click();
        Thread.sleep(2000);
        
        
    }

    // Convenience method: full workflow
    public void viewEmployeeProfile(String name) throws InterruptedException {
        enterEmployeeName(name);
        clickView();
        
        
    }



    
    
    

    public String getTimesheetTitle() {
   
        return timesheetTitle.getText().trim();
    }

    public String getStatusText() {
      
        return statusText.getText().trim();
    }
    public String getStatustime() {
        
        return periodInput.getText().trim();
    }
    public void printTimesheetInfo() {
        System.out.println("Timesheet Header: " + getTimesheetTitle());
        System.out.println("Timesheet Status: " + getStatusText());
        System.out.println("Timesheet Period: " + getStatustime());
    }


	
	


	
	
	
	
	
	

}