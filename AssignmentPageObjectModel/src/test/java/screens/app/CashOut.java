package screens.app;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.Log;

public class CashOut extends ScreenBase {
	// Using PageFactory to locate the element on the page
	@AndroidFindBy(id = "com.kryptolabs.android.speakerswire.stage:id/info_tv")
	public WebElement cashout_text;

	@AndroidFindBy(id = "com.kryptolabs.android.speakerswire.stage:id/cashout_btn")
	public WebElement cashBtn;

	@AndroidFindBy(id = "com.kryptolabs.android.speakerswire.stage:id/balance_tv")
	public WebElement balanceInfo;

	@AndroidFindBy(id = "android:id/alertTitle")
	public WebElement cantCashout;

	// calling driver in super class and initializing page factory elements.
	public CashOut(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// Tap on cash out button option and return string to its calling test method
	public String cashOutClick() {
		String cashoutBalance = balanceInfo.getText();

		cashBtn.click();
		String popUpText = cantCashout.getText();
		return popUpText;

	}

	// Take text on the cash out page and return string to its calling test method
	public String validateTextCashout() {
		String textToVerify = cashout_text.getText();
		Log.info("Cashout text is " + textToVerify);
		return textToVerify;

	}

}
