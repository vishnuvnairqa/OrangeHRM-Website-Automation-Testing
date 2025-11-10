package pagepkg.Recruitment;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class K_MaintenancePage {
	
	

	    WebDriver driver;

	    // ---------- Element Locators ----------

	    
	    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[10]/a/span")
	    WebElement Maintenance;
	    
	    
	    @FindBy(name = "password")
	    WebElement pasInput;
	    
	    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/form/div[4]/button[2]")
	    WebElement confirm;
	    
	    
	  //*[@id="app"]/div[1]/div[1]/header/div[2]/nav/ul/li/ul/div[2]/li/a
	
	    
	    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a")
	    WebElement accessRecord;
	    
	    
	    // Past Employee input (autocomplete)
	    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/div[1]/div/div/div/div[2]/div/div/input")
	    WebElement EmployeeInput;

	    // Search button
	    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/div[2]/button")
	    WebElement searchButton;

	    
	    
	    
	    

	    @FindBy(name = "firstName")
	    private WebElement firstNameInput;

	    @FindBy(name = "middleName")
	    private WebElement middleNameInput;

	    @FindBy(name = "lastName")
	    private WebElement lastNameInput;

	    @FindBy(xpath = "//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	    private WebElement employeeIdInput;
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    // ---------- Constructor ----------
	    public  K_MaintenancePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void bypass(String pas) throws InterruptedException {
	    	Maintenance.click();
	    	Thread.sleep(2000);
	    	
	        pasInput.sendKeys(pas);
	        Thread.sleep(2000);
	        confirm.click();
	       
	    }
	    
	    
	    
	    // ---------- Action Methods ----------

	    public void enterEmployee(String name) throws InterruptedException {
	    	
	    	accessRecord.click();
	    	Thread.sleep(2000);
	        EmployeeInput.clear();
	       
	        EmployeeInput.sendKeys(name);
	        Thread.sleep(2000);
			EmployeeInput.sendKeys(Keys.ARROW_DOWN);
			EmployeeInput.sendKeys(Keys.ENTER);
			 Thread.sleep(2000);
			 searchButton.click();
	       
	    }

	    public String getFirstName() {
	        return firstNameInput.getAttribute("value");
	    }

	    public String getMiddleName() {
	        return middleNameInput.getAttribute("value");
	    }

	    public String getLastName() {
	        return lastNameInput.getAttribute("value");
	    }

	    public String getEmployeeId() {
	        return employeeIdInput.getAttribute("value");
	    }

	    
	    // --- Convenience combined fetch ---
	    public void printEmployeeDetails() throws InterruptedException {
	       Thread.sleep(2000);
	        System.out.println("Employee Details:");
	        System.out.println("First Name:  " + getFirstName());
	        System.out.println("Middle Name: " + getMiddleName());
	        System.out.println("Last Name:   " + getLastName());
	        System.out.println("Employee ID: " + getEmployeeId());
	    }
	

	



	
	
	
	
	

}