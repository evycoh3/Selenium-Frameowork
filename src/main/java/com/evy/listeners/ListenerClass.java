package com.evy.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.evy.enums.LogType;
import com.evy.logger.FrameworkLogger;
import com.evy.reports.ExtentLogger;
import com.evy.reports.ExtentReportManager;
import com.evy.utils.ScreenshotUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class ListenerClass implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite){
        ExtentReportManager.initReport();
    }
    @Override
    public void onFinish(ISuite suite){
        ExtentReportManager.flushReport();
    }
    @Override
    public void onTestStart(ITestResult result){
        ExtentReportManager.createTest(result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        FrameworkLogger.log(LogType.PASS,result.getMethod().getMethodName()+" is Pass");
    }
    @Override
    public void onTestFailure(ITestResult result){
        FrameworkLogger.log(LogType.FAIL,result.getMethod().getMethodName()+" is Failed");
        FrameworkLogger.log(LogType.FAIL,result.getThrowable().toString());
        FrameworkLogger.log(LogType.FAIL, Arrays.toString(result.getThrowable().getStackTrace()));
        ExtentLogger.fail("screen shot",true);
    }
    @Override
    public void onTestSkipped(ITestResult result){
        FrameworkLogger.log(LogType.SKIP,result.getMethod().getMethodName()+" is skipped");
        ExtentLogger.skip("screenshot: ",true);
    }

}

