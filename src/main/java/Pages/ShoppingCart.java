package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {
	 WebDriver driver;
	   
	    
	 @FindBy(xpath="//*[@id='header_logo']/a/img")
		public
	    WebElement logo;
	 @FindBy(className="address last_item alternate_item box")
	  WebElement billingAddress;
	 @FindBy(className="address first_item item box")
	  WebElement deliveryAddress;
	 @FindBy(xpath="//*[@id='center_column']/p[2]/a[1]")
	  WebElement proceedToCheckout;
	 
	 public ShoppingCart(WebDriver driver){
		 this.driver = driver;
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
	 }
	 public String getBillingAddress() {
		 return billingAddress.getText();
	 }
	 public String getDeliveryAddress() {
		 return deliveryAddress.getText();
	 }
	 public void clickProceed() {
		 proceedToCheckout.click();
	 }
	public String getTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
}
