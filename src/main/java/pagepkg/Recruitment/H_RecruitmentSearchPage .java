package pagepkg.Recruitment;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class H_RecruitmentSearchPage {

	

	    WebDriver driver;

	    // ***** Locators *****

	    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[5]/a/span")
	    WebElement Recruitment;
	    
	    
	    // Candidate name input
	    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/div/div[1]/div/div[2]/div/div/input")
	    WebElement candidateNameInput;

	    // Search button
	    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[4]/button[2]")
	    WebElement searchButton;

	    // Record found text e.g., (1) Record Found
	    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div")
	    WebElement recordFoundText;

	    // Table row cells: Vacancy | Candidate | Hiring Manager | Date | Status
//	    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div")
//	    List<WebElement> resultRowCells;

	  
	    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[3]/div")
	    List<WebElement> resultRowCells;
	    
	    
	    
	    
	    
	    public H_RecruitmentSearchPage (WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    
	    public void recruitmentclick() throws InterruptedException {
	    	
	    	
	    	Recruitment.click();
	    
			
		}

	    
	    // ***** Page Actions *****

	    public void searchCandidate(String candidateName) throws InterruptedException {
	
	        candidateNameInput.clear();
	        candidateNameInput.sendKeys(candidateName);
	        Thread.sleep(3000);
	        candidateNameInput.sendKeys(Keys.ARROW_DOWN);
	        candidateNameInput.sendKeys(Keys.ENTER);
	        
	        searchButton.click();
	        
	        Thread.sleep(2000);
	    }

	    public String getRecordFoundText() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.visibilityOf(recordFoundText));
	            return recordFoundText.getText().trim();
	        } catch (Exception e) {
	            return "No records found!";
	        }
	    }

	    
	    
	    public List<String> getResultRowData() {
	        List<String> cellData = new ArrayList<>();
	        for (WebElement cell : resultRowCells) {
	            cellData.add(cell.getText().trim());
	        }
	        return cellData;
	    }
	
	
	
	
	
}