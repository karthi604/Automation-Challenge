package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dresses {
	 WebDriver driver;
	   
	   	    
	 @FindBy(xpath="//*[@id='header_logo']/a/img")
		public
	    WebElement logo;
	    @FindBy(xpath="//*[@id='center_column']/ul/li[1]/div")
	    WebElement product1;
	    @FindBy(xpath="/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]")
	   // /html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img
	  //*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span
	    public WebElement addToCart;	    
	    @FindBy(xpath="//*[@id='center_column']/ul/li[1]/div/div[2]/div[1]/span")
	    public WebElement price;
	    
	    @FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
	    public
		WebElement proceedToCheckout;
	    @FindBy(xpath="//*[@id='layer_cart']/div[1]")
	    public
		WebElement popUp;
	    @FindBy(css="body")
	    WebElement body;
	    
	    
	    public Dresses(WebDriver driver) {
	    	this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);
	        
	    }
	    
	    public String getTitle(){
	    	
	        	
	        return    driver.getTitle();

	       }
	      
	    public void moveToProduct() {
	    	
	    	body.sendKeys(Keys.PAGE_DOWN);
	    	body.sendKeys(Keys.PAGE_DOWN);
	    	//executeJavaScript("arguements[0].scrollIntoView(true);",product1);
	    	Actions product = new Actions(driver);
	    	Action mouseOverProduct=product.moveToElement(product1).build();
	    	mouseOverProduct.perform();
	    }
	    
	    public void addToCart() {
	    	addToCart.click();
	    }
	    public void proceedToCheckout() {
	    	proceedToCheckout.click();
	    	//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    }
	    public boolean verifyPopUpAndButton() {
	    	
	    	if((popUp.isDisplayed())&&(proceedToCheckout.isDisplayed())){
	    		return true;
	    	}
	    	else {
	    		return false;
	    	}
	    }
	    	public boolean verifyCartAndPrice() {
				if ((addToCart.isDisplayed())&&(price.isEnabled())) {
					return true;
				}
				else {
	    		return false;
				}
	    	}
	    
}
