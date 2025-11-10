package pagepkg.A_login;



import java.time.Duration;
import java.util.ArrayList;
import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class B_DashboardPage  {


	    WebDriver driver;

	    // Define elements
	    @FindBy(xpath = "//h6[text()='Dashboard']") 
	    WebElement dashboardHeader;
	 
	    @FindBy(css = ".orangehrm-dashboard-widget-name p.oxd-text--p")
	    List<WebElement> widgetHeaders;
	   

	    
	    
	    
	    public B_DashboardPage(WebDriver driver) {
	   	 this.driver = driver;
	        PageFactory.initElements(driver, this);
	        
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
	                By.cssSelector("div.orangehrm-dashboard-widget-name p.oxd-text--p")));
		}

	    
	   

	
	    public String getHeader() {
	        return dashboardHeader.getText();
	    }



	    public List<String> getAllWidgetTitles() {
	        List<String> titles = new ArrayList<>();
	        for (WebElement widget : widgetHeaders) {
	            titles.add(widget.getText().trim());
	        }
	        return titles;
	    }


	    
	    
	}
	
    
    
    
    
    
    
    
    
    
    
    
    

	
	
	
	
	
	
	

