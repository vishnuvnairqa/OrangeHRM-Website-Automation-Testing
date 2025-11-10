package pagepkg.B_addcandidate;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class G_CreateClaimPage {

	WebDriver driver;
	
	

	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[11]/a")
	   private WebElement clame;


	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/div[1]/button")
			   private WebElement AssignClame;
		

	


	    // ---------- Locators ----------
	    @FindBy(xpath = "//h6[normalize-space()='Create Claim Request']")
	    private WebElement header;

	    @FindBy(xpath = "//label[text()='Employee Name']/following::input[@placeholder='Type for hints...']")
	    private WebElement employeeNameInput;

	    @FindBy(xpath = "//label[text()='Event']/following::div[contains(@class,'oxd-select-text-input')][1]")
	    private WebElement eventDropdown;

	    @FindBy(xpath = "//label[text()='Currency']/following::div[contains(@class,'oxd-select-text-input')][1]")
	    private WebElement currencyDropdown;

	    @FindBy(xpath = "//label[text()='Remarks']/following::textarea")
	    private WebElement remarksTextarea;


	    @FindBy(xpath = "//button[normalize-space()='Create']")
	    private WebElement createButton;

	    
	    
	    
	  

	    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div/button")
	    private WebElement Expenses ;
	    
	    
	    
	    
	    @FindBy(xpath = "//p[normalize-space()='Add Expense']")
	    private WebElement popupTitle;
	    
	    @FindBy(xpath = "//label[text()='Expense Type']/following::div[contains(@class,'oxd-select-text-input')][1]")
	    private WebElement expenseTypeDropdown;

	    @FindBy(xpath = "//label[text()='Date']/following::input[@placeholder='yyyy-dd-mm']")
	    private WebElement dateInput;

	    @FindBy(xpath = "//label[text()='Amount']/following::input[contains(@class,'oxd-input')]")
	    private WebElement amountInput;

	    @FindBy(xpath = "//label[text()='Note']/following::textarea")
	    private WebElement noteTextarea;

	

	    @FindBy(xpath = "//button[normalize-space()='Save']")
	    private WebElement saveButton;
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

		public G_CreateClaimPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver,this);
		}
	
		
		
		
		public void clameclick() throws InterruptedException {
			 Thread.sleep(2000);
		
				clame.click();
				
			}
		public void AssignClick() throws InterruptedException {
			 Thread.sleep(2000);
		
			 AssignClame.click();
				
			}



	    // ---------- Wait helper ----------
	    private WebDriverWait waitFor(int sec) {
	        return new WebDriverWait(driver, Duration.ofSeconds(sec));
	    }

	    private void waitForVisible(WebElement ele) {
	        waitFor(10).until(ExpectedConditions.visibilityOf(ele));
	    }

	    // ---------- Dropdown helper ----------
	    private void selectFromDropdown(WebElement dropdown, String visibleText) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", dropdown);
	        dropdown.click();

	        // wait until the overlay options appear
	        waitFor(10).until(
	                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option']//span"))
	        );

	        List<WebElement> options =
	                driver.findElements(By.xpath("//div[@role='option']//span"));
	        for (WebElement opt : options) {
	            if (opt.getText().trim().equalsIgnoreCase(visibleText.trim())) {
	                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", opt);
	                opt.click();
	                return;
	            }
	        }
	        System.out.println("Option not found in dropdown: " + visibleText);
	    }


	    // ---------- Page actions ----------
	    public void waitForForm() { waitForVisible(header); }

	    public void enterEmployeeName(String empName) throws InterruptedException {
	        employeeNameInput.sendKeys(empName);
	        Thread.sleep(2000);
	        employeeNameInput.sendKeys(Keys.ARROW_DOWN);
	        employeeNameInput.sendKeys(Keys.ENTER);
	    }

	    public void selectEvent(String event) { selectFromDropdown(eventDropdown, event); }

	    public void selectCurrency(String currency) { selectFromDropdown(currencyDropdown, currency); }

	    public void enterRemarks(String text) {
	        remarksTextarea.clear();
	        remarksTextarea.sendKeys(text);
	    }


	    public void clickCreate() { createButton.click(); }

	    // ---------- Combined workflow ----------
	    public void createClaim(String empName, String event, String currency, String remarks)
	            throws InterruptedException {
	        waitForForm();
	        enterEmployeeName(empName);
	        selectEvent(event);
	        selectCurrency(currency);
	        enterRemarks(remarks);
	        clickCreate();
	    }
	
	
	    public void waitForExpenses() { waitForVisible(Expenses); }
	    
	    public void clickExpenses() { waitForExpenses(); Expenses.click(); }
	
	
	    
	    
	    
	    
	    
	    
	    
	    
	    
	
	    private WebDriverWait waitForin(int sec) {
	        return new WebDriverWait(driver, Duration.ofSeconds(sec));
	    }

	    public void waitForPopupVisible() {
	        waitFor(10).until(ExpectedConditions.visibilityOf(popupTitle));
	    }

	    // ---------- Dropdown Handler ----------
	    private void selectFromDropdownin(WebElement dropdown, String value) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
	        dropdown.click();

	        waitForin(10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='option']//span")));

	        List<WebElement> options = driver.findElements(By.xpath("//div[@role='option']//span"));
	        for (WebElement opt : options) {
	            if (opt.getText().trim().equalsIgnoreCase(value.trim())) {
	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", opt);
	                opt.click();
	                return;
	            }
	        }
	        System.out.println("Expense Type option not found: " + value);
	    }

	    // ---------- Actions ----------
	    public void selectExpenseType(String type) { selectFromDropdownin(expenseTypeDropdown, type); }

	    public void enterDate(String date) {
	        dateInput.clear();
	        dateInput.sendKeys(date);
	        dateInput.sendKeys(Keys.TAB);
	    }

	    public void enterAmount(String amount) {
	        amountInput.clear();
	        amountInput.sendKeys(amount);
	    }

	    public void enterNote(String note) {
	        noteTextarea.clear();
	        noteTextarea.sendKeys(note);
	    }

	 

	    public void clickSave() { saveButton.click(); }

	   

	    // ---------- Combined workflow ----------
	    public void addExpense(String type, String date, String amount, String note)
	            throws InterruptedException {

	        waitForPopupVisible();
	        selectExpenseType(type);
	        enterDate(date);
	        enterAmount(amount);
	        enterNote(note);
	        clickSave();
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}