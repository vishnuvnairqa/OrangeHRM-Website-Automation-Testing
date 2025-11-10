package pagepkg.B_addcandidate;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class E_AdminPage {

	WebDriver driver;
	
	
	
	@FindBy (xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")
	WebElement admin;
	@FindBy (xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button/i")
	WebElement add;
	
	//*[@id="app"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a
	
	


    // Dropdowns (User Role / Status)
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]")
    private WebElement userRoleDropdown;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")
    private WebElement statusDropdown;

    // Autocomplete field – Employee Name
    @FindBy(xpath = "//label[text()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    private WebElement employeeNameInput;

    // Text fields
    @FindBy(xpath = "//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    private WebElement usernameInput;

    @FindBy(xpath = "//label[text()='Password']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    private WebElement passwordInput;

    @FindBy(xpath = "//label[text()='Confirm Password']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    private WebElement confirmPasswordInput;

    // Buttons
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveButton;
	
	
	
	
	
	
  //*[@id="app"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a
	
	

	@FindBy (xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input")
	WebElement usrname;
		

	 @FindBy(xpath = "//button[normalize-space()='Search']")
	    WebElement searchButton;

	    // Record found text: (1) Record Found
	 @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div")
	 private WebElement recordFoundLabel;

	 @FindBy(xpath = "//div[@class='oxd-table-body']//div[@role='row']/div[@role='cell']")
	 private List<WebElement> tableCells;

	  //div[@class='oxd-table-body']//div[@role='row']//div[@role='cell']
	 
	    
	    
	    
	  @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p")
	    private WebElement userDropdownName;
	    
	    
	    
	    
	    
	    
	    
	    public E_AdminPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    
	    
	    
	    public void adminclick() throws InterruptedException {
	    	admin.click(); // go to admin page
	        Thread.sleep(1000);
	    }
	  
	    
	    
	    
	

	    // select helpers for dropdowns (they are div-based custom selects)
	    public void selectUserRole(String role) {
	        userRoleDropdown.click();
	        WebElement option = driver.findElement(By.xpath("//div[@role='option']/span[text()='" + role + "']"));
	        option.click();
	    }
	
	    public void selectStatus(String status) {
	        statusDropdown.click();
	        WebElement option = driver.findElement(By.xpath("//div[@role='option']/span[text()='" + status + "']"));
	        option.click();
	    }

	    // Fill employee name (autocomplete)
	    public void enterEmployeeName(String empName) throws InterruptedException {
	        employeeNameInput.sendKeys(empName);
	        Thread.sleep(3000);
	        employeeNameInput.sendKeys(Keys.ARROW_DOWN);
	        employeeNameInput.sendKeys(Keys.ENTER);
	    }

	    // Fill text boxes
	    public void enterUsername(String uname) {
	        usernameInput.clear();
	        usernameInput.sendKeys(uname);
	    }

	    public void enterPassword(String pwd) {
	        passwordInput.clear();
	        passwordInput.sendKeys(pwd);
	    }

	    public void enterConfirmPassword(String cpwd) {
	        confirmPasswordInput.clear();
	        confirmPasswordInput.sendKeys(cpwd);
	    }

	    // Buttons
	    public void clickSave() {
	        saveButton.click();
	    }

	    
	    public void addclick() {
	        add.click();
	    }
	    
	  

	    // fill entire user form in one call
	    public void addUser(String role, String empName, String status,
	                        String uname, String pwd, String cpwd) throws InterruptedException {
	    	
	       selectUserRole(role);
	        enterEmployeeName(empName);
	        selectStatus(status);
	        enterUsername(uname);
	        enterPassword(pwd);
	        enterConfirmPassword(cpwd);
	        Thread.sleep(2000);
	        clickSave();
	    }
	    
	    
	    
	    
	
	    
	    
	    
	    
	    

	    // Perform search
	    public void search(String user) throws InterruptedException {
	    	
	        adminclick();
	        Thread.sleep(2000);
	       
	        usrname.sendKeys(user);
	        Thread.sleep(2000);
	        usrname.sendKeys(Keys.ARROW_DOWN);
	        usrname.sendKeys(Keys.ENTER);
	        searchButton.click();
	    }

	    // Get how many records were found (text)
	    public String getRecordFoundText() {
	        new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(ExpectedConditions.visibilityOf(recordFoundLabel));
	        return recordFoundLabel.getText();
	    }

	    public void printSearchResult() {
	        new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(ExpectedConditions.visibilityOfAllElements(tableCells));
	        for (WebElement cell : tableCells) {
	            System.out.print(cell.getText() + " | ");
	        }
	        System.out.println();
	    }



	    public String getDisplayedUserName() {
	        new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.visibilityOf(userDropdownName));
	        return userDropdownName.getText().trim();
	    }







	
}