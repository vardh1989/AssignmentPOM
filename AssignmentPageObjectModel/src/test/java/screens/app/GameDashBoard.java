package screens.app;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GameDashBoard extends ScreenBase {

	// Using PageFactory to locate the element on the page
	@AndroidFindBy(id = "com.kryptolabs.android.speakerswire.stage:id/coins_Img")
	public WebElement cashOutButton;

	// calling driver in super class and initializing page factory elements.
	public GameDashBoard(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	// Tap on cash out button on game page
	public void cashOutBtnOnTrivia() {
		cashOutButton.click();
	}

}
