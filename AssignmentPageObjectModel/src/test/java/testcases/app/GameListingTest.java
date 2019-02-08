package testcases.app;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import screens.app.GameListing;

public class GameListingTest extends TestBase {
	
	GameListing listing;
	//Always initialize the driver 
	@BeforeTest(alwaysRun=true)
	public void init()
	{
		listing =new  GameListing(driver);
		
	}
	
	// Method is part of CashoutText,Cashoutfeature group suite
	@Test(groups={"CashoutText","Cashoutfeature"})
	public void triviaClick()
	{
		listing.triviaClick();
	}
}
