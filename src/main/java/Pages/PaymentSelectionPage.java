package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentSelectionPage {
	WebDriver driver;
	   
    
	 @FindBy(xpath="//*[@id='header_logo']/a/img")
		public
	    WebElement logo;
	 
	
	 @FindBy(className="bankwire")
	  WebElement bankWire;
	 @FindBy(xpath="//*[@id=\"center_column\"]/form/div/h3")
	 WebElement paymentType;
	 @FindBy(xpath="//*[@id='cart_navigation']/button")
	 WebElement confirmOrder;
	//*[@id="center_column"]/form/div/p[1]
	
	 
	 public PaymentSelectionPage(WebDriver driver){
		 this.driver = driver;
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
	 }
	 
	 public void selectPayment() {
		 bankWire.click();
	 }
	 public void confirmOrder() {
		 confirmOrder.click();
	 }
	 public String getPageHeading() {
		 return paymentType.getText();
	 }
	 public String getTitle() {
			return driver.getTitle();
		}
}
