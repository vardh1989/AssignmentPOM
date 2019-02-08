package testcases.app;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import junit.framework.Assert;
import screens.app.CashOut;
import utility.Log;
import utility.TestUtil;
// Test Class for Cashout Screen Test 
public class CashOutTest extends TestBase {

	CashOut cash;
	
	//Always initialize the driver 
	@BeforeTest(alwaysRun = true)
	public void init() {
		cash = new CashOut(driver);
	}

	//Part of Cashout feature group .It taps on cash out icon on the screen
	@Test(groups = "Cashoutfeature")
	public void cashOutClickTest() {
		String alertText = cash.cashOutClick();
		if (alertText.contains("Cannot")) {
			Log.info("Insufficient Balance ");
		}
	}
	//Using data provider utility to read from Excel File. 
	//Method is part of CashoutText group
	@Test(dataProvider = "getData", groups = "CashoutText")
	public void verifyCashOutScreenText(String CashOutText) {
		Log.info("Inside verifyCashOutScreenText method");
		String textShown = cash.validateTextCashout();
		Assert.assertTrue(textShown.contains(CashOutText)); // Assert text from test and excel sheet 
	}

	@DataProvider // data provider method for verifyCashOutScreenText method
	public static Object[][] getData() throws InvalidFormatException, IOException {

		return TestUtil.readExcel("CashOut");
	}

}
