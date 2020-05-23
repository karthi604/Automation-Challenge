package Pages;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Others.*;

public class OrderHistoryPage {
	//*[@id="order-list"]/tbody/tr[1]/td[1]/a
	
	WebDriver driver;
	   
    
	 @FindBy(xpath="//*[@id='header_logo']/a/img")
		public
	    WebElement logo;
	 
	 @FindBy(xpath="//*[@id='cart_navigation']/button")
	  WebElement proceedToCheckout;
	 @FindBy(xpath="//*[@id='center_column']/p/a")
	  WebElement backToOrders;
	 @FindBy(xpath="//*[@id=\"center_column\"]/div")
	 WebElement referenceId;
	 @FindBy(xpath="//*[@id='center_column']/div/span")
	  WebElement price;
	 @FindBy(xpath="//*[@id='order-list']/tbody/tr[1]/td[1]/span")
	  WebElement plus;
	 @FindBy(xpath="//*[@id='order-list']/tbody/tr[2]/td/div/div[1]/div[2]")
	  WebElement paymentMethod;
	 @FindBy(xpath="//*[@id='order-list']/tbody/tr/td[1]")
	  List <WebElement> tableRow;
	 @FindBy(xpath="//*[@id=\"order-list\"]/tbody/tr/td")
	  List <WebElement> tableCol;
	//*[@id="order-list"]/tbody/tr/td[1]
	 //List row= new List(tableRow);
	
	String ref; 
	String refer;
	String date;
	String pri;
	WebElement temp;
	 
	 public OrderHistoryPage(WebDriver driver){
		 this.driver = driver;
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);
	 }
	 
	 
	
	 public String getReferenceId(String ref) {
		 return referenceId.getText();
	 }
	 public String getPrice() {
		 return price.getText();
	 }
	 public String getPaymentMethod() {
		 return paymentMethod.getText();
	 }
	 public void clickPlus() {
		 plus.click();
	 }
	 public void takeScreenshot() throws IOException {
		 Screenshot s= new Screenshot();
		 s.snip(driver);
	 }
	 
	 public String getTitle() {
			// TODO Auto-generated method stub
			return driver.getTitle();
	 }
	 public boolean matchReferenceId(String refere, String price) {
		 		 
		 
		 int i=0;
		 for(WebElement e: tableCol){
			if(refere.contains(e.getText())) {
				temp=e;
				break;
			}
	
		 }
		 i=tableCol.indexOf(temp);
		 i--;
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/YYYY");
		 LocalDateTime today = LocalDateTime.now().minusHours(10);
		 
		  
		 String tod= formatter.format(today);
		 
		 if(i<=1) {
		 	 refer=driver.findElement(By.xpath("//*[@id='order-list']/tbody/tr/td[1]/a")).getText();		
			 date=driver.findElement(By.xpath("//*[@id='order-list']/tbody/tr/td[2]")).getText();
			 pri=driver.findElement(By.xpath("//*[@id='order-list']/tbody/tr/td[3]/span")).getText();	
		 }
		 else {
			  refer=driver.findElement(By.xpath("//*[@id='order-list']/tbody/tr["+i+"]/td[1]/a")).getText();		
				 date=driver.findElement(By.xpath("//*[@id='order-list']/tbody/tr["+i+"]/td[2]")).getText();
				 pri=driver.findElement(By.xpath("//*[@id='order-list']/tbody/tr["+i+"]/td[3]/span")).getText();	
		 }
		 
		 System.out.println("reference: " + refer);
					
			if ((refere.contains(refer)) && ((pri.equalsIgnoreCase(price))&&(tod.contains(date)))){
				return true;
			}
			else {
				return false;
			}
		 
		 
		 
	 }
	
}
