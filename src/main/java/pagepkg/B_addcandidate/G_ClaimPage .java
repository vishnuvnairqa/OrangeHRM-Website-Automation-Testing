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

public class G_ClaimPage {
	
	
	//Assign Claim >>>> create >>> addexpense >>> save >> submite >> claom >> searcjemopname>> fetrchdetail>> 
	
	
	WebDriver driver;
	
	

	//pim locate
					@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[11]/a")
					   private WebElement clame;



					
					
	    // ==== Page Elements ====
					
	 
	
    // Inputs (autocomplete inputs are plain input elements in snippet)
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
    private WebElement employeeInput;


    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div[2]/form/div[3]/button[2]")
    private WebElement searchButton;
    
//message under table: (1) Record Found
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/div[2]/div/span")
    private WebElement recordFoundMessage;

// each row cell inside the body
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[1]/div")
    private List<WebElement> tableCells;	    
    
    
    
    
    
    
    
    
    
    
    
    



	public G_ClaimPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver,this);
	}


	public void clameclick() throws InterruptedException {
		 Thread.sleep(2000);
	
			clame.click();
			
		}


	
	
	
	
	
	
	public void searchbyName(String emplynam ) throws InterruptedException {
	
	
			
		 Thread.sleep(2000);
		//drop.click();
		
		
		employeeInput.sendKeys(emplynam);
		 Thread.sleep(2000);
		employeeInput.sendKeys(Keys.ARROW_DOWN);
		employeeInput.sendKeys(Keys.ENTER);
        searchButton.click();

		
		
		
	}






	// fetch record found text + each cell's data
	public void printSearchResultDetails() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(recordFoundMessage));

	        // print record info
	        System.out.println("Record Info: " + recordFoundMessage.getText());

	        // print each cell value
	        System.out.println("Row Data:");
	        for (WebElement cell : tableCells) {
	            System.out.print(cell.getText().trim() + " | ");
	        }
	        System.out.println();

	    } catch (Exception e) {
	        System.out.println("No record message found or table empty.");
	    }
	}

	
	public String getFetchedName() {
	    try {
	        WebElement nameCell = driver.findElement(
	            By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/div[3]/div/div[2]/div/div/div[2]/div")
	        );
	        return nameCell.getText().trim();
	    } catch (Exception e) {
	        return "";
	    }
	}
	
	
	

}