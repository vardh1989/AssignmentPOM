package base;

/*@author=Vardhman Golchha */
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utility.AppiumServer;
import utility.CommonUtils;
import utility.Log;

public class TestBase {

	public static AppiumDriver<MobileElement> driver;

	public static String loadPropertyFile = "Android_Swoo.properties";

	// To initialize driver before a suite starts
	@BeforeSuite(alwaysRun = true)
	public void setUp() throws IOException, InterruptedException {

		if (driver == null) {
			AppiumServer.start();

			Log.info("Appium server started");

			if (loadPropertyFile.startsWith("IOS")) {

				Log.info("Starting on IOS");

				/*
				 * CommonUtils.loadIOSConfigProp(loadPropertyFile);
				 * CommonUtils.setIOSCapabilities(); driver = CommonUtils.getIOSDriver();
				 */

			} else if (loadPropertyFile.startsWith("Android")) {

				Log.info("Starting on Android");
				CommonUtils.loadAndroidConfigProp(loadPropertyFile);
				CommonUtils.setAndroidCapabilities();
				driver = CommonUtils.getAndroidDriver();
			}

		}

	}

	// To quit driver after the suite has run
	@AfterSuite
	public void tearDown() throws IOException {
		driver.close();
		driver.quit();
		AppiumServer.stop();

	}

}
