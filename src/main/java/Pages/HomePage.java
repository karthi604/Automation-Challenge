package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(className="login")
    WebElement signIn;
    
    @FindBy(xpath="//*[@id='header_logo']/a/img")
	public
    WebElement logo;
    @FindBy(xpath="//*[@id='block_top_menu']/ul/li[2]/a")
	WebElement dresses;
	
    
   
    public HomePage(WebDriver driver) {
    	this.driver = driver;
        //this.logo = logo;
        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
      
    }
    
    
    //Click on SignIn button
    
    public void clickSignIn(){

            signIn.click();

    }  
    
    public void clickDresses() {
    	dresses.click();
    }

    //Get the title of Home Page

    public String getTitle(){
    	
     
     return    driver.getTitle();

    }


    
    
}
