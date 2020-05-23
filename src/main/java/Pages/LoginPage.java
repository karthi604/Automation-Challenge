package Pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    WebDriver driver;
    
    @FindBy(id="email_create")
    WebElement email;
    
    @FindBy(id="SubmitCreate")
    WebElement create;
    
    @FindBy(xpath="//*[@id='header_logo']/a/img")
	public
    WebElement logo;
    
    public LoginPage(WebDriver driver) {
    	this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
    }
    
    public String getTitle(){
    	
        
        return    driver.getTitle();

       }
    public void createAccount() {
    	
    	Random randomGenerator = new Random();  
    	int randomInt = randomGenerator.nextInt(1000000);  
    	email.sendKeys("username"+ randomInt +"@gmail.com");
    	create.click();
    }
}
