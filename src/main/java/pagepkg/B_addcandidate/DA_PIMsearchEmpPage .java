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


public class DA_PIMsearchEmpPage {
	
	WebDriver driver;
	
	

//pim locate
				@FindBy(css = "a.oxd-main-menu-item[href*='viewPimModule']")
				   private WebElement pim;

	
	
	
//search by name 	    
			 
			
			    // Inputs (autocomplete inputs are plain input elements in snippet)
			    @FindBy(xpath = "//label[normalize-space()='Employee Name']/following::input[1]")
			    private WebElement employeeNameInput;

			    @FindBy(xpath = "//label[normalize-space()='Employee Id']/following::input[1]")
			    private WebElement employIdInput;

			

			   

			    @FindBy(xpath = "//button[normalize-space()='Search']")
			    private WebElement searchButton;
			
			
	
	

			    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span']")
			    List<WebElement> recordMessages;
			
			    
			    
//search by id
			
			    @FindBy(xpath = "//div[@role='row']")
				private List<WebElement> rows;
				
	
			    
// message under table: (1) Record Found
			    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div")
			    private WebElement recordFoundMessage;

 // each row cell inside the body
			    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div")
			    private List<WebElement> tableCells;	    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
	
	
	
				public DA_PIMsearchEmpPage(WebDriver driver) {
					this.driver = driver;
					PageFactory.initElements( driver,this);
				}


				public void pimclick() throws InterruptedException {
						
					 Thread.sleep(2000);
						pim.click();
						
					}
	
				
				public void searchbyName(String emplynam ) throws InterruptedException {
				
				
						
					 Thread.sleep(2000);
					//drop.click();
					
					
					employeeNameInput.sendKeys(emplynam);
					 Thread.sleep(2000);
					employeeNameInput.sendKeys(Keys.ARROW_DOWN);
					employeeNameInput.sendKeys(Keys.ENTER);
			        searchButton.click();
		
					
					
					
				}
	
	

				
				public void searchbyID(String emplyid ) throws InterruptedException {
				
				
						
					 Thread.sleep(2000);
					//drop.click();
					
					 employIdInput.sendKeys(emplyid);
					 Thread.sleep(2000);
					employeeNameInput.sendKeys(Keys.ARROW_DOWN);
					employeeNameInput.sendKeys(Keys.ENTER);
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
				            System.out.println(cell.getText().trim() + " | ");
				        }
				        System.out.println();

				    } catch (Exception e) {
				        System.out.println("No record message found or table empty.");
				    }
				}
	
	
	
	
				// inside DA_PIMSearchEmpPage
				public String getFetchedName() {
				    try {
				        WebElement nameCell = driver.findElement(
				            By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[3]/div")
				        );
				        return nameCell.getText().trim();
				    } catch (Exception e) {
				        return "";
				    }
				}

				public String getFetchedId() {
				    try {
				        WebElement idCell = driver.findElement(
				            By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div")
				        );
				        return idCell.getText().trim();
				    } catch (Exception e) {
				        return "";
				    }
				}
	
	
	
//	
//	public void searchEmployeeNyName() throws InterruptedException
//	{
//		
//
//		
//
//		//    //span[@class='oxd-text oxd-text--span']
//		Thread.sleep(5000)	;
//		List<WebElement> element=	driver.findElements(By.xpath("//span[@class='oxd-text oxd-text--span']"));
//
//		String expected_message = "Record Found";
//		String message_actual = element.get(0).getText();
//		System.out.println(message_actual);
//
//	
//
//		Assert.assertTrue(message_actual.contains(expected_message));
//
//
//
//		/*for (int i = 0 ; i<element.size(); i++)
//	{
//		 System.out.println("At index "+ i + "text is :" + element.get(i).getText());  
//	}*/
//
//		//	•	Verify that the record is found.
//		//	•	Logout the user.
//
//	}
//
//	@Test(priority =5, enabled=false)
//	public void searchEmpeById() throws InterruptedException
//	{
//
//		String empId = "0372";
//		String message_actual ="";
//	;
//
//
//	
//
//		Thread.sleep(2000)	;
//
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("window.scrollBy(0," + 500 + ")");
//
//		Thread.sleep(2000)	;
//
//
//		List<WebElement> rows = driver.findElements(By.xpath("(//div[@role='row'])"));
//
//
//		if(rows.size()>1)
//		{
//			message_actual = driver.findElement(By.xpath("((//div[@role='row'])[2]/div[@role='cell'])[2]")).getText();
//
//		}
//
//		
//		Assert.assertEquals(empId, message_actual);
//
//	}

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	

}