package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShippingPage {
	WebDriver driver;
	   
    
	 @FindBy(xpath="//*[@id='header_logo']/a/img")
		public
	    WebElement logo;
	 @FindBy(css="#order > div.fancybox-overlay.fancybox-overlay-fixed > div > div")
	 public WebElement error;
	 @FindBy(css="#order > div.fancybox-overlay.fancybox-overlay-fixed > div > div > a")
	 WebElement closeError;
	 
	 @FindBy(xpath="//*[@id='form']/div")
	 public WebElement layOver;
	
	 
	 @FindBy(xpath="//*[@id='form']/p/button")
	  public WebElement proceedToCheckout;
	 
	 @FindBy(id="cgv")
	  public WebElement tcCheckBox;
	 
	 public ShippingPage(WebDriver driver){
		 this.driver = driver;
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
	        
	 }
	 public boolean checkBoxCheck() {
		 return tcCheckBox.isSelected();
	 }
	 public void checkTC() {
		 
		 tcCheckBox.click();
		 
		 
	 }
	 public void clickProceed() {
		 proceedToCheckout.click();
	 }
	 public String getAlertMsg() {
		 		 
		 return error.getText();	  
	 }
	 
	 public void dismissAlert() {
		 closeError.click();
		 	 
	 }
	 public String getTitle() {
			return driver.getTitle();
		}
	 
}
