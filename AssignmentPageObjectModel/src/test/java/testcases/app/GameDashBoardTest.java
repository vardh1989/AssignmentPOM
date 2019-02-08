package testcases.app;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import screens.app.GameDashBoard;

// Class for GameDashBoard Page Tests
public class GameDashBoardTest extends TestBase {
	
	GameDashBoard dashboard;
	
	//Always initialize the driver 
	@BeforeTest(alwaysRun=true)
	public void init()
	{
		dashboard=new GameDashBoard(driver);
	}
	
	// Method is part of CashoutText,Cashoutfeature suite groups
	@Test(groups= {"CashoutText","Cashoutfeature"})
	public void tapCashout()
	{
		dashboard.cashOutBtnOnTrivia();
	}

}