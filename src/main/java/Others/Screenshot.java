package Others;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	String path = "./SS.png";
	public void snip(WebDriver driver) throws IOException {
		  TakesScreenshot screenShot =((TakesScreenshot)driver);

		    //Call getScreenshotAs method to create image file

		            File SrcFile=screenShot.getScreenshotAs(OutputType.FILE);

		        //Move image file to new destination

		            File DestFile=new File(path);

		            //Copy file at destination

		            FileUtils.copyFile(SrcFile, DestFile);
	  }
}
