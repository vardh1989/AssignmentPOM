package utility;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.BeforeSuite;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumServer {

	// Starting the Appium Server

	public static AppiumDriverLocalService service;

	// Specify path of node and Appium from local system.
	public static void start() {

		service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/Cellar/node/11.9.0/bin/node"))
						.withAppiumJS(new File("/usr/local/lib/node_modules/appium")));
		service.start();

	}

	// Stopping the Appium Server

	public static void stop() throws IOException {

		service.stop();
	}

}
