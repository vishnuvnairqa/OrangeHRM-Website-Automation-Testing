package pagepkg.Recruitment;

	
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.*;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import java.time.Duration;
import java.util.List;

	public class H_RecruitmentPage {

	    WebDriver driver;

	    // ***** LOCATORS *****

	    
	    
	    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a/span")
	    WebElement Recruitment;
	    
	    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
	    WebElement add;
	  
	    
	    
	    
	    // Section heading
	    @FindBy(xpath = "//h6[text()='Add Candidate']")
	    WebElement pageTitle;

	    // Full name fields
	    @FindBy(name = "firstName")
	    WebElement firstNameInput;

	    @FindBy(name = "middleName")
	    WebElement middleNameInput;

	    @FindBy(name = "lastName")
	    WebElement lastNameInput;

	    // Vacancy dropdown
	    @FindBy(xpath = "//label[text()='Vacancy']/ancestor::div[contains(@class,'oxd-input-group')]//div[@role='textbox']")
	    WebElement vacancyDropdown;

	    // Email and Contact Number
	    @FindBy(xpath = "//label[text()='Email']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	    WebElement emailInput;

	    @FindBy(xpath = "//label[text()='Contact Number']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	    WebElement contactNumberInput;

	    // Resume upload
	    @FindBy(xpath = "//input[@type='file']")
	    WebElement resumeUploadInput;

	    // Keywords
	    @FindBy(xpath = "//label[text()='Keywords']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	    WebElement keywordsInput;

	    // Date of Application
	    @FindBy(xpath = "//label[text()='Date of Application']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	    WebElement dateOfApplicationInput;

	    // Notes
	    @FindBy(xpath = "//label[text()='Notes']/ancestor::div[contains(@class,'oxd-input-group')]//textarea")
	    WebElement notesTextarea;

	    // Consent checkbox
	    @FindBy(xpath = "//label[text()='Consent to keep data']/ancestor::div[contains(@class,'oxd-input-group')]//input[@type='checkbox']")
	    WebElement consentCheckbox;

	    // Buttons
	    @FindBy(xpath = "//button[normalize-space()='Save']")
	    WebElement saveButton;

	    @FindBy(xpath = "//button[normalize-space()='Cancel']")
	    WebElement cancelButton;


	    
	    
	    
	    
	    
	    
	    @FindBy(xpath = "//label[text()='Candidate Name']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	    WebElement candidateNameInput;

	    // Search button
	    @FindBy(xpath = "//button[normalize-space()='Search']")
	    WebElement searchButton;

	    // Record found text e.g., (1) Record Found
	    @FindBy(xpath = "//span[contains(text(),'Record Found')]")
	    WebElement recordFoundText;

	    // Table row cells: Vacancy | Candidate | Hiring Manager | Date | Status
	    @FindBy(xpath = "//div[@class='oxd-table-body']//div[@role='row']/div[@role='cell']")
	    List<WebElement> resultRowCells;
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    // ***** CONSTRUCTOR *****
	    public H_RecruitmentPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
	    	  this.driver = driver;
		        PageFactory.initElements(driver, this);
		}


	    public void recruitmentclick() throws InterruptedException {
	    	Recruitment.click();
	    	Thread.sleep(2000);
	    	add.click();
			
		}

	    
	    
	    
	    // ***** PAGE ACTIONS *****

	    public void fillFullName(String first, String middle, String last) {
	        firstNameInput.clear();
	        firstNameInput.sendKeys(first);

	        middleNameInput.clear();
	        middleNameInput.sendKeys(middle);

	        lastNameInput.clear();
	        lastNameInput.sendKeys(last);
	    }

	    public void selectVacancy() {
	        vacancyDropdown.click();
	        // here you can add logic to select a dropdown option using keyboard or another WebElement
	    }

	    public void enterEmail(String email) {
	        emailInput.clear();
	        emailInput.sendKeys(email);
	    }

	    public void enterContactNumber(String number) {
	        contactNumberInput.clear();
	        contactNumberInput.sendKeys(number);
	    }

	    public void uploadResume(String filePath) {
	        resumeUploadInput.sendKeys(filePath);
	    }

	    public void enterKeywords(String keywords) {
	        keywordsInput.clear();
	        keywordsInput.sendKeys(keywords);
	    }

	    public void enterDateOfApplication(String date) {
	    	dateOfApplicationInput.sendKeys(Keys.CONTROL + "a");  
	    	dateOfApplicationInput.sendKeys(Keys.DELETE);  
	        dateOfApplicationInput.sendKeys(date);
	    }

	    public void enterNotes(String note) {
	        notesTextarea.clear();
	        notesTextarea.sendKeys(note);
	    }

	    public void clickConsentCheckbox() {
	        if (!consentCheckbox.isSelected()) {
	            consentCheckbox.click();
	        }
	    }

	    public void clickSave() {
	        saveButton.click();
	    }

	    public void clickCancel() {
	        cancelButton.click();
	    }


	    // ***** VERIFICATION *****

	    public String getPageTitle() {
	        return pageTitle.getText().trim();
	    }

	    public boolean isPageDisplayed() {
	        try {
	            new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(ExpectedConditions.visibilityOf(pageTitle));
	            return pageTitle.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	
	
	    
	    
	    


	
	
	
	

}