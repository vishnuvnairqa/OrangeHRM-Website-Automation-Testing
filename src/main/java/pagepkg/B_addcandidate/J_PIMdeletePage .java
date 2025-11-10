package pagepkg.B_addcandidate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class J_PIMdeletePage {
	
	WebDriver driver;
	
	
	// ===== Locators =====
    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement pimMenu;

    @FindBy(xpath = "//a[normalize-space()='Employee List' or text()='Employee List']")
    private WebElement employeeListLink;

    @FindBy(tagName = "input")
    private List<WebElement> inputs;

    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;

    // delete icon inside a row (first matching trash icon)
    @FindBy(xpath = "//i[contains(@class,'bi-trash')]")
    private WebElement deleteIcon;

    // confirm delete button on modal
    @FindBy(xpath = "//button[contains(@class,'oxd-button--label-danger')]")
    private WebElement confirmDeleteButton;

    // message spans (first span used for messages like "No Records Found" or others)
    @FindBy(xpath = "(//span[@class='oxd-text oxd-text--span'])[1]")
    private WebElement firstMessageSpan;
	
	
	
	
	
	
	public void deleteEmployee() throws InterruptedException
	{
		

		//find PIM Menu and click on PIM Menu
		driver.findElement(By.xpath("//span[text()='PIM']")).click();

		//Select Employee List
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();

		//enter employee name
		driver.findElements(By.tagName("input")).get(1).sendKeys("Odis");

		//driver.findElement(By.tagName("input")).get(1).sendKeys("Nesta");


		//Click the search button.
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();


		Thread.sleep(3000);
		///////////////////Delete/////////////////////////

		//click on delete icon of the record
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash']")).click();


		//click on yes, delete messaage button
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();

		//check for message "No Record Found"
		String msg = driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]")).getText();

		Assert.assertEquals(msg, "No Records Found");

		Thread.sleep(5000);
	

	}
	
	
	
	
	
	
	
	
	
	

}
