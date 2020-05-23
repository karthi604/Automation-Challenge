package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentOrderPage {
	WebDriver driver;
	   
    
	 @FindBy(xpath="//*[@id='header_logo']/a/img")
		public
	    WebElement logo;
	 String reference;
	 
	 @FindBy(xpath="//*[@id='center_column']/p/a")
	  WebElement backToOrders;
	 @FindBy(xpath="//*[@id=\"center_column\"]/div/span")
	  WebElement referenceId;
	 @FindBy(xpath="//*[@id='center_column']/div/span")
	  WebElement price;
	
	 
	 public PaymentOrderPage(WebDriver driver){
		 this.driver = driver;
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
	 }
	 
	 public void backToOrders() {
		 backToOrders.click();
	 }
	 public String getReferenceId() {
		 
		 List  <WebElement> reference1=driver.findElements(By.xpath("//*[@id=\"center_column\"]/div"));
			for(WebElement ref: reference1){
				if(ref.getText().toLowerCase().contains("reference")) {
					WebElement temp1 = ref;
					reference=temp1.getText();
					System.out.println(reference);
					break;
				}
			}
		 return reference;
	 }
	 public String getPrice() {
		 return price.getText();
	 }
	 public String getTitle() {
			return driver.getTitle();
	 }
	
}
