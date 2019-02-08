package listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utility.Log;
import utility.TestUtil;

public class CustomListeners implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	//On Test failure capture the screen shot 
	public void onTestFailure(ITestResult arg0) {


		System.setProperty("org.uncommons.reportng.escape-output", "false");
		
		try {
			TestUtil.takeScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Reporter.log("<a target='_blank' href=\""+TestUtil.destFile+"\">Capture Screenshot</a>");
		Log.error("Capture Screenshot");
		
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//If test passes then Log success message 
	public void onTestSuccess(ITestResult arg0) {


		Log.info(arg0+" has run sucessfully ");
		
	}

}
