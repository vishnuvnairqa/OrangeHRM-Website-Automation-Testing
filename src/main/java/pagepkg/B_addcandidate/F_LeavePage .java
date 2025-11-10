package pagepkg.B_addcandidate;




import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class F_LeavePage {
	
	
	
	WebDriver driver;
	
	
		
	@FindBy (xpath= "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a/span")
	WebElement leave;
		
		
	@FindBy (xpath= "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[7]/a")
	WebElement assignleave;
		
	@FindBy (xpath= "//div[@role='listbox']//span[text()='CAN - Personal']")
		WebElement selectleave;
	
	
	
	
	
	// Employee Name field
	@FindBy(xpath = "//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement employeeNameInput;
	
	// Leave Type dropdown
	@FindBy(xpath = "//label[text()='Leave Type']/ancestor::div[contains(@class,'oxd-input-group')]//div[@class='oxd-select-text-input']")
	WebElement leaveTypeDropdown;
	
	// From Date
	@FindBy(xpath = "//label[text()='From Date']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement fromDateInput;
	
	// To Date
	@FindBy(xpath = "//label[text()='To Date']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement toDateInput;
	
	// Comments textarea
	@FindBy(xpath = "//label[text()='Comments']/ancestor::div[contains(@class,'oxd-input-group')]//textarea")
	WebElement commentsBox;
	
	// Assign button
	@FindBy(xpath = "//button[@type='submit']")
	WebElement assignButton;
	
	
	
	
	
	
	// Confirm Leave pop‑up
	@FindBy(xpath = "//div[contains(@class,'oxd-dialog-container')]//p")
	WebElement popupMessage;

	@FindBy(xpath = "//div[contains(@class,'oxd-dialog-container')]//button[normalize-space()='Ok']")
	WebElement popupOkButton;

	@FindBy(xpath = "//div[contains(@class,'oxd-dialog-container')]//button[normalize-space()='Cancel']")
	WebElement popupCancelButton;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Constructor
	public F_LeavePage(WebDriver driver) {
		 this.driver = driver;
		    PageFactory.initElements(driver, this);
	}


	public void assignpage() throws InterruptedException {
		Thread.sleep(2000);
		leave.click();
		Thread.sleep(2000);
		assignleave.click();
		Thread.sleep(2000);
		
	}
	
	
	
	// Actions
	public void enterEmployeeName(String empName) throws InterruptedException {
	    employeeNameInput.sendKeys(empName);
	    Thread.sleep(2000);
	    employeeNameInput.sendKeys(Keys.ARROW_DOWN);
	    employeeNameInput.sendKeys(Keys.ENTER);
	}
	
	
	public void selectleave() {
		
		selectleave.click();
		
	}
	
	
	
	public void selectLeaveType() {
	    leaveTypeDropdown.click(); // Then pick option with another locator in test
	}
	
	
	
	public void enterFromDate(String fromDate) {
	    fromDateInput.clear();
	    fromDateInput.sendKeys(fromDate);
	}
	
	
	
	public void enterToDate(String toDate) {
	    toDateInput.sendKeys(Keys.CONTROL + "a");
	    toDateInput.sendKeys(Keys.DELETE);
	    toDateInput.sendKeys(toDate);
	  
	}
	

	
	public void enterComments(String comment) {
	    commentsBox.sendKeys(comment);
	}
	
	public void clickAssign() {
	    assignButton.click();
	}
	
	
	public void handlePopup() {
	    try {
	        // a short explicit wait helps if modal takes a moment to appear
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.visibilityOf(popupMessage));

	        String message = popupMessage.getText();
	        System.out.println("Popup message: " + message);

	        // click Ok to close it (you could click Cancel instead)
	        popupOkButton.click();
	    } catch (Exception e) {
	        System.out.println("No popup appeared.");
	    }
	}
	
	
	
	


}