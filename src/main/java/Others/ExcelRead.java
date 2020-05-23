package Others;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelRead {
	
	
	public String firstName;
	public String lastName;
	public String company;
	public String addLine1;
	public String addLine2;
	public String city;
	public String state;
	public String postcode;
	public String country;
	public String addInfo;
	public String phone;
	public String mobile;
	public String alias;


	public ExcelRead() throws IOException {
	FileInputStream input1 = new FileInputStream(new File("C:\\Users\\N Gnanasekaran\\Desktop\\Selenium\\Eclipse_Workspace\\AutoChallenge\\src\\main\\resources\\Excel\\Input.xlsx"));
	Workbook newWork = new XSSFWorkbook(input1);
	
	
	Sheet sheetI= newWork.getSheet("Sheet1");
	Row rowI= sheetI.getRow(1);
	
	 firstName=(rowI.getCell(0)).toString();
	 lastName=(rowI.getCell(1)).toString();
	 company=(rowI.getCell(2)).toString();
	 addLine1=(rowI.getCell(3)).toString();
	 addLine2=(rowI.getCell(4)).toString();
	 city=(rowI.getCell(5)).toString();
	 state=(rowI.getCell(6)).toString();
	 postcode=(rowI.getCell(7)).toString();
	 country=(rowI.getCell(8)).toString();
	 addInfo=(rowI.getCell(9)).toString();
	 phone=(rowI.getCell(10)).toString();
	 mobile=(rowI.getCell(11)).toString();
	 alias=(rowI.getCell(12)).toString();

	 newWork.close();
	input1.close();
	}
}
