package pagepkg.A_login;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A_loginpage {
	
	
	WebDriver driver;
	
	
@FindBy (xpath= "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")

WebElement username;


@FindBy (xpath= "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")

WebElement password;


@FindBy (xpath= "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")

WebElement login;




@FindBy (xpath= "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p")

WebElement userdropdown;


@FindBy (xpath= "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a")

WebElement logout;








public A_loginpage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	

}







public void input(String usname, String pass) {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
	username.sendKeys(usname);
	password.sendKeys(pass);
	
	
}




public void click() {
	login.click();
	
	
}


public void logout() throws InterruptedException {
	Thread.sleep(2000);
	userdropdown.click();
	logout.click();
	
	
}	
	



public void takeScreenshot(String fileName) {
    try {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File dest = new File("test-output/screenshots/" + fileName + ".png");
        dest.getParentFile().mkdirs();   // create directory if missing

        FileHandler.copy(src, dest);
        System.out.println("Saved screenshot: " + dest.getAbsolutePath());
    } catch (Exception e) {
        e.printStackTrace();
    }
}

	

}