package base;

/*@author=Vardhman Golchha*/
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

//All Screen classes will extend this class
//Contains common methods available for the screens
public class ScreenBase {

	public AppiumDriver<MobileElement> driver;

	public WebDriverWait wait;

	public ScreenBase(AppiumDriver<MobileElement> driver) {

		this.driver = driver;

	}

	// Explicit wait for locator element till it is present
	public void waitforElement(long duration, String locator) {

		wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));

	}

	// To hide keyboard
	public void hideKeyboard() {

		driver.hideKeyboard();
	}

}
