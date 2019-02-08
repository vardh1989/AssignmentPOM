package screens.app;

import java.awt.Dimension;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.annotations.Until;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.Log;

public class LoginScreen extends ScreenBase {

	// To find the number of button in the login page .find the block where elements
	// present then the sub element and store in list of elements

	@AndroidFindBys({ @AndroidFindBy(id = "com.kryptolabs.android.speakerswire.stage:id/rootContainer"),
			@AndroidFindBy(className = "android.view.ViewGroup") })
	public List<AndroidElement> signInbuttons;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@instance=1]")
	public WebElement loginWithGmailID;

	//// calling driver in super class and initializing page factory elements.
	public LoginScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	// Validate number of Login Buttons available on Login Screen
	public int validateButtonCount() {
		int count = 0;

		for (AndroidElement e : signInbuttons) {
			Log.info("Element is=============== " + e);
			count++;
		}
		return count;
	}

	// Login with Gmail
	public void loginWithGmail() throws InterruptedException {
		AndroidElement signInEmail = signInbuttons.get(3);
		signInEmail.click(); // Tap on Gmail Login icon

		loginWithGmailID.click();// Taps on First Gmail id.
		Thread.sleep(2000);

	}

}