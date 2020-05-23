package Others;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserInitiate {
	
	public String url = "http://automationpractice.com/index.php";
	 public String chromeDriverPath = "./chromedriver.exe";
	 public String firefoxDriverPath = "./geckodriver.exe";
	 
	 public WebDriver driver ; 

	public WebDriver browserSelect(String browser) {
	if (browser.equalsIgnoreCase("chrome")){ 
		   System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		   driver= new ChromeDriver();
	  }
	  else if (browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		driver = new FirefoxDriver();
	  }
	return driver;
	}
	public void launchUrl(WebDriver driver) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
}
