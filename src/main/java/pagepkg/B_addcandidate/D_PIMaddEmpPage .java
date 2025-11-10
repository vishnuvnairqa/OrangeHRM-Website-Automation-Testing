package pagepkg.B_addcandidate;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class D_PIMaddEmpPage {
	
	WebDriver driver;
	
	
	
	@FindBy(css = "a.oxd-main-menu-item[href*='viewPimModule']")
	   private WebElement pim;
	  
	  @FindBy(xpath = "/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[3]/a")
	   private WebElement addemp;
	

	
	  
	  
   @FindBy(name = "firstName")
   private WebElement firstNameInput;

   @FindBy(name = "middleName")
   private WebElement middleNameInput;

   @FindBy(name = "lastName")
   private WebElement lastNameInput;

   @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
   private WebElement employeeIdInput;
	

	@FindBy (xpath= "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
	WebElement save;
		

	
	
	
	
	
	

	public D_PIMaddEmpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}




	public void addemp() throws InterruptedException {
		 Thread.sleep(2000);
		pim.click();
		 Thread.sleep(2000);
		addemp.click();	
		  Thread.sleep(2000);
			
		}

	


	public void input(String firstname , String middlename , String lastname , String employidd) throws InterruptedException {
		
		
		firstNameInput.sendKeys(firstname);
		middleNameInput.sendKeys(middlename);
		lastNameInput.sendKeys(lastname);
		Thread.sleep(2000);
		employeeIdInput.sendKeys(Keys.CONTROL+"a");
		employeeIdInput.sendKeys(Keys.DELETE);
		employeeIdInput.sendKeys(employidd);
		
		
		
		
		
		
	}
	

	public void save() throws InterruptedException {
		
	save.click();	
	 Thread.sleep(2000);
		pim.click();
		
	}
	
	
//	  public void waitForPageReady() {
//	        wait.until(ExpectedConditions.visibilityOf(headerTitle));
//	    }
//	
	
	
	
	
	

	
	
	
	
	
	

}