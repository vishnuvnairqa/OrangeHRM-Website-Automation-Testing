package pagepkg.A_login;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class C_SearchPage {

	
	WebDriver driver;
	
	
	@FindBy (xpath= "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/input")
	
	WebElement search;
		
	 @FindBy(xpath = "//span[text()='PIM']")
	    WebElement searchResult;



	
	public C_SearchPage(WebDriver driver) {
	 
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}



	public void search(String srh) throws InterruptedException {
		  
		search.click();
		   search.sendKeys(Keys.CONTROL + "a");  // select all text in the field
		    search.sendKeys(Keys.DELETE);         // delete it
		
		search.sendKeys(srh);
	

		
		
	}
	
	   public String getSearchResultText() {
	        return searchResult.getText();
	    }
	
	

	   
		public void clear() {
			search.clear();
			
			  
		}
	   
	   
}
