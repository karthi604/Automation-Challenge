package Pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {
	WebDriver driver;
	   
    
	 @FindBy(xpath="//*[@id='header_logo']/a/img")
		public
	    WebElement logo;
	 @FindBy(xpath="//*[@id='address_invoice']")
	 public List<WebElement> billingAddress;
	 @FindBy(xpath="//*[@id='address_delivery']")
	 public List <WebElement> deliveryAddress;
	 @FindBy(xpath="//*[@id='center_column']/form/p/button")
	 public WebElement proceedToCheckout;
	 Stream<String> delAddress;
	 Stream<String> bilAddress;
	 
	 
	 public AddressPage(WebDriver driver){
		 this.driver = driver;
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
	 }
	 public  void getBillingAddress() {
		 
		 List<String> address1 = new ArrayList<String>();
		 for(WebElement e: billingAddress){
			 address1.add(e.getText());
		 }
		 bilAddress=  address1.stream().skip(1);
		
		 
	 }
	 public  void getDeliveryAddress() {
		 
		 List<String> address = new ArrayList<String>();
		 for(WebElement e: deliveryAddress){
			 address.add(e.getText());
		 }
		 delAddress=  address.stream().skip(1);
		
		 
	 }
	 
	 public boolean compareAddress() {
		 return (Arrays.equals(bilAddress.toArray(),delAddress.toArray()));
	 }
	 public void clickProceed() {
		 proceedToCheckout.click();
	 }
	 public String getTitle() {
			
			return driver.getTitle();
		}
}
