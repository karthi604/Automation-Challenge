package Test;
import org.testng.annotations.Test;
import Pages.*;
import Others.*;
import org.testng.annotations.BeforeSuite;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;


public class Test1 {
	
	String browser = "FireFox";
	BrowserInitiate BI= new BrowserInitiate();
	
	WebDriver d=BI.browserSelect(browser);
	WebDriverWait wait = new WebDriverWait(d,5);
	ExcelRead ER;
	Screenshot s = new Screenshot();
	HomePage HP;
	LoginPage LP;
	CreatePage CP;
	Dresses DR;
	ShoppingCart SC;
	AddressPage AP;
	ShippingPage SP;
	PaymentSelectionPage PS;
	PaymentOrderPage PP;
	OrderHistoryPage OH;
	
	
@BeforeSuite
public void browserInitiation() {
	Log.startTestCase(" Test Suite");
	BI.launchUrl(d);
}
	
  @Test(priority=0)
  public void test1() throws IOException {
	  //Configurator.configure("log4j.xml");
	  
	  Log.startTestCase("TestCase_1");
	  Log.info("URL Opened");
	   HP = new HomePage(d);
	   
	   wait.until(ExpectedConditions.visibilityOf(HP.logo));
	   Assert.assertEquals(HP.getTitle().toLowerCase(), "my store");
	   Log.info("In HomePage");
	   HP.clickSignIn();
	   Log.info("Clicked on Sign in Button");
	   LP = new LoginPage(d);
	   wait.until(ExpectedConditions.visibilityOf(LP.logo));
	   Assert.assertEquals(LP.getTitle().toLowerCase(), "login - my store");
	   LP.createAccount();
	   Log.info("Random Mail Id entered and account created" );
	   CP = new CreatePage(d);
	   wait.until(ExpectedConditions.visibilityOf(CP.logo));
	   Assert.assertEquals(CP.getTitle().toLowerCase(), "login - my store");
	   CP.enterDetails();
	   Log.info("All fields entered" );
	   wait.until(ExpectedConditions.visibilityOf(CP.logo));
	   Assert.assertEquals(CP.getTitle().toLowerCase(), "my account - my store");
	   Log.info("user successfully Navigated to My Account Page" );
	   Log.endTestCase("TestCase_1");
	   	   
  }
  
  @Test(priority=1)
  public void test2() throws IOException, InterruptedException {
	  Log.startTestCase("TestCase_2");
	   CP.toHome();
	   Log.info("Successfully Navigated to Home Page" );
	   HP.clickDresses();
	   Log.info("Clicked on Dresses" );
	   DR= new Dresses(d);
	   wait.until(ExpectedConditions.visibilityOf(DR.logo));
	   Assert.assertEquals(DR.getTitle().toLowerCase(), "dresses - my store");
	   DR.moveToProduct();
	   Assert.assertTrue(DR.verifyCartAndPrice(), "Add to Cart button or Price not Present");
	   Log.info("Add to Cart button and Price Present" );
	   DR.addToCart();
	   Log.info("Add to Cart clicked" );
	   wait.until(ExpectedConditions.visibilityOf(DR.popUp));
	   Assert.assertTrue(DR.verifyPopUpAndButton(), "Issue in Pop-up or Proceed button");
	   Log.info("Pop up with Proceed to checkout is displayed " );
	   DR.proceedToCheckout();
	   SC= new ShoppingCart(d);
	   wait.until(ExpectedConditions.visibilityOf(SC.logo));
	   Assert.assertEquals(SC.getTitle().toLowerCase(), "order - my store");
	   SC.clickProceed();
	   Log.info("Order Completed" );
	   AP= new AddressPage(d);
	   wait.until(ExpectedConditions.visibilityOf(AP.logo));
	   Assert.assertEquals(AP.getTitle().toLowerCase(), "order - my store");
	   AP.getBillingAddress();
	   AP.getDeliveryAddress();
	   Assert.assertTrue(AP.compareAddress());
	   Log.info("Delivery address is same as Billing address");
	   AP.clickProceed();
	   SP= new ShippingPage(d);
	   wait.until(ExpectedConditions.visibilityOf(SP.logo));
	   Assert.assertEquals(SP.getTitle().toLowerCase(), "order - my store");
	   Assert.assertFalse(SP.checkBoxCheck());
	   //SP.checkTC();
	   SP.clickProceed();
	   Log.info("Didn’t check the check box on Shipping page and click on Proceed to checkout");
	   wait.until(ExpectedConditions.visibilityOf(SP.error));
	   Assert.assertEquals(SP.getAlertMsg(), "You must agree to the terms of service before continuing.");
	   Log.info("Error Message displayed as expected");
	   SP.dismissAlert();
	   //s.snip(d);
	   Thread.sleep(2000);
	   wait.until(ExpectedConditions.visibilityOf(SP.layOver));
	   SP.checkTC();
	   //d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	   Assert.assertTrue(SP.checkBoxCheck());
	   //s.snip(d);
	   wait.until(ExpectedConditions.visibilityOf(SP.proceedToCheckout));
	   SP.clickProceed();
	   Log.info("Checked the checkbox and clicked on Proceed to checkout button");
	   PS=new PaymentSelectionPage(d);
	   wait.until(ExpectedConditions.visibilityOf(PS.logo));
	   Assert.assertEquals(PS.getTitle().toLowerCase(), "order - my store");
	   PS.selectPayment();
	   Log.info("Pay by BankWire Selected");
	   wait.until(ExpectedConditions.visibilityOf(PS.logo));
	   Assert.assertEquals(PS.getTitle().toLowerCase(), "my store");
	   Assert.assertEquals(PS.getPageHeading().toLowerCase(),"bank-wire payment.");
	   Log.info("Bank-wire payment is displayed on payment page");
	   PS.confirmOrder();
	   Log.info("Confirmed the order");
	   PP=new PaymentOrderPage(d);
	   wait.until(ExpectedConditions.visibilityOf(PP.logo));
	   Assert.assertEquals(PP.getTitle().toLowerCase(), "order confirmation - my store");
	   String price=PP.getPrice();
	   String ref=PP.getReferenceId();
	   PP.backToOrders();
	   Log.info("Clicked on Back to orders");
	   OH= new OrderHistoryPage(d);
	   wait.until(ExpectedConditions.visibilityOf(OH.logo));
	   Assert.assertEquals(OH.getTitle().toLowerCase(), "order history - my store");
	   Assert.assertTrue(OH.matchReferenceId(ref, price));
	   Log.info("Order reference, price and date of the order placed in above steps is displayed");
	   OH.takeScreenshot();
	   Log.info("Screenshot taken and can be found under project folder 'SS.png'");
	   Log.endTestCase("TestCase_2");
	   
  }
  
  @AfterSuite
  public void afterSuite() throws IOException {
	  
	  d.quit();
	  Log.info(" Browsers Tear down");
	  Log.endTestCase(" Test Suite");
  }

}
