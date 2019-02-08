package utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.apache.poi.hssf.usermodel.HSSFCellStyle; 
import org.apache.poi.hssf.usermodel.HSSFDateUtil; 
import org.apache.poi.hssf.usermodel.HSSFHyperlink; 
import org.apache.poi.hssf.util.HSSFColor; 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors; 
import org.apache.poi.xssf.usermodel.*;
import java.io.*; 
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import base.TestBase;

public class TestUtil extends TestBase {

	public static String destDir;
	public static DateFormat dateFormat;
	public static String destFile;
	public static String mailscreenshotpath;
	public static String Excel=System.getProperty("user.dir") + "/src/test/resources/properties/testdata.xlsx";


	//Excel Reader to read data from ExcelSheet ,Use xyz.xslx file
	public static Object[][] readExcel(String sheetName) throws InvalidFormatException, IOException {
        FileInputStream file= new FileInputStream(Excel);
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        int column = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][column];
        for (int i = 1; i <= rowCount; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < column; j++) {
                XSSFCell cell = row.getCell(j);
                DataFormatter formatter = new DataFormatter();
                String val = formatter.formatCellValue(cell);
                data[i - 1][j] = val;
            }
        }

        return data;
    }

	
	//Method to take screenshot on Failure of testcase. 
	public static void takeScreenShot() throws IOException {

		// directory
		destDir = "test-output/html";

		// capturing screenshot
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Set date
		dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

		// create folder
		new File(destDir).mkdir();

		destFile = dateFormat.format(new Date()) + ".png";
		mailscreenshotpath = destDir + "/" + destFile;
		System.out.println(" mailscreenshotpath : "+mailscreenshotpath);
		FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));

	}

	// Take ScreenShot of particular element. 
	public static String elementScreenshot(WebElement ele) {

		File screenshotLocation = null;
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			BufferedImage fullImg = ImageIO.read(scrFile);
			// Get the location of element on the page
			Point point = ele.getLocation();
			// Get width and height of the element
			int eleWidth = ele.getSize().getWidth();
			int eleHeight = ele.getSize().getHeight();
			// Crop the entire page screenshot to get only element screenshot
			BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
			ImageIO.write(eleScreenshot, "png", scrFile);

			String fileName = "newscreenshot";

			screenshotLocation = new File("./screenshots/" + fileName + ".jpg");
			FileUtils.copyFile(scrFile, screenshotLocation);

			System.out.println(screenshotLocation.toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenshotLocation.toString();

	}

}
