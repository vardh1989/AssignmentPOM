package testcases.app;
 
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import screens.app.LoginScreen;
import utility.Log;
import utility.TestUtil;

@Test
public class LoginTest extends TestBase{
	LoginScreen login;
	
	@BeforeTest(alwaysRun=true)
	public void init()
	{
		login=new LoginScreen(driver);
	}
	
	@Test(priority=1,dataProvider="getData",groups= {"smokeforLogin"})
	public void validateLoginButton(String LoginButtonCount)
	{
		
		  int btn_count= login.validateButtonCount();
		  int lbc = Integer.parseInt(LoginButtonCount);
		  Log.info("Login Options button are = "+btn_count);
		  Log.info("Number of Buttons on the Login Page should be"+LoginButtonCount);
		  Assert.assertEquals(btn_count,lbc);		
	}
	
	//In SmokeforLogin,it will be executed after validateLoginButton method(priority=2)
	//
	@Test(priority=2,groups={"smokeforLogin", "Cashoutfeature","CashoutText"})
	public void signupWithGmail() throws InterruptedException
	{	
		login.loginWithGmail();
		Log.info("NOW ON GAME PAGE");		
	}
	
	//Data Provider for validateLoginButton method. Reads LoginScreen sheet from Excel sheet
	@DataProvider(name="getData")
	public static Object[][] getData() throws InvalidFormatException, IOException{
		
		
	return TestUtil.readExcel("LoginScreen");
	}
	
}
