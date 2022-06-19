package com.qa.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.pageLayer.TestBase.TestBase;

public class Listnere extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
System.out.println("Pass test : "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Fail test : "+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
	
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

}
