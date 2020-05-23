package Pages;

import Others.ExcelRead;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatePage {
	
	
	
	WebDriver driver;
	
	@FindBy(id="id_gender1")
	WebElement genderMale;
	@FindBy(id="id_gender2")
	WebElement genderFemale;
	@FindBy(id="customer_firstname")
	WebElement firstName;
	@FindBy(id="customer_lastname")
	WebElement lastName;
	@FindBy(id="passwd")
	WebElement password;
	@FindBy(id="days")
	WebElement day;
	@FindBy(id="months")
	WebElement month;
	@FindBy(id="years")
	WebElement year;
	@FindBy(id="newsletter")
	WebElement newsletter;
	@FindBy(id="optin")
	WebElement optin;
	
	
	@FindBy(id="company")
	WebElement company;
	@FindBy(id="address1")
	WebElement addLine1;
	@FindBy(id="address2")
	WebElement addLine2;
	@FindBy(id="city")
	WebElement city;
	@FindBy(id="id_state")
	WebElement state ;
	@FindBy(id="postcode")
	WebElement postcode;
	@FindBy(id="id_country")
	WebElement country;
	@FindBy(id="other")
	WebElement addInfo;
	@FindBy(id="phone")
	WebElement phone;
	@FindBy(id="phone_mobile")
	WebElement mobile;
	@FindBy(id="alias")
	WebElement alias;
	@FindBy(id="submitAccount")
	WebElement submitAccount;
	@FindBy(xpath="//*[@id='header_logo']/a/img")
	public
    WebElement logo;
	@FindBy(className="home")
	WebElement home;

	public CreatePage(WebDriver driver) {
		this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
	}
	
	public String getTitle(){
    	
	     return    driver.getTitle();

	    }
	public void toHome() {
		home.click();
	}
	public void select() {
		Select select = new Select(state);
        select.selectByVisibleText("Alaska");
	}
	
	public void enterDetails() throws IOException {
		ExcelRead excel = new Others.ExcelRead();
		this.genderFemale.click();
		this.firstName.sendKeys(excel.firstName);
		this.lastName.sendKeys(excel.lastName);
		this.password.sendKeys("12345f");
		Select s= new Select(day);
		s.selectByIndex(2);
		Select s1= new Select(month);
		s1.selectByIndex(2);
		Select s2= new Select(year);
		s2.selectByIndex(22);
		newsletter.click();
		this.company.sendKeys(excel.company);
		this.addLine1.sendKeys(excel.addLine1);
		this.addLine2.sendKeys(excel.addLine2);
		this.city.sendKeys(excel.city);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//this.state.selectByIndex(2);
		select();
		this.postcode.sendKeys(excel.postcode);
		//this.country.selectByValue("21");
		this.addInfo.sendKeys(excel.addInfo);
		this.phone.sendKeys(excel.phone);
		this.mobile.sendKeys(excel.mobile);
		this.alias.sendKeys(excel.alias);
		this.submitAccount.click();

	}
	

}
